Feature: User Login to web

  @Positive
  Scenario: User successfully login
Given user open saucecode website
    When user input email
    And user input password
    And user click button login
    Then user directly to dashboard

    @Negative
  Scenario: User failed login
    Given user open saucecode website
    When user input invalid email
    And user input invalid password
    And user click button login
    Then user get error message

      @TDD-Positive-Negative
      Scenario Outline: User login with TDD
        Given user open saucecode website
        When user input <username> as username
        When user input <password> as password
        And user click button login
        Then user verify <status> login result

        Examples:
        | username      | password     | status      |
        | standard_user | secret_sauce | success     |
        | visual_user   | secret_sauce | success     |
        | salah_user    | secret_shala | failed      |
        |               | secret_sauce | blankemail  |
        | standard_user |              | blankpw     |