@Parallel
Feature: Parallel Test Feature

  @ParallelGoogle
  Scenario: Google Test
    Given user goes to url "https://google.com"
    When user verifies title contains "Google"
    Then user closes driver
