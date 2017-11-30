Feature: Account management

  As operations are performed over a customer's account, the balance must be checked
  and updated.

  Scenario: Cash withdrawal
    Given I have $100 on my account
    When I withdraw $25
    Then my account balance should be $75