package com.quantum.actions;

import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.components.select.PerfectoSelect;
import com.quantum.components.select.SelectWeb;

/**
 * Created 31-Jul-19
 *
 * @author <a href="mailto:ArtemMoroz@coherentsolutions.com">Artem Moroz</a>
 * @version 1.0
 */
public class HybridAndroidActions extends CustomActions {
    @Override
    public String getAppName() {
        return "Perfecto Expense Tracker Hybrid";
    }

    @Override
    public String getAppContextType() {
        return "WEBVIEW";
    }

    @Override
    public PerfectoSelect getSelect(QAFWebElement element) {
        return new SelectWeb(element);
    }

    @Override
    public void waitForPresenceOfElement(QAFWebElement element) {

    }

    @Override
    public void clickOnText(String text) {

    }
}
