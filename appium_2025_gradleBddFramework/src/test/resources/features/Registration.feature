@Smoke
Feature: Registration

  Scenario: User Form Filling
    Given User is navigated to Form filling page
    When User sets Name in nameField
    And User selects country from dropdown
    And User selects gender from dropdown
    Then user clicks on lets shop button
