package com.quantum.actions;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.components.select.PerfectoSelect;
import com.quantum.components.select.SelectIos;

import java.util.HashMap;
import java.util.Map;

import static com.quantum.utils.DeviceUtils.getQAFDriver;

/**
 * Created 31-Jul-19
 *
 * @author <a href="mailto:ArtemMoroz@coherentsolutions.com">Artem Moroz</a>
 * @version 1.0
 */
public class IOSActions extends CustomActions {
    @Override
    public String getAppName() {
        return "Perfecto Expense Tracker";
    }

    @Override
    public String getAppContextType() {
        return "NATIVE_APP";
    }

    @Override
    public PerfectoSelect getSelect(QAFWebElement element) {
        return new SelectIos(element);
    }

    @Override
    public void waitForPresenceOfElement(QAFWebElement element) {
        element.waitForPresent(ConfigurationManager.getBundle().getInt(WAIT));
    }

    @Override
    public void clickOnText(String text) {
        Map<String, Object> params = new HashMap<>();
        params.put("label", text);
        params.put("ignorecase", "nocase");
        getQAFDriver().executeScript("mobile:button-text:click", params);
    }
}
