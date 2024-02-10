Feature: Open Douglas Website and Navigate to PARFUM Category

  Scenario: User opens Douglas website and navigates to PARFUM category
    Given the user is on Douglas homepage
    When the user accepts the cookie consent
    And the user clicks on the "PARFUM" category
    Then the user should see the PARFUM page
