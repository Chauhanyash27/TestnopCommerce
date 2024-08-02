Feature: Category Navigation

  Scenario: Verify Category Navigation on HomePage

    Given User is currently on the Homepage
    When User navigates to particular category
    Then Verify the actual and expected category