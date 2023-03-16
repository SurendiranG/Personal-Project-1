Feature: To validate the login functionality of the application
  Scenario Outline: Login with valid credentials
    Given User navigates to login page
    When User enters the valid mail id <username> in the email field
    And User enters the valid password <password> in the password field
    And User clicks the login button
    Then User should successfully logged in
    Examples:
    |username               |password|
    |amotooricap1@gmail.com |12345	 |
    |amotooricap2@gmail.com |12345	 |
    |amotooricap3@gmail.com |12345	 |
    
  Scenario: Login with invalid credentials
    Given User navigates to login page
    When User enters the invalid mail id in the email field
    And User enters the invalid password "1234567890" in the password field
    And User clicks the login button
    Then User should get the error message about credentials mismatch

  Scenario: Login with valid mail id and invalid password
    Given User navigates to login page
    When User enters the valid mail id "amotooricap2@gmail.com" in the email field
    And User enters the invalid password "1234567890" in the password field
    And User clicks the login button
    Then User should get the error message about credentials mismatch

  Scenario: Login with invalid mail id and valid password
    Given User navigates to login page
    When User enters the invalid mail id in the email field
    And User enters the valid password "12345" in the password field
    And User clicks the login button
    Then User should get the error message about credentials mismatch

  Scenario: Login without providing any credentials
    Given User navigates to login page
    When User don't enters the login credentials
    And User clicks the login button
    Then User should get the error message about credentials mismatch



