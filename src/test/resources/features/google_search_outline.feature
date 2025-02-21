Feature: Scenario Outline Practice

  @google_search_outline
  Scenario Outline:
    Given user is on Google search page
    When user search for "<country>"
    Then user should see the "<capital>" in the results
    And we love loop Academy


    Examples:
      | country    | capital        |
      | Azerbaijan | Baku           |
      | Ukraine    | Kyiv          |
      | Afg        | Kabul          |
      | USA        | Washington, D.C. |
      | Turkiye    | Ankara         |
      | Georgia    | Atlanta        |

