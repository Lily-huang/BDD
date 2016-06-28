Feature: Hello msg print
  In order to test the communication of main
  I want to run a method to see the output.

  Scenario Outline: Hello Msg Scenario
    Given the hello input "<name>"
    When The hello Method is called
    Then the hello output should be "<output>"


    Examples:
      | name | output      |
      | Lily | Hello Lily! |
      | meng | Hello meng! |