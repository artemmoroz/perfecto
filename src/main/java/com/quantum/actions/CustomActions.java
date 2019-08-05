package com.quantum.actions;

import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.components.select.PerfectoSelect;
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

    public abstract String getAppName();

    public abstract String getAppContextType();

    public void startPerfectoApp() {
        DeviceUtils.startApp(getAppName(), "name");
        switchToContext(getAppContextType());
    }

    public abstract PerfectoSelect getSelect(QAFWebElement element);

    public void clickOnText(String text) {
        Map<String, Object> params = new HashMap<>();
        params.put("label", text);
        params.put("ignorecase", "nocase");
        getQAFDriver().executeScript("mobile:button-text:click", params);
    }

}
