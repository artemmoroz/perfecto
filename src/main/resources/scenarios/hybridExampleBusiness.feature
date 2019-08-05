@coherentsolutions
@hybrid
@t
Feature: Business Hybrid App

######################################################  SIGNIN   ###############################################
  @t
  Scenario: SignIn Hybrid Final
    Given I start Perfecto hybrid app2
    And I am using an AppiumDriver

    When I open registration form
    And I fill registration form with email "testEmail1@gmail.com" and password "testPassword"
    And I submit registration form
#
########################################################  LOGIN  ####################
  Scenario: Login Hybrid Final
    Given I start Perfecto hybrid app
    And I am using an AppiumDriver

    When I fill login form with email "testEmail1@gmail.com" and password "testPassword"
    And I submit login form

#######################################################  ADD EXPENSE  ####################
  Scenario: Add Expense Hybrid Final
    Given I start Perfecto hybrid app
    And I am using an AppiumDriver

    When I open expense form
    And I fill expense form with mandatory fields only
    And I scroll to down
    And I submit expense
#    Then I should see text "Saved!"

########################################################  EDIT EXPENSE    ####################
  Scenario: Edit Expense Hybrid Final
    Given I start Perfecto hybrid app
    And I am using an AppiumDriver

    When I select element "Flight"
    And I select element "Edit"
    And I set category to "miscellaneous.category"
    And I scroll to down
    #And I select attachment
    And I save expense
