package com.quantum.components;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

/**
 * Created 02-Aug-19
 *
 * @author <a href="mailto:ArtemMoroz@coherentsolutions.com">Artem Moroz</a>
 * @version 1.0
 */
public class Menu implements PerfectoComponent {

    @FindBy(locator = "main.menu.logout.button")
    private QAFWebElement logout;


    public void logout() {
        logout.click();
    }
}
