Feature: Checkout Item
  I want to use this template for my feature file

  Scenario : Verify able to Add to chart
    Given user navigate to application URL
    And user add item to cart
    When user view item cart
    Then display item on cart "<expected>"

    Example:
      | expected                      |
      | Your cart is currently empty. |
      | true                          |

  Scenario : Verify able to process to check out item
    Given user navigate to cart page
    When user process to check out
    Then display checkout page

  Scenario : Verify able to check out item
    Given user navigate to check out page
    And user fill the billing & shipping data "<firstName>" "<lastName>" "<address>" "<postalCode>" "<phone>" "<email>" "<notes>"
    When user place order the check out data
    Then display order received page "<expected>"

    Example:
      | firstName   | lastName   | address   | postalCode   | phone         | email         | notes | expected                                 |
      | try         | pane       | jakarta   | 40287        | 088218998123  | try@gmail.com | -     | Thank you. Your order has been received. |
