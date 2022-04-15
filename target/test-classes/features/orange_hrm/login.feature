@all
Feature: Orange HRM - Login
  As a user
  I want to perform login on facebook
  but I can't see my news feed due to FB restriction

  @hrmlogin
  Scenario: User login Orange HRM successfully
    Given I open Orange HRM login page
    When I input username and password
    And I click login button
    Then I can login successfully
