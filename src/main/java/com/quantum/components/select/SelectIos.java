package com.quantum.components.select;

import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import org.openqa.selenium.WebElement;

import static com.quantum.utils.DeviceUtils.getQAFDriver;

/**
 * Created 29-Jul-19
 *
 * @author <a href="mailto:ArtemMoroz@coherentsolutions.com">Artem Moroz</a>
 * @version 1.0
 */
public class SelectIos extends PerfectoSelect {

    public SelectIos(QAFWebElement element) {
        super(element);
    }

    public SelectIos() {

    }

    @Override
    public void selectByValue(String value) {
        WebElement picker = getQAFDriver().findElementByClassName("XCUIElementTypePickerWheel");
        picker.sendKeys(value);
    }

    @Override
    public void selectByIndex(int index) {

    }

    @Override
    public String getSelectedValue() {
        return null;
    }
}
