Feature: Find Person Functionality

  In order to use the system
  As a valid user
  I want to find the person saved

  @Find_Person_Successfully
  Scenario: Find Person

    Given that user wants to find person data
    When make a get request with dd 16 and number 981733312
    Then return person status 200

  @Do_Not_Find_Person
  Scenario: Do Not Find Person

    Given that user wants to find person data
    When make a get request with dd 18 and number 981733315
    Then return person status 404
