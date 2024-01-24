@contact_us
#  We can also use more tags next to each other or at new line for more scenario.

Feature: WebDriver University - Contact Us Page

  Scenario: Validate Successful Submission - Unique Data
    Given I access the webdriver university contact us page
    When I enter a unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click on Submit Button
    Then I should be presented with a successful contact us submission message

#    chromeOptions.addArguments("--remote-allow-origins=*");
  Scenario: Validate Successful Submission - Specific Data
    Given I access the webdriver university contact us page
    When I enter a specific first name Arash
    And I enter a specific last name Mohammad
    And I enter a specific email address arashperzai@yahoo.com
    And I enter a specific comment "How are you?"
    And I click on Submit Button
    Then I should be presented with a successful contact us submission message

