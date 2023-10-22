Feature: User checkout product

  @CheckoutScenario
  Scenario Outline: User successfully check out
    Given user open saucecode app
    When user filled <username> as a username
    And user filled <password> as a password
    And user go to click login button
    Then user get <status> login status
    When user click product
    Then user directly to product detail
    When user press Add to Cart Button
    Then Cart badge will increase total product
    When User click Shopping cart badge
    Then detail checkout will display
    When user click checkout buttton
    Then display User information
    And user input <firstname> as first name
    And user input <lastname> as last name
    And user input <zipcode> as zip code
    And user click continue button
    Then directly to overview page
    When user click finish button
    Then Will display Complete order page

    Examples:
      | username      | password     | status  | firstname | lastname | zipcode |
      | standard_user | secret_sauce | success | dea       | amelia   | 425671  |