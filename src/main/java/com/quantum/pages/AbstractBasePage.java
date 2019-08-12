package com.quantum.pages;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.actions.PerfectoCustomActions;
import com.quantum.utils.AppType;
import com.quantum.utils.DeviceUtils;

/**
 * Created 26-Jul-19
 *
 * @author <a href="mailto:ArtemMoroz@coherentsolutions.com">Artem Moroz</a>
 * @version 1.0
 */
public class AbstractBasePage extends WebDriverBaseTestPage<WebDriverTestPage> {

    public static final String WAIT = "selenium.wait.timeout";

    public AbstractBasePage() {
        if (PerfectoCustomActions.getInstance().getType() == AppType.HYBRID_IOS) {
            DeviceUtils.doubleTouch("1,100");
        }
    }

    @Override
    protected void openPage(PageLocator locator, Object... args) {
        //default method
    }

    protected void setFieldValue(QAFWebElement element, String value) {
        element.click();
        element.clear();
        element.sendKeys(value);
    }

}
