@FormPage
Feature: Form Test Scenario Outline


  Scenario Outline: Form Test

    Given go to form page
    When enter username "<username>"
    And enter password "<password>"
    And enter comment "<comment>"
    And clcik on submit
    Then user closes browser
    Examples:
      | username | password | comment         |
      | john_doe | John.123 | Hello I am John |
      | ali_can  | Ali.123  | Hello I am Ali  |
      | ayse_han | Ayse.123 | Hello I am Ayse |