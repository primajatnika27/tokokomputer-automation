Feature: Login to Application

  @LoginTest
  Scenario Outline: User should only be able to login with valid credentials
    Given user navigate to check login page
    When I enter Username as "<someusername>" and Password as "<somepassword>" into the field
    And I click on Login button
    Then User should be able to login based on "<expected>" login status

    Examples:
      | someusername                 | somepassword  | expected                                                                      |
      |                              |               | Error: The username field is empty.                                           |
      | try123                       | superuser     | ERROR: The username or password you entered is incorrect. Lost your password? |
      | primajatnika271995@gmail.com | Risingforce1! |                                                                               |