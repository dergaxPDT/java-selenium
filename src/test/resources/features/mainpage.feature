Feature: Add Smartwatch to card

  I want to be able to add smartwatch to card

  Background:
    Given I am on the OpenCart main page

  Scenario: Successful add smart watch to card
    When I have added first smartwatch to card
    Then I should check the values of Smartwatch
