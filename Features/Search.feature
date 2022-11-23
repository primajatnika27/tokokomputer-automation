@tag
Feature: Search Product

  @tag1
  Scenario Outline: Verify able to search product
    Given user dashboard page
    When input a product "<name>"
    And click button search
    Then display search "<result>"
    Examples:
      | name | result |
      | bola | Nothing Found! Please refine your search and try again. |
      | vga |  |



#  @tag2
#  Scenario Outline: Title of your scenario outline
#    Given I want to write a step with "<name>"
#    When I check for the "<value>" in step
#    Then I verify the "<status>" in step
#
#    Examples:
#      | name  | value | status  |
#      | name1 |     5 | success |
#      | name2 |     7 | Fail    |