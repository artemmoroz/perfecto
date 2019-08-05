package com.quantum.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

/**
 * Created 29-Jul-19
 *
 * @author <a href="mailto:ArtemMoroz@coherentsolutions.com">Artem Moroz</a>
 * @version 1.0
 */
public class ExpenseListItem implements PerfectoComponent {

    @FindBy(locator = "main.elist.check.checkbox")
    private QAFWebElement checkbox;
    @FindBy(locator = "main.elist.title.text")
    private QAFWebElement title;
    @FindBy(locator = "main.elist.price.text")
    private QAFWebElement price;
}
