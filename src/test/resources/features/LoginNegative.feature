#Author: Nataliia Azarnykh
#Email: azarnykhna@gmail.com
#Date: 13.11.2021
Feature: Login
  @Test @Login @L2
  Scenario: User can not log in with valid email and invalid password
    When L2 - user open sevenmind app
    And L2 - user taps on continue button
    And L2 - user taps on log in button
    And L2 - user taps email button
    And L2 - user enters valid email
    And L2 - user enters invalid password
    Then L2 - user should see the screen with meditation programs
