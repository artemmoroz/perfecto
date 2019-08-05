package com.quantum.components.select;

import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.components.PerfectoComponent;

/**
 * Created 29-Jul-19
 *
 * @author <a href="mailto:ArtemMoroz@coherentsolutions.com">Artem Moroz</a>
 * @version 1.0
 */
public abstract class PerfectoSelect implements PerfectoComponent {

    protected QAFWebElement element;

    public PerfectoSelect(QAFWebElement element) {
        this.element = element;
    }

    public abstract void selectByValue(String value);

    public abstract void selectByIndex(int index);

    public abstract String getSelectedValue();

}
