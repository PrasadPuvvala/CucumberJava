Feature: Login Feature

  Scenario: Test If User can login
    Given User is on login page
    When User sends username and password
    And click on submit
    Then user is navigated to home page

    Scenario: Check Preferences Page
    Given HCP is on Preferences page
    When HCP clicks on Catalog
    And check Filter Preferences
    Then Pass on first value