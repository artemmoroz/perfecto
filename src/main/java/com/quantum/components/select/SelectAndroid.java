package com.quantum.components.select;

import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

import java.util.HashMap;
import java.util.Map;

import static com.quantum.utils.DeviceUtils.getQAFDriver;

/**
 * Created 29-Jul-19
 *
 * @author <a href="mailto:ArtemMoroz@coherentsolutions.com">Artem Moroz</a>
 * @version 1.0
 */
public class SelectAndroid extends PerfectoSelect {

    public SelectAndroid(QAFWebElement element) {
        super(element);
    }

    @Override
    public void selectByValue(String value) {
        Map<String, Object> params = new HashMap<>();
        params.put("label", value);
        params.put("ignorecase", "nocase");
        getQAFDriver().executeScript("mobile:button-text:click", params);
    }

    @Override
    public void selectByIndex(int index) {

    }

    @Override
    public String getSelectedValue() {
        return null;
    }
}
