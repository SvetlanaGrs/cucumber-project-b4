Feature: Google Search Functionality Title verification
  User Story: As a user, when I am on the Google search page
  I should be able to search whatever i want and see the relevant information


  Scenario: Search functionality result title verification
    Given user is on Google search page
    When user types Loop Academy in the google search box and clicks enter
    Then user should see Loop Academy - Google Search in the Google title


    Scenario: Search functionality result title verification
      Given user is on Google search page
      When user types "Loop Academy" in the google search box and clicks enter
      Then user should see "Loop Academy - Google Search" in the Google title

  Scenario: Search functionality result title verification
    Given user is on Google search page
    When user types "Nadir Shafiyev" in the google search box and clicks enter
    Then user should see "Nadir Shafiyev - Google Search" in the Google title

  @google_search @smoke
  Scenario: Search functionality result title verification
    Given user is on Google search page
    When user types "Svetlana Grishina" in the google search box and clicks enter
    Then user should see "Svetlana Grishina - Google Search" in the Google title