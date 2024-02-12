Feature: List the parfum products based on filters

  Scenario: List the parfum products based on filters
#    Given the user navigates to "@TD:Douglas website"
    Given the user navigates to "https://www.douglas.de/de"
    When the user click on the "acceptcookies" button on cookie consent
    And the user click on "PARFUM" tab on home page
    And the user should see the headline "Parfüm & Düfte"

#    Then the user is on
