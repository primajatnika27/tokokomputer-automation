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
      | vga | success |