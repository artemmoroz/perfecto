package com.quantum.steps;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.quantum.pages.LoginPage;
import com.quantum.pages.MainPage;
import com.quantum.utils.AppiumUtils;
import com.quantum.utils.ConfigurationUtils;
import com.quantum.utils.ConsoleUtils;
import com.quantum.utils.DeviceUtils;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

import static com.quantum.steps.PerfectoApplicationSteps.switchToContext;
import static com.quantum.utils.DeviceUtils.*;

//@QAFTestStepProvider
public class PerfectoExpenseAppStepDefs {

    @Given("I sigUp with email \"<userEmail>\" and password \"<userPassword>\"")


    private static void pickerwheelStep(IOSDriver driver, WebElement element, String direction, double offset) {
        Map<String, Object> params = new HashMap<>();
        params.put("order", direction);
        params.put("offset", offset);
        params.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: selectPickerWheelValue", params);
    }


    @When("I am using an AppiumDriver")
    public void testForAppiumDriver() {
        if (ConfigurationUtils.getBaseBundle().getPropertyValue("driver.name").contains("Remote"))
            ConsoleUtils.logWarningBlocks("Driver is an instance of QAFExtendedWebDriver");
        else if (AppiumUtils.getAppiumDriver() instanceof IOSDriver)
            ConsoleUtils.logWarningBlocks("Driver is an instance of IOSDriver");
        else if (AppiumUtils.getAppiumDriver() instanceof AndroidDriver)
            ConsoleUtils.logWarningBlocks("Driver is an instance of AndroidDriver");
    }

    @When("^I start Perfecto hybrid app")
    public void start_app() {
        if (AppiumUtils.getAppiumDriver() instanceof IOSDriver) {
            DeviceUtils.startApp("InvoiceApp", "name");
            switchToContext("WEBVIEW");
        } else if (AppiumUtils.getAppiumDriver() instanceof AndroidDriver) {
            DeviceUtils.startApp("Perfecto Expense Tracker Hybrid", "name");
            switchToContext("WEBVIEW");
        }
    }

    @When("^I start Perfecto native app")
    public void startNative() {
        DeviceUtils.startApp("Perfecto Expense Tracker", "name");
        switchToContext("NATIVE_APP");
    }

    @When("^I fill login form with email \"(.*?)\" and password \"(.*?)\"$")
    public void fillLoginForm(String email, String password) {

        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.login(email, password);
        //mainPage.

//        String login = "email.login.hybrid";
//        String pass = "password.login.hybrid";
//        CommonStep.click(login);
//        CommonStep.clear(login);
//        CommonStep.sendKeys(email, login);
//        CommonStep.click(pass);
//        CommonStep.clear(pass);
//        CommonStep.sendKeys(password, pass);
    }

    @When("^I fill login form with email \"(.*?)\" and password \"(.*?)\" native$")
    public void fillLoginFormNative(String email, String password) {
        String login = "email.login";
        String pass = "password.login";
        CommonStep.click(login);
        CommonStep.clear(login);
        CommonStep.sendKeys(email, login);
        CommonStep.click(pass);
        CommonStep.clear(pass);
        CommonStep.sendKeys(password, pass);
    }

    @And("^I set category to \"(.*?)\"$")
    public void setCategory(String locator) {
        CommonStep.click("add.category.hybrid");
        CommonStep.click(locator);
        CommonStep.click("ok.button.hybrid");
    }

    @And("^I submit login form")
    public void submitLoginForm() {
        new QAFExtendedWebElement("login.button.hybrid").click();
    }

    @And("^I submit login form native")
    public void submitLoginFormNative() {
        new QAFExtendedWebElement("btn.login").click();
    }

    @And("I open expense form")
    public void openExpenseForm() {
        new QAFExtendedWebElement("add.expense.button.hybrid").click();
    }

    @And("I select from pickerWheel \"(.*?)\"$")
    public void selectFromPickerWheel(String value) {
        WebElement picker = getQAFDriver().findElementByClassName("XCUIElementTypePickerWheel");
        String name = picker.getAttribute("value");
        picker.sendKeys(value);
    }

    @And("I fill expense form with mandatory fields only")
    public void fillExpenseWithMandatoryFields() {
        QAFExtendedWebElement okButton = new QAFExtendedWebElement("ok.button.hybrid");
        new QAFExtendedWebElement("add.head.hybrid").click();
        new QAFExtendedWebElement("flight.head.hybrid").click();
        okButton.click();

        new QAFExtendedWebElement("add.currency.hybrid").click();
        new QAFExtendedWebElement("usd.currency.hybrid").click();
        okButton.click();

        new QAFExtendedWebElement("add.category.hybrid").click();
        new QAFExtendedWebElement("business.categoty.hybrid").click();
        okButton.click();

        QAFExtendedWebElement amount = new QAFExtendedWebElement("add.amount.hybrid");
        amount.click();
        amount.clear();
        amount.sendKeys("2000");
    }

    @When("I open registration form")
    public void openRegistrationForm() {
        new QAFExtendedWebElement("login.hybrid").click();
    }

