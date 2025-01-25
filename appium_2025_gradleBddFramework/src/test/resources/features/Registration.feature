@Smoke
Feature: User Registration

  As a user
  I want to fill out the registration form
  So that I can proceed to the shopping page

  Scenario: Successful form submission
    Given the user navigates to the registration form
    When the user selects "Argentina" from the country dropdown
    And the user enters "Test User" as the name
    And the user selects "Male" from the gender dropdown
    Then the user clicks on the "Let’s Shop" button
    And the user is redirected to the shopping page

