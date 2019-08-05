package com.quantum.actions;

import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.components.select.PerfectoSelect;
import com.quantum.components.select.SelectAndroid;

/**
 * Created 31-Jul-19
 *
 * @author <a href="mailto:ArtemMoroz@coherentsolutions.com">Artem Moroz</a>
 * @version 1.0
 */
public class AndroidActions extends CustomActions {


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
        return new SelectAndroid(element);
    }
}
