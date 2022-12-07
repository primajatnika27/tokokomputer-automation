Feature: Chekout Item

  @AddItem
  Scenario Outline: Verify able to Add to chart
    Given user navigate to application URL chart
    And user search any item "<arg0>"
    When user add item to chart
    And user view item cart
    Then display item on cart "<arg01>"

    Examples:
      | arg0          | arg01                |
      | intel core i5 | Success add to Chart |

  @CheckoutItem
  Scenario Outline: Verify able to process to check out item
    Given user process to check out
    Then display checkout page "<expected>"

    Examples:
      | expected                   |
      | Success show shipping page |
