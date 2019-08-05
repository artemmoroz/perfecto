package com.quantum.components;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

/**
 * Created 02-Aug-19
 *
 * @author <a href="mailto:ArtemMoroz@coherentsolutions.com">Artem Moroz</a>
 * @version 1.0
 */
public class Menu extends PerfectoComponent {

    @FindBy(locator = "main.menu.logout.button")
    private QAFWebElement logout;


    public void logout() {
        logout.waitForPresent(ConfigurationManager.getBundle().getInt("selenium.wait.timeout"));
        logout.click();
    }
}
