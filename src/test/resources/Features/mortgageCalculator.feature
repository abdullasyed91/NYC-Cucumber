Feature: Mortgage calculator

  @CalculateApr
  Scenario: Calculate the real APR Rate
    Given a user is on the mortgage calculator home page
    And user navigates to the Real Apr page
    When user clicks on calculate button upon entering the data
      | HomePrice | DownPayment | InterestRate |
      | 200000    | 15000       | 3            |
    Then the real Apr Rate is "3.130%"


  @CalculateMonthlyPayment
  Scenario: Calculate the monthly mortgage payment
    Given a user is on the mortgage calculator home page
    When user enters data
      | HomePrice | DownPayment | LoanAmount | InterestRate | LoanTerm | PropertyTax | PMI | HOI  | HOA | LoanType | BuyOrRefi | TotalMonthly |
      | 300000    | 60000       | 240000     | 3            | 30       | 5000        | 0.5 | 1000 | 100 | FHA      | Buy       | 1,611.85     |
    And click on calculate button
    Then the monthly payment is "$1,611.85"