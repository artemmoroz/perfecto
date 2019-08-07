package com.quantum.actions;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.components.select.PerfectoSelect;
import com.quantum.pages.MainPage;
import com.quantum.utils.DeviceUtils;

import java.util.HashMap;
import java.util.Map;

import static com.quantum.steps.PerfectoApplicationSteps.switchToContext;
import static com.quantum.utils.DeviceUtils.getQAFDriver;

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

    public abstract PerfectoSelect getSelect(QAFWebElement element);

}
