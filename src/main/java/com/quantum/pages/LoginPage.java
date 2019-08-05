package com.quantum.pages;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

/**
 * Created 26-Jul-19
 *
 * @author <a href="mailto:ArtemMoroz@coherentsolutions.com">Artem Moroz</a>
 * @version 1.0
 */
public class LoginPage extends AbstractBasePage {

    @FindBy(locator = "signIn.email.field")
    private QAFWebElement userEmailField;
    @FindBy(locator = "signIn.password.field")
    private QAFWebElement passwordField;
    @FindBy(locator = "signIn.login.button")
    private QAFWebElement loginButton;
    @FindBy(locator = "signIn.signUp.button")
    private QAFWebElement signUpButton;


    public LoginPage() {
        userEmailField.waitForPresent(ConfigurationManager.getBundle().getInt(WAIT));
    }

    public MainPage login(String email, String password) {

        setFieldValue(userEmailField, email);
        setFieldValue(passwordField, password);
        loginButton.click();
        return new MainPage();
    }

    public void moveToSignUp() {
        signUpButton.click();
    }
}
