package com.quantum.components.select;

import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.actions.PerfectoCustomActions;
import com.quantum.utils.AppType;
import com.quantum.utils.DeviceUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
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

    public void hybridIosSelectByValue(String valueLocator, String value) {
        String categoryLocation = getLocation(driver.findElementByXPath("//*[contains(@value, \'"+ valueLocator +"\')]"));

        DeviceUtils.touch(categoryLocation);
        driver.findElement(
                By.xpath("//XCUIElementTypeOther[contains(@label, '"+ value +"')]")
        ).click();
    }

    private String getLocation(QAFWebElement element) {
        Point location = element.getLocation();
        int x = location.x * 2 + 20;
        int y = location.y * 2 + 20;

        return ""+ x +","+ y +"";
    }
}
