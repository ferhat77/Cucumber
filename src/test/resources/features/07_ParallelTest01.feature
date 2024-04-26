@Parallel
Feature: Parallel Test Feature

  Scenario: Form Test
    Given user goes to home page
    When user enters username
    And user enters password
    And user enters comment
    Then user closes driver
