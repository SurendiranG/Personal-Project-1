Feature: To validate the Registration Functionality of the application
  Scenario: Creating an account by filling details with mandatory fields
    Given User navigates to Register page
    When User enters the details in the below fields
      |firstName	|Arun		                |
      |lastName		|Motoori	              |  
      |telephone	|1234567890	            |
      |password		|12345 		              |
    And User checks the privacy policy
    And User clicks the continue button
    Then User should created the account successfully

  Scenario: Creating an account by filling all the details
    Given User navigates to Register page
    When User enters the details in the below fields
      |firstName	|Arun		                |
      |lastName		|Motoori	              |     
      |telephone	|1234567890	            |
      |password		|12345 		              |
    And User selects the Newsletter
    And User checks the privacy policy
    And User clicks the continue button
    Then User should created the account successfully

  Scenario: Creating a duplicate account
    Given User navigates to Register page
    When User enters the details in the below fields with duplicate email
      |firstName	|Arun						            |
      |lastName	  |Motoori				            |
      |email			|amotooricap4@gmail.com			|
      |telephone	|1234567890			            |
      |password	  |12345					            |
    And User selects the Newsletter
    And User checks the privacy policy
    And User clicks the continue button
    Then User should get a error message about duplicate email

  Scenario: Creating an account without filling any details
    Given User navigates to Register page
    When User don't enter any details into the fields
    And User clicks the continue button
    Then User should get a error messages for every mandatory field