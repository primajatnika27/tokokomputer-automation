@tag
Feature: Search Product

  @SearchItem
  Scenario Outline: Verify able to search product
    Given user navigate to application URL
    When input a product "<name>"
    And click button search
    Then display search "<result>"

    Examples:
      | name | result                                                  |
      | bola | Nothing Found! Please refine your search and try again. |
      | vga  | Success search item                                     |