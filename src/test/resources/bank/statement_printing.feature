Feature: Statement printing

  Background:
    Given a client has an account

  Scenario: statement prints credits, debits and balances
    Given a client makes a deposit of 1000 on 10-01-2012
    And a deposit of 2000 on 13-01-2012
    And a withdrawal of 1200 on 14-01-2012
    When she prints her bank statement
    Then she would see
    """
    | date       | credit  | debit   | balance |
    | 14/01/2012 |         | 1200.00 | 1800.00 |
    | 13/01/2012 | 2000.00 |         | 3000.00 |
    | 10/01/2012 | 1000.00 |         | 1000.00 |
    """
