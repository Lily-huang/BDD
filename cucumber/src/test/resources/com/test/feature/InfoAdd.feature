Feature: Add staff Info
  In order to test if we can add staff info correctly
  I want to add a staff info to db.

  Scenario Outline: Add staff Scenario
    Given the following staffs info
      | name | age | id    |
      | Lily | 20  | 12345 |
    When The info is submitted
    Then the info output should be "<output>"


    Examples:
      | output |
      | Lily   |