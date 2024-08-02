Feature: User Login

  Scenario Outline: User login with valid credentials

    Given User navigates to Login Page
    When User enters "<email>" and "<password>"
    And Clicks on Login Button
    Then User logouts after HomePage is displayed

    Examples:
      | email                | password |
      | yash1@mailinator.com | password |
      | yash3@mailinator.com | password |
