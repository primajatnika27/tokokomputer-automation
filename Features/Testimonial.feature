Feature: Title of your feature
  I want to use this template for my feature file

  Scenario Outline: Create new Testimonial
    Given user navigate to application URL testimonial
    When user input name "<name>" email "<email>" title "<title>" testimonial "<testimonial>"
    And  user click on submit button
    Then testimonial created

    Examples:
      | name    | email              | title | testimonial  |
      | test123 | test.123@gmail.com | Hiiii | Good website |