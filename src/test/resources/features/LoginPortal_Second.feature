@Second_Login @regression

Feature: Webdriver University - Contact Us Page

  Background:
    Given I access the webdriver university - Contact Us Page


@dummyTag
  Scenario: Validate Successful Login
    Given I access the webdriver university - Contact Us Page
    When I enter username "webdriver"
    And I enter password webdriver123
    And I click on login btn
    Then I should present with successful message

  Scenario: Validate Unsuccessful Login
    When I enter username "webdriver1"
    And I enter password webdriver123
    And I click on login btn
    Then I should be presented with unsuccessful message

  Scenario Outline: Validate - Successful & Unsuccessful Login
    When I enter unique username <username>
    And I enter password <password>
    And I click on login btn
    Then I should presented with the following login validation message <loginValidationMessage>

    Examples:
      | username   | password     | loginValidationMessage |
      | webdriver  | webdriver123 | validation succeeded   |
      | webdriver  | webdriver1   | validation failed      |
      | arsh_blogs | password1    | validation failed     |

