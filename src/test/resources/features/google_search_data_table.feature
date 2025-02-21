Feature: Passing multiple parameters to the same step

  @google_search_data_table
  Scenario: Searching multiple items
    Given user is on Google search page
    Then user searches the following items
      | loop academy |
      | java         |
      | selenium     |
      | sql          |
      | Pavlo        |
      | Kate         |
    And we love loop Academy


