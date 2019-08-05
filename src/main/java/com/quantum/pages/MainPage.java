package com.quantum.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.actions.PerfectoCustomActions;
import com.quantum.components.ExpenseListItem;
import com.quantum.components.Menu;
import com.quantum.utils.AppType;
import org.testng.Assert;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created 26-Jul-19
 *
 * @author <a href="mailto:ArtemMoroz@coherentsolutions.com">Artem Moroz</a>
 * @version 1.0
 */
public class MainPage extends AbstractBasePage {

    @FindBy(locator = "main.welcome.text")
    private QAFWebElement welcomeText;

    @FindBy(locator = "main.add_expense.button")
    private QAFWebElement addExpense;

    @FindBy(locator = "main.edit_expense.button")
    private QAFWebElement editExpense;

    @FindBy(locator = "main.delete_expense.button")
    private QAFWebElement deleteExpense;

    @FindBy(locator = " main.menu.button")
    private QAFWebElement menuButton;

    private Menu menu;


    private List<ExpenseListItem> expenseListItemList;

    private AddExpensePage addExpensePage;

    public void addExpense(String head, BigDecimal amount, String category) {
        addExpensePage = new AddExpensePage();
        addExpensePage.addExpense(head, amount, null, null, category, null, null, true);
    }

    public void addExpense(String head, BigDecimal amount, String currency, LocalDateTime dateTime,
                           String category, Boolean reccuring, String details) {
        addExpensePage = new AddExpensePage();
        addExpensePage.addExpense(head, amount, currency, dateTime, category,
                reccuring, details, true);
    }

    public void editExpense(String head, BigDecimal amount, String category) {
        editExpense.click();
        //for now it is the same as add
        addExpense(head, amount, category);
    }

    public void saveExpense() {
        if (addExpensePage != null) {
            addExpensePage.saveExpense();
        } else {
            throw new IllegalStateException("Add page is not inited!");
        }
    }

    public MainPage deleteExpense(String expenseName) {
        PerfectoCustomActions customActions = PerfectoCustomActions.getInstance();
        AppType type = customActions.getType();
        switch (type) {
            case HYBRID_ANDROID:
            case HYBRID_IOS: {
                //do nothing
                break;
            }
            case IOS: {
                editExpense.click();
                customActions.getActions().clickOnText(expenseName);
                //TODO!!!! check
                menuButton.click();
                customActions.getActions().clickOnText("Done");
                break;
            }
            case ANDROID: {
                //TODO!!!! check
                deleteExpense.click();
                customActions.getActions().clickOnText(expenseName);
                customActions.getActions().clickOnText("OK");
                break;
            }
        }
        return this;
    }


    public void openMenu() {
        menuButton.click();
        menu = new Menu();
    }


    public void logOut() {
        if (menu == null) {
            openMenu();
        }
        menu.logout();
    }

    public List<ExpenseListItem> getExpenseListItemList() {
        if (expenseListItemList == null) {

        }
        return expenseListItemList;

    }


    public class AddExpensePage extends AbstractBasePage {


        @FindBy(locator = "main.add.head.select")
        private QAFWebElement headSelect;

        @FindBy(locator = "main.add.amount.field")
        private QAFWebElement amountField;


        @FindBy(locator = "main.add.currency.select")
        private QAFWebElement currencySelect;


        @FindBy(locator = "main.add.date.date")
        private QAFWebElement date;

        @FindBy(locator = "main.add.category.select")
        private QAFWebElement categorySelect;

        @FindBy(locator = "main.add.attach.button")
        private QAFWebElement attachmentButton;

        @FindBy(locator = "main.add.recurring.switch")
        private QAFWebElement recurringSwitch;

        @FindBy(locator = "main.add.details.tarea")
        private QAFWebElement detailsTextarea;

        @FindBy(locator = "main.add.save.button")
        private QAFWebElement saveButton;

        @FindBy(locator = "main.add.reset.button")
        private QAFWebElement resetButton;

        public void addExpense(String head, BigDecimal amount, String currency, LocalDateTime dateTime, String category,
                               Boolean reccuring, String details, boolean clickSave) {
            Assert.assertNotNull(head);
            Assert.assertNotNull(amount);
            Assert.assertNotNull(category);

            headSelect.sendKeys(head); //todo change to select
            amountField.sendKeys(amount.toPlainString());
            categorySelect.sendKeys(category);
            if (currency != null) {
                setFieldValue(currencySelect, currency);
            }
            if (dateTime != null) {
                date.sendKeys(dateTime.toString()); //todo set format with / eg 25/07/2019
            }
            if (reccuring != null) {
                recurringSwitch.sendKeys(reccuring.toString());// todo replace with click
            }
            if (details != null) {
                setFieldValue(detailsTextarea, details);
            }
            if (clickSave) {
                saveButton.click();
            }
        }

        public void saveExpense() {
            saveButton.click();
        }

        public void resetExpense() {
            resetButton.click();
        }

    }
}
