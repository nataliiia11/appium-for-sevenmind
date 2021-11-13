#Author: Nataliia Azarnykh
#Email: azarnykhna@gmail.com
#Date: 09.11.2021
Feature: Login
  @Test @Login @L1
  Scenario: User can log in with valid email and password
    When L1 - user open sevenmind app
    And L1 - user taps on continue button
    And L1 - user taps on log in button
    And L1 - user taps email button
    And L1 - user enters email
    And L1 - user enters password
    Then L1 - user should see the screen with meditation programs


