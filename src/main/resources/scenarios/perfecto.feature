@coherentsolutions
@perfecto
Feature: Perfecto App

#####################################################  SIGNIN   ###############################################
  Scenario Outline: SignUp
    Given I start Perfecto app

    When I signUp with name "<userName>", email "<userEmail>" and password "<userPassword>"
    Then I must see text "Login"

    Examples: {'datafile' : 'src/main/resources/data/users.json'}

#######################################################  LOGIN  ####################
  Scenario Outline: Login
    Given I start Perfecto app

    When I login with email "<userEmail>" and password "<userPassword>"
    Then I must see text "Expenses"

    Examples: {'datafile' : 'src/main/resources/data/users.json'}

######################################################  ADD EXPENSE  ####################
  Scenario: Add Expense

    When I add expense with head "Flight", category "Personal", amount "200" and currency "USD - $"
    And I attach image
    And I save expense

    Then I must see text "Flight"
    And I must see text "200"

##########################################################  EDIT EXPENSE    ####################
  #only native
  Scenario: Edit Expense

    Given I select "Flight" expense
    When I edit expense with head "Flight", category "Business", amount "250" and currency "AUD - A$"
    And I save expense

    Then I must see text "250"

#########################################################  DELETE EXPENSE    ####################
#  Scenario: Delete Expense
#    Given I start Perfecto app
#
#    When I select "Flight" expense
#    And I delete "Flight" expenses
#
#    Then I should not see text "250"
#
########################################################## LOGOUT    ####################
#  Scenario: Logout
#    Given I start Perfecto app
#
#    When I logout from app
#    Then I must see text "Expense Tracker"
