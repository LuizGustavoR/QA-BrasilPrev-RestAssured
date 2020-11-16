Feature: Save Person Functionality

  In order to use the system
  As a valid user
  I want to save a person in the system

  @Save_Person_Successfully
  Scenario: Save Person

    Given that user wants to save new person data
    When make a post request
    Then return status 200
