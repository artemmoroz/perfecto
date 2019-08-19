package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.quantum.actions.PerfectoCustomActions;
import com.quantum.pages.LoginPage;
import com.quantum.pages.MainPage;
import com.quantum.pages.SignUpPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.math.BigDecimal;

/**
 * Created 31-Jul-19
 *
 * @author <a href="mailto:ArtemMoroz@coherentsolutions.com">Artem Moroz</a>
 * @version 1.0
 */
@QAFTestStepProvider
public class PerfectoSteps {

    @Given("^I start Perfecto app$")
    public static void startPerfectoApp() {
        PerfectoCustomActions.getInstance().getActions().startPerfectoApp();
    }

    @When("^I signUp with name \"(.*)\", email \"(.*)\" and password \"(.*)\"$")
    public static LoginPage signUp(String userName, String userEmail, String userPassword) {
        LoginPage loginPage = new LoginPage();
        loginPage.moveToSignUp();
        SignUpPage signUpPage = new SignUpPage();
        return signUpPage.register(userName, userEmail, userPassword, null);
    }

    @When("I select element \"(.*?)\"$")
    public void selectElement(String text) {
        PerfectoCustomActions.getInstance().getActions().clickOnText(text);
    }

    @When("^I login with email \"(.*)\" and password \"(.*)\"$")
    public static MainPage login(String userEmail, String userPassword) {
        LoginPage loginPage = new LoginPage();
        return loginPage.login(userEmail, userPassword);
    }

    @When("^I add expense with head \"(.*)\", category \"(.*)\", amount \"(\\d*)\" and currency \"(.*)\"$")
    public static void addExpense(String head, String category, double amount, String currency) {
        MainPage mainPage = new MainPage();
        mainPage.addExpense(head, new BigDecimal(amount), category, currency);
    }

    @When("^I save expense$")
    public static void saveExpense() {
        MainPage mainPage = new MainPage();
        mainPage.saveExpense();
    }

    @Given("^I select \"(.*)\" expense$")
    public static void selectExpenseByName(String expenseName) {
        PerfectoCustomActions.getInstance().getActions().clickOnText(expenseName);
    }


    @When("^I edit expense with head \"(.*)\", category \"(.*)\", amount \"(\\d*)\" and currency \"(.*)\"$")
    public static void editExpense(String head, String category, double amount, String currency) {
        MainPage mainPage = new MainPage();
        //this is stub for searching elements, just search first by text
        mainPage.editExpense(head, new BigDecimal(amount), category, currency);
    }

    @When("^I attach image$")
    public static void attachImageToExpense() {
        MainPage mainPage = new MainPage();
        mainPage.attachImage();
    }


    @When("^I delete \"(.*)\" expenses$")
    public static void deleteSelectedExpenses(String expenseName) {
        MainPage mainPage = new MainPage();
        mainPage.deleteExpense(expenseName);
    }

    @When("^I logout from app$")
    public static void logout() {
        MainPage mainPage = new MainPage();
        mainPage.logOut();
    }
}
