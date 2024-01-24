@login_portal @regression
  Feature: Webdriver University Login Portal
    Scenario: Validate Successful Login - Specific Data
      Given I access the webdriver university login page
      When I enter specific user name webdriver
      And I enter specific password webdriver123
      And I click on login button
      And I validate the successful login
      Then I validate the pop up text message

    Scenario: Validate Successful Login - Unique Data
      Given I access the webdriver university login page
      When I enter a unique user name
      And I enter a unique password
      And I click on login button
      And I validate the successful login
      Then I need to validate the pop up failed message

