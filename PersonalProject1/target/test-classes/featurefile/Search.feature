Feature: To validate the search functionality of the application
  Scenario: Searching for a valid product
    Given User navigates to Homepage of the application
    When User enters the valid product name "iphone" into the search box field
    And User clicks on Search button
    Then User should get valid product displayed in search results

  Scenario: Searching for a invalid product
    Given User navigates to Homepage of the application
    When User enters the invalid product name "Yamaha" into the search box field
    And User clicks on Search button
    Then User should get an error message

  Scenario: Searching without entering product
    Given User navigates to Homepage of the application
    When User don't enter any product in search box field
    And User clicks on Search button
    Then User should get an error message



