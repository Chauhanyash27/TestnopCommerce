Feature: User Registeration

  Scenario: Verify User Registration

    Given User navigates to Register Page
    When User enters below details
      | male | Yash | Chauhan | 1 | January | 2000 | yash3@mailinator.com | Infostride | password | password |
    And Clicks on Register Button
    Then Verify that Registration is successful


