@testPages
  Feature: Testpages challenges

    @testPages1
    Scenario: Test alerts
      Given I open url "https://testpages.eviltester.com/styled/index.html"
      When I click on element with xpath "//a[@id='alerttest']"
      And I click on element with xpath "//input[@id='alertexamples']"
      And I accept alert

      @testPages2
      Scenario: Test alerts accepted with assertions
      Given I open url "https://testpages.eviltester.com/styled/index.html"
      When I click on element with xpath "//a[@id='alerttest']"
      And I click on element with xpath "//input[@id='confirmexample']"
      And I accept alert
      Then I verify that alert accepted
    @testPages3
    Scenario: Test alerts dismissed with assertions
      Given I open url "https://testpages.eviltester.com/styled/index.html"
      When I click on element with xpath "//a[@id='alerttest']"
      And I click on element with xpath "//input[@id='confirmexample']"
      And I dismiss alert
      Then I verify that alert dismissed
    @testPages4
    Scenario: Test alerts prompted with assertions
      Given I open url "https://testpages.eviltester.com/styled/index.html"
      When I click on element with xpath "//a[@id='alerttest']"
      And I click on element with xpath "//input[@id='promptexample']"
      And I enter "Test" inside alert
      And I accept alert
      Then I verify entered text
    @testPages5
    Scenario: Webdriver example test page
      Given I open url "https://testpages.eviltester.com/styled/index.html"
      When I click on element with xpath "//a[@id='webdriverexamplepage']"
      And I enter 12345678911 in the search field
      And I wait for 3 sec
      Then I verify the numbers entered presents on the page