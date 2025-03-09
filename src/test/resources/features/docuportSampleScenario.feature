Feature: Docuport Sample Scenario

  Background:
    Given user is on Docuport login page
    When user inserts "b1g1_client@gmail.com " to "username" field on "Login" page
    When user inserts "Group1" to "password" field on "Login" page
    And user clicks "login" button on "Login" page
    And user clicks "continue" button on "Choose account" page
    Then user should be able to see the home for client
  @sampleDocuport @wip
  Scenario: Practice click buttons on different pages as a client
    And user clicks "Received Docs" button on "Left Navigate" page
    And user clicks "Search" button on "Received Docs" page
    And user inserts "tax document" to "Document name" field on "Received Doc" page

    And user clicks "Tags" button on "Received Docs" page
    And user inserts "Tax Return" to "Tags" field on "Received Doc" page
    And user clicks "Upload date" button on "Received Docs" page
    And user inserts "15" to "Upload date" field on "Received Doc" page
    And user clicks "Upload by" button on "Received Docs" page
    And user inserts "advisor advisor" to "Upload by" field on "Received Doc" page
    And user clicks " Search " button on "Received Docs" page
    And user should see "There are no items to display." message on "Received Doc" page

    @task2@wip
    Scenario: Practice click buttons on my uploads as a client
      Then user clicks "My uploads" button on "Left Navigate" page
     # And user clicks "Upload documents" button on "My uploads" page
     # And user inserts "C:\Users\advok\OneDrive\Desktop\example.txt" to "Upload file" field on "My uploads" page
     # And user clicks "Upload" button on "My uploads" page
      Then user clicks "Search dropdown" button on "My uploads" page
      And user should see "There are no items to display." message on "My uploads" page


    @task3@wip
    Scenario: Practice click buttons on invitations field as a client
      And user clicks "Invitations" button on "Left Navigate" page
      And user clicks "Search dropdown" button on "Invitations" page
      And user inserts "loop" to "Recipient" field on "Invitations" page
      And user clicks "Sent" button on "Invitations" page
      And user clicks " Search " button on "Invitations" page
      And user should see "Your search returned no results. Make sure you search properly" message on "Invitations" page

      @task4@wip
      Scenario: Practice click buttons on my terms and conditions field as a client
        And user clicks "Terms and conditions" button on "Left Navigate" page
        Then validate that new tab opens
        Then user should see "SERVICE TERMS AND CONDITIONS" message on "Terms and conditions" page
