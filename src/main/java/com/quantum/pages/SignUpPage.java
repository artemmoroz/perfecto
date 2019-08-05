package com.quantum.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

/**
 * Created 26-Jul-19
 *
 * @author <a href="mailto:ArtemMoroz@coherentsolutions.com">Artem Moroz</a>
 * @version 1.0
 */
public class SignUpPage extends AbstractBasePage {

    @FindBy(locator = "signUp.name.field")
    private QAFWebElement userNameField;
    @FindBy(locator = "signUp.email.field")
    private QAFWebElement userEmailField;
    @FindBy(locator = "signUp.password.field")
    private QAFWebElement passwordField;
    @FindBy(locator = "signUp.confirm_password.field")
    private QAFWebElement confirmPasswordField;
    @FindBy(locator = "signUp.currency.select")
    private QAFWebElement currencySelect;
    @FindBy(locator = "signUp.currency_list.list")
    private QAFWebElement currencyList;

    @FindBy(locator = "signUp.register.button")
    private QAFWebElement registerButton;

    public LoginPage register(String userName, String userEmail, String password, String currency) {
        setFieldValue(userNameField, userName);
        setFieldValue(userEmailField, userEmail);
        //???scrollDownScreen();
        setFieldValue(passwordField, password);
        setFieldValue(confirmPasswordField, password);
        //todo currency
        //currencySelect.click();
        //currencyList.getChids...
        registerButton.click();
        return new LoginPage();
    }


}
