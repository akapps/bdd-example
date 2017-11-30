Feature: Account management

  As operations are performed over a customer's account, the balance must be checked
  and updated.

  Scenario: Cash withdrawal
    Given I have $100 on my account
    When I withdraw $25
    Then my account balance should be $75

  Scenario: Cash deposit
    Given I have $100 on my account
    When I deposit $30
    Then my account balance should be $130

  Scenario: The one where I want more than I have
    Given I have $50 on my account
    When I withdraw $75
    Then the transaction is refused
    And my account balance should be $50