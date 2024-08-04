Feature: Add Smartwatch to card

  As a user of the OpenCart website
  I want to be able to log in with my account
  So that I can access my account-related features and manage my orders

  Background:
    Given I am on the OpenCart main page

  Scenario: Successful add smart watch to card
#    Given I open top menu todo
    When I have added first smartwatch to card
    Then I should check the values of Smartwatch
