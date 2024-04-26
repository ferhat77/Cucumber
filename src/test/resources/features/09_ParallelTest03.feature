@Parallel
Feature: Parallel Test Feature

  Scenario: LinkedIn Test
    Given user goes to url "https://linkedin.com"
    When user verifies title contains "LinkedIn"
    Then user closes driver
