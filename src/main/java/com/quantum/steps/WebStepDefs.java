package com.quantum.steps;

import com.qmetry.qaf.automation.step.CommonStep;
import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

@QAFTestStepProvider
public class WebStepDefs {
    @Given("^I am on Perfecto Page$")
    public void I_am_on_Perfecto_Page() throws Throwable {
        new WebDriverTestBase().getDriver().get("http://expensetracker.perfectomobile.com");
    }

    @When("^I go to signup page$")
    public void I_search_for() throws Throwable {
        QAFExtendedWebElement singupBtnElement = new QAFExtendedWebElement("singup.button");
        singupBtnElement.click();
    }

    @When("^I fill registration form with email \"(.*?)\" and password \"(.*?)\" web$")
    public void I_fill_registration_form(String email, String password) throws Throwable {
        QAFExtendedWebElement nameFieldElement = new QAFExtendedWebElement("name.input.registration");
        QAFExtendedWebElement emailFieldElement = new QAFExtendedWebElement("email.input.registration");
        QAFExtendedWebElement passwordFieldElement = new QAFExtendedWebElement("password.input.registration");
        QAFExtendedWebElement confpasswordFieldElement = new QAFExtendedWebElement("confpassword.input.registration");
        QAFExtendedWebElement registerButtonElement = new QAFExtendedWebElement("register.button");
        nameFieldElement.click();
        nameFieldElement.clear();
        nameFieldElement.sendKeys(email);
        emailFieldElement.click();
        emailFieldElement.clear();
        emailFieldElement.sendKeys(email);
        passwordFieldElement.click();
        passwordFieldElement.clear();
        passwordFieldElement.sendKeys(password);
        confpasswordFieldElement.click();
        confpasswordFieldElement.clear();
        confpasswordFieldElement.sendKeys(password);
        registerButtonElement.click();
    }

    @When("^I fill login form with email \"(.*?)\" and password \"(.*?)\" web$")
    public void I_fill_login_form(String email, String password) throws Throwable {
        QAFExtendedWebElement loginButtonElement = new QAFExtendedWebElement("login.button");
        CommonStep.sendKeys(email, "email.input");
        CommonStep.sendKeys(password, "password.input");
        loginButtonElement.click();
    }

    @And("^I add expense$")
    public void I_add_expense() throws Throwable {
        QAFExtendedWebElement addExpenseElement = new QAFExtendedWebElement("add.expense.button");
        QAFExtendedWebElement headSelectElement = new QAFExtendedWebElement("head.select");
        QAFExtendedWebElement taxiHedElement = new QAFExtendedWebElement("taxi.head");

        QAFExtendedWebElement okButtonElement = new QAFExtendedWebElement("ok.button");
        QAFExtendedWebElement currencySelectElement = new QAFExtendedWebElement("currency.select");
        QAFExtendedWebElement dollarCurrencyElement = new QAFExtendedWebElement("dollar.currency");
        QAFExtendedWebElement categorySelecteElement = new QAFExtendedWebElement("category.select");
        QAFExtendedWebElement businessCategoryElement = new QAFExtendedWebElement("business.category");

        QAFExtendedWebElement amountSelectElement = new QAFExtendedWebElement("amount.select");
        QAFExtendedWebElement saveButtonElement = new QAFExtendedWebElement("save.button");
        addExpenseElement.click();
        headSelectElement.click();
        taxiHedElement.click();
        okButtonElement.click();
        amountSelectElement.click();
        amountSelectElement.clear();
        amountSelectElement.sendKeys("1000");
        currencySelectElement.click();
        dollarCurrencyElement.click();
        okButtonElement.click();
        categorySelecteElement.click();
        businessCategoryElement.click();
        okButtonElement.click();
        saveButtonElement.click();
    }

    @And("^I edit expense$")
    public void I_edit_expense() throws Throwable {
        QAFExtendedWebElement addExpenseElement = new QAFExtendedWebElement("add.expense.button");
        QAFExtendedWebElement headSelectElement = new QAFExtendedWebElement("head.select");
        QAFExtendedWebElement mealsHedElement = new QAFExtendedWebElement("meals");

        QAFExtendedWebElement okButtonElement = new QAFExtendedWebElement("ok.button");
        QAFExtendedWebElement currencySelectElement = new QAFExtendedWebElement("currency.select");
        QAFExtendedWebElement gbeCurrencyElement = new QAFExtendedWebElement("gbe.currency");
        QAFExtendedWebElement categorySelecteElement = new QAFExtendedWebElement("category.select");
        QAFExtendedWebElement businessCategoryElement = new QAFExtendedWebElement("business.category");

        QAFExtendedWebElement amountSelectElement = new QAFExtendedWebElement("amount.select");
        QAFExtendedWebElement saveButtonElement = new QAFExtendedWebElement("save.button");
        addExpenseElement.click();
        headSelectElement.click();
        mealsHedElement.click();
        okButtonElement.click();
        amountSelectElement.click();
        amountSelectElement.clear();
        amountSelectElement.sendKeys("400");
        currencySelectElement.click();
        gbeCurrencyElement.click();
        okButtonElement.click();
        categorySelecteElement.click();
        businessCategoryElement.click();
        okButtonElement.click();
        saveButtonElement.click();
    }

    @Then("^it should have \"([^\"]*)\" in search results$")
    public void it_should_have_in_search_results(String result) throws Throwable {
        QAFExtendedWebElement searchResultElement = new QAFExtendedWebElement("partialLink=" + result);
        searchResultElement.verifyPresent(result);
    }

    @Then("^it should have following search results:$")
    public void it_should_have_all_in_search_results(List<String> results) {
        QAFExtendedWebElement searchResultElement;
        for (String result : results) {
            searchResultElement = new QAFExtendedWebElement("partialLink=" + result);
            searchResultElement.verifyPresent(result);
        }
    }
}
