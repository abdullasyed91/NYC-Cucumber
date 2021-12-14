@Login_test
Feature: Test login functionalities

  Background:
    Given a user is on the login page

  @positive_test
  Scenario: Check login is successful with valid credentials
    When user enters username "Abdulla" and password "12345"
    And click on login button
    Then user is navigated to home page

  @positive_test
  Scenario Outline: Check login is successful with valid credentials
    When user enters username "<Username>" and password "<Password>"
    And click on login button
    Then user is navigated to home page
    Examples:
      | Username | Password |
      | Abdulla  | 12345    |
      | Rifat    | 12345    |
      | Robert   | 12345    |


  @dataDriven_test @positive_test
  Scenario: Check login is successful using data table
    When user clicks on login button upon entering credentials
      | username | password |
      | Abdulla  | 12345    |
    Then user is navigated to home page


  @negative_test
  Scenario: Check login is unsuccessful with invalid credentials
    When user enters username "Abdulla" and password "23412"
    And click on login button
    Then user fails to login
