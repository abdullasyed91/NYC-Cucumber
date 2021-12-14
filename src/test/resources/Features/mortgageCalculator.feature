Feature: Mortgage calculator

  @CalculateApr
  Scenario: Calculate the real APR Rate
    Given a user is on the mortgage calculator home page
    And user navigates to the Real Apr page
    When user clicks on calculate button upon entering the data
      | HomePrice | DownPayment | InterestRate |
      | 200000    | 15000       | 3            |
    Then the real Apr Rate is "3.130%"