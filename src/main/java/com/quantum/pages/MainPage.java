package com.quantum.pages;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.quantum.actions.PerfectoCustomActions;
import com.quantum.components.ExpenseListItem;
import com.quantum.components.Menu;
import com.quantum.components.select.SelectIos;
import com.quantum.utils.AppType;
import com.quantum.utils.DeviceUtils;
import org.testng.Assert;

import java.math.BigDecimal;
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

    @FindBy(locator = "main.menu.button")
    private QAFWebElement menuButton;

    @FindBy(locator = "main.back.button")
    private QAFWebElement backToMainScreen;

    private Menu menu;

    private List<ExpenseListItem> expenseListItemList;

    private AddExpensePage addExpensePage;

    public void addExpense(String head, BigDecimal amount, String category, String currency) {
        addExpense.click();
        addExpensePage = new AddExpensePage();
        addExpensePage.addExpense(head, amount, currency, null, category, null, null, true);
    }

    public void addExpense(String head, BigDecimal amount, String currency, List<String> dateTime,
                           String category, Boolean reccuring, String details) {
        addExpense.click();
        addExpensePage = new AddExpensePage();
        addExpensePage.addExpense(head, amount, currency, dateTime, category,
                reccuring, details, true);
    }

    public void editExpense(String head, BigDecimal amount, String category, String currency) {
        if (PerfectoCustomActions.getInstance().getType() == AppType.HYBRID_IOS) {
            driver.findElementByXPath("//*[@label=\""+ head +"\"]").click();
        }
        editExpense.click();
        //for now it is the same as add
        addExpensePage = new AddExpensePage();
        addExpensePage.addExpense(head, amount, currency, null, category, null, null, true);
        if (PerfectoCustomActions.getInstance().getType() == AppType.HYBRID_IOS) {
            saveExpense();
            backToMainScreen.click();
        }
    }

    public void saveExpense() {
        addExpensePage = new AddExpensePage();

        //addExpensePage always null without previous line
        if (addExpensePage != null) {
            addExpensePage.saveExpense();
            PerfectoCustomActions.getInstance().getActions().clickOnText("OK");
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
        System.out.println("Menu clicked");
        menu = new Menu();
    }


    public void logOut() {
        if (menu == null) {
            openMenu();
        }
        System.out.println("Try to logout");
        menu.logout();
    }

    public List<ExpenseListItem> getExpenseListItemList() {
        if (expenseListItemList == null) {

        }
        return expenseListItemList;

    }


    public class AddExpensePage extends AbstractBasePage {

        public static final String SCROLL_DOWN_START = "50%,60%";
        public static final String SCROLL_DOWN_END = "50%,20%";

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

        private SelectIos selector = new SelectIos();

        public void addExpense(String head, BigDecimal amount, String currency, List<String> dateTime, String category,
                               Boolean reccuring, String details, boolean clickSave) {
            Assert.assertNotNull(head);
            Assert.assertNotNull(amount);
            Assert.assertNotNull(category);

            if (PerfectoCustomActions.getInstance().getType() == AppType.HYBRID_IOS) {
                selector.hybridIosSelectByValue("Head", head);
                setFieldValue(amountField, amount.toPlainString());
                selector.hybridIosSelectByValue("Currency", currency);
                DeviceUtils.swipe(SCROLL_DOWN_START, SCROLL_DOWN_END);
                selector.hybridIosSelectByValue("Category", category);

                return;
            }

            headSelect.click();
            selector.selectByValue(head);
            amountField.sendKeys(amount.toPlainString());
            categorySelect.click();
            selector.selectByValue(category);
            if (currency != null) {
                currencySelect.click();
                selector.selectByValue(currency);
            }
            if (dateTime != null) {
                date.click();
//                date.sendKeys(dateTime.toString()); //todo set format with / eg 25/07/2019 - DONE (DateParser from utils)
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

            saveExpense();
        }

        public void saveExpense() {
            saveButton.click();
            PerfectoCustomActions.getInstance().getActions().clickOnText("OK");
        }

        public void resetExpense() {
            resetButton.click();
        }

    }
}
