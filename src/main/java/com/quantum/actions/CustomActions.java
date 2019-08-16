package com.quantum.actions;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.components.select.PerfectoSelect;
import com.quantum.pages.MainPage;
import com.quantum.utils.ConfigurationUtils;
import com.quantum.utils.DeviceUtils;
import com.quantum.utils.ReportUtils;

import java.io.IOException;

import static com.quantum.steps.PerfectoApplicationSteps.switchToContext;
import static com.quantum.utils.PerfectoLabUtils.uploadMedia;

/**
 * Created 31-Jul-19
 *
 * @author <a href="mailto:ArtemMoroz@coherentsolutions.com">Artem Moroz</a>
 * @version 1.0
 */
public abstract class CustomActions {

    public static final String WAIT = "selenium.wait.timeout";

    public abstract String getAppName();

    public abstract String getAppContextType();

    public abstract void waitForPresenceOfElement(QAFWebElement element);

    public abstract void clickOnText(String text);

    public abstract PerfectoSelect getSelect(QAFWebElement element);

    public void startPerfectoApp() {
//        try {
//            DeviceUtils.closeApp(getAppName(), "name");
//        } catch (Exception ex) {
//            //
//        }
        DeviceUtils.startApp(getAppName(), "name");
        switchToContext(getAppContextType());
        try {
            if (CommonStep.verifyPresent("signIn.login.button")) {
                //everything is fine, we are on login page
            } else {
                try {
                    MainPage mainPage = new MainPage();
                    mainPage.logOut();
                } catch (Exception ex) {
                    //this is normal, just close the upp and refresh its state
                }
            }
        } catch (Exception ex) {

        }


    }

    public void rotateDeviceLandscape() {
        DeviceUtils.rotateDevice("landscape", "state");
    }

    public void rotateDevicePortait() {
        DeviceUtils.rotateDevice("portrait", "state");
    }



    public void sendFile(String filePath, String fileName) {
        try {
            uploadMedia(
                    "ps.perfectomobile.com",
                    ConfigurationUtils.getBaseBundle().getPropertyValue("perfecto.capabilities.securityToken"),
                    filePath,
                    "PUBLIC:images/" + fileName
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateReport() {
        try {
            ReportUtils.generateTestReport(ConfigurationUtils.getBaseBundle().getPropertyValue("executionId"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
