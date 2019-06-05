Feature: Login feature
  User should be able to login with correct credentials
  User should not be able to login with invalid credentials

  Scenario: Login with invalid credential
    Given User is in Learnyst login page
    When User enter username and password

    Then User should be shown error message


  Scenario: Login with valid credential
    Given User is in Learnyst login page
    When User enters username and password
    Then User is logged in