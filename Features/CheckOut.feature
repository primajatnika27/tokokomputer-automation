Feature: Checkout Item

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

  @Checkout
  Scenario Outline: Verify able to process checkout
    Given user fill the billing & shipping data "<firstName>" "<lastName>" "<address>""<state>""<city>""<district>" "<postalCode>" "<phone>" "<email>" "<notes>"
    When user place order the check out data
    Then display order received page "<expected>"
    Examples:
      | firstName | lastName | address | state | city | district | postalCode | phone        | email         | notes | expected                                 |
      | try       | pane     | jakarta | 1     | 4    | 4        | 40287      | 088218998123 | try@gmail.com | -     | Thank you. Your order has been received. |

