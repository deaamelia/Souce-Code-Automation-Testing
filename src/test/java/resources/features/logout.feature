Feature: user logout from website


  @LogoutScenario
  Scenario Outline: user successfully logout from website
    Given user open the saucecode website
    When user fill <username> as username
    When user fill <password> as password
    And user press button login
    Then user get <status> of login
    When user click menu button on above right page
    And user click logout
    Then user back to login page

    Examples:
      | username      | password     | status  |
      | standard_user | secret_sauce | success |
