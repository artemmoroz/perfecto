@coherentsolutions
@perfecto
Feature: Perfecto App

#####################################################  SIGNIN   ###############################################
  Scenario Outline: SignUp
    Given I start Perfecto app

    When I sigUp with name "<userName>", email "<userEmail>" and password "<userPassword>"
    Then I must see text "Login"

    Examples: {'datafile' : 'src/main/resources/data/users.json'}

#######################################################  LOGIN  ####################
  Scenario Outline: Login
    Given I start Perfecto app

    When I login with email "<userEmail>" and password "<userPassword>"
    #Then I must see text "Expenses"

    Examples: {'datafile' : 'src/main/resources/data/users.json'}

######################################################  ADD EXPENSE  ####################
  Scenario Outline: Add Expense
    Given I start Perfecto app
    And I login with email "<userEmail>" and password "<userPassword>"

    When I add expense with head "Flight", category "Personal" and amount "200"
    Then I must see text "Flight"
    And I must see text "200"

    Examples: {'datafile' : 'src/main/resources/data/users.json'}

##########################################################  EDIT EXPENSE    ####################
#  Scenario Outline: Edit Expense
#    Given I start Perfecto app
#    And I login with email "<userEmail>" and password "<userPassword>"
#
#    When I select "Flight" expense
#    And I edit expense with head "Flight", category "Business" and amount "250"
#  #  And I attach "xxx" image // not implemented
#  #  And I save expense // not need until attachment
#
#    Then I must see text "250"
#
#    Examples: {'datafile' : 'src/main/resources/data/users.json'}
#
#########################################################  DELETE EXPENSE    ####################
#  Scenario Outline: Delete Expense
#    Given I start Perfecto app
#    And I login with email "<userEmail>" and password "<userPassword>"
#
#    When I select "Flight" expense
#    And I delete "Flight" expenses
#
#    Then I should not see text "250"
#
#  Examples: {'datafile' : 'src/main/resources/data/users.json'}
#
########################################################## LOGOUT    ####################
#  Scenario Outline: Logout
#    Given I start Perfecto app
#    And I login with email "<userEmail>" and password "<userPassword>"
#
#    When I logout from app
#    Then I must see text "Expense Tracker"
#
#  Examples: {'datafile' : 'src/main/resources/data/users.json'}