    @And("^I fill registration form with email \"(.*?)\" and password \"(.*?)\"$")
    public void fillRegistrationFrom(String email, String password) {
        QAFExtendedWebElement name = new QAFExtendedWebElement("name.signin.hybrid");
        name.click();
        name.clear();
        name.sendKeys(email);
        QAFExtendedWebElement mail = new QAFExtendedWebElement("email.hybrid");
        mail.click();
        mail.clear();
        mail.sendKeys(email);
        QAFExtendedWebElement pass = new QAFExtendedWebElement("password.hybrid");
        pass.click();
        pass.clear();
        pass.sendKeys(password);
        QAFExtendedWebElement confPassword = new QAFExtendedWebElement("confirm.password.hybrid");
        confPassword.click();
        confPassword.clear();
        confPassword.sendKeys(password);
    }

    @And("^I fill registration form with email \"(.*?)\" and password \"(.*?)\" native$")
    public void fillRegistrationFromNative(String email, String password) {
        QAFExtendedWebElement name = new QAFExtendedWebElement("name");
        name.click();
        name.clear();
        name.sendKeys(email);
        QAFExtendedWebElement mail = new QAFExtendedWebElement("email");
        mail.click();
        mail.clear();
        mail.sendKeys(email);
        QAFExtendedWebElement pass = new QAFExtendedWebElement("password");
        pass.click();
        pass.clear();
        pass.sendKeys(password);
        QAFExtendedWebElement confPassword = new QAFExtendedWebElement("confirm.password");
        confPassword.click();
        confPassword.clear();
        confPassword.sendKeys(password);
    }

    @And("^I fill expense with \"(.*?)\" head, \"(.*?)\" category and \"(.*?)\" amount$")
    public void fillExpense(String head, String category, String amount) {
        CommonStep.click("add.head");
        selectFromPickerWheel(head);
        CommonStep.click("input.amount");
        CommonStep.sendKeys(amount, "input.amount");
        CommonStep.click("add.category");
        selectFromPickerWheel(category);
    }

    @And("^I fill expense with \"(.*?)\" head and \"(.*?)\" category$")
    public void fillExpense(String head, String category) {
        CommonStep.click("add.head");
        selectFromPickerWheel(head);
        CommonStep.click("add.category");
        selectFromPickerWheel(category);
    }

    @And("I add image")
    public void addImg() {
        startImageInjection("PUBLIC:images/ing-cc-edited.png", "io.perfecto.expense.tracker", "name");
        stopImageInjection();
    }

    @When("I logout from expenses list")
    public void logoutFromExpensesList() {
        CommonStep.click("side.bar");
        CommonStep.click("logout.button");
    }

    @When("I go to expenses list")
    public void goToExpensesList() {
        selectElement("Expenses");
    }

    @And("I select flight expense")
    public void selectExpenseByName() {
        CommonStep.click("flight.expense");
    }

    @And("I delete selected expense")
    public void deleteSelectedExpense() {
        CommonStep.click("side.bar");
        CommonStep.click("done.button");
    }

    @Then("^I verify username \"(.*?)\"$")
    public void verifyUserName(String username) {
        CommonStep.click("side.bar");
        CommonStep.verifyText(username, username);
    }

    @And("I submit registration form")
    public void submitRegistrationForm() {
        new QAFExtendedWebElement("registration.button.hybrid").click();
    }

    @And("I submit registration form native")
    public void submitRegistrationFormNative() {
        new QAFExtendedWebElement("btn.register").click();
    }

    @And("I save expense native")
    public void saveExpenseNative() {
        CommonStep.click("edit.date");
        selectElement("Save");
        selectElement("OK");
    }

    @And("^I fill date with \"(.*?)\"$")
    public void fillDate(String date) {
        CommonStep.click("edit.date");
        selectFromPickerWheel(date);
    }

    @And("I open edit form")
    public void openEditForm() {
        new QAFExtendedWebElement("edit.button.hybrid").click();
    }

    @Then("I open user profile")
    public void openUserName() {
        new QAFExtendedWebElement("registration.button.hybrid").click();
    }

    @When("I select element \"(.*?)\"$")
    public void selectElement(String element) {
        Map<String, Object> params = new HashMap<>();
        params.put("label", element);
        params.put("ignorecase", "nocase");
        getQAFDriver().executeScript("mobile:button-text:click", params);
    }

    @And("I save expense")
    public void saveExpense() {
        new QAFExtendedWebElement("save.expense.button.hybrid").click();
    }

    @And("I submit expense")
    public void submitExpense() {
        new QAFExtendedWebElement("save.expense.button.hybrid").click();
    }

    @And("I scroll to down")
    public void scrollDownScreen() {
        DeviceUtils.swipe("50%,60%", "50%,20%");
    }

    @After
    public void after() {
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        System.out.println("AFTER");
        System.out.println("------------------------------");
        System.out.println("------------------------------");
    }

    @When("click Add Room")
    public void clickAddRoom() {
        CommonStep.click("btn.create");
    }
}
