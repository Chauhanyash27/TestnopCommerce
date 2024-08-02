Feature: Product Review

  Scenario Outline: Verify Product Review Getting Added

    Given User navigates to Product Detail Page
    And Move to the Write Review Section
    When User Fills the "<reviewTitle>", "<reviewText>" and "<rating>"
    And Submit the Product Review
    Then Verify that the Review is added successfully

    Examples:
      | reviewTitle      | reviewText       | rating |
      | Product Review 1 | Testing Review 1 | 1      |
      | Product Review 2 | Testing Review 2 | 2      |
