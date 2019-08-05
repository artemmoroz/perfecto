package com.quantum.components.select;

import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

/**
 * Created 29-Jul-19
 *
 * @author <a href="mailto:ArtemMoroz@coherentsolutions.com">Artem Moroz</a>
 * @version 1.0
 */
public class SelectWeb extends PerfectoSelect {

    public SelectWeb(QAFWebElement element) {
        super(element);
    }

    @Override
    public void selectByValue(String value) {
        //
    }

    @Override
    public void selectByIndex(int index) {

    }

    @Override
    public String getSelectedValue() {
        return null;
    }
}
