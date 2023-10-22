Feature: User Add Product to Cart

  @Positive-AddToCart
  Scenario Outline: User successfully add to cart
    Given user success open saucecode website
    When user input <username> as a username
    And user input <password> as a password
    And user click login button
    Then user get <status> login result
    When user click one product
    Then user direct to product detail
    When user click Add to Cart Button
    Then Cart Symbol will increase total product
    When User click Remove button
    Then Cart Symbol will deacres total product

    Examples:
      | username      | password     | status  |
      | standard_user | secret_sauce | success |