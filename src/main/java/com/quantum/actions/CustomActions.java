package com.quantum.actions;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.components.select.PerfectoSelect;
import com.quantum.pages.MainPage;
import com.quantum.utils.AppiumUtils;
import com.quantum.utils.ConfigurationUtils;
import com.quantum.utils.ConsoleUtils;
import com.quantum.utils.DeviceUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

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

    public abstract String getAppName();

    public abstract String getAppContextType();

    public void startPerfectoApp() {
        if (ConfigurationUtils.getBaseBundle().getPropertyValue("driver.name").contains("Remote"))
            ConsoleUtils.logWarningBlocks("Driver is an instance of QAFExtendedWebDriver");
        else if (AppiumUtils.getAppiumDriver() instanceof IOSDriver)
            ConsoleUtils.logWarningBlocks("Driver is an instance of IOSDriver");
        else if (AppiumUtils.getAppiumDriver() instanceof AndroidDriver)
            ConsoleUtils.logWarningBlocks("Driver is an instance of AndroidDriver");

        DeviceUtils.closeApp(getAppName(), "name");
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

    public void clickOnText(String text) {
        Map<String, Object> params = new HashMap<>();
        params.put("label", text);
        params.put("ignorecase", "nocase");
        getQAFDriver().executeScript("mobile:button-text:click", params);
    }

}
