Feature: Login
  As a user
  I want to test login functionality
  so that I can be sure that it works correctly


  Scenario Outline:Check sign in with valid credentials
    Given User opens '<homePage>' page
    And User checks sign in icon visibility
    When User clicks on 'sign in' link
    And User checks email and password fields visibility
    And User enter '<email>' into email field
    And User enter '<password>' into password field
    And User click on 'sign in' button
    Then User checks that current url '<url>'

    Examples:
      | homePage                          | email                | password   | url                                  |
      | https://www.vitaminworld.com/home | tsmt0505@yopmail.com | Password@1 | https://www.vitaminworld.com/account |