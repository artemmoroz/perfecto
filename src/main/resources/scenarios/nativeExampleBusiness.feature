@appium
Feature: Business Native App

#####################################################  SIGNIN   ###############################################
  Scenario: SignIn Native
    Given I start Perfecto native app
    And I am using an AppiumDriver

    When I click on "btn.singUp"
    And I fill registration form with email "testEmail10@gmail.com" and password "testPassword1" native
    And I scroll to down
    And I submit registration form native

    Then account must be created

#######################################################  LOGIN  ####################
  Scenario: Login Native
    Given I start Perfecto native app
    And I am using an AppiumDriver

    When I fill login form with email "testEmail10@gmail.com" and password "testPassword1" native
    And I submit login form native

#    Then I verify username "testEmail10@gmail.com"

  #####################################################  ADD EXPENSE  ####################
  Scenario: Add Expense Native
    Given I start Perfecto native app
    And I am using an AppiumDriver

    When I click on "add.expense"
    And I fill expense with "Flight" head, "Personal" category and "400" amount
    And I fill date with "01"
    And I save expense native

    Then I must see text "Flight"
    And I must see text "400"

#########################################################  EDIT EXPENSE    ####################
  Scenario: Edit Expense Native
    Given I start Perfecto native app
    And I am using an AppiumDriver

    When I select element "Flight"
    And I click on "edit.button"
    And I click on "add.category"
    And I select category "Business"
    And I scroll to down
#    And I add image
    And I save expense native

	Then I select element "Flight"
    And I must see text "Business"

########################################################  DELETE EXPENSE    ####################
  Scenario: Delete Expense Native
    Given I start Perfecto native app
    And I am using an AppiumDriver

    When I go to expenses list
    And I delete flight expense

  ######################################################### LOGOUT    ####################
#  Scenario: Logout Native IOS
 #   Given I start Perfecto native app
 #   And I am using an AppiumDriver

 #   When I logout from expenses list
