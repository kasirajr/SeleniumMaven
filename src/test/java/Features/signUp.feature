Feature: Signup to Learnyst website
  User should be able to sign up to website with valid data
  User should not be able to sign up with invalid data

  Scenario: Signup with valid data
    Given User is in signup page of Learnyst website
    When User fills signup form with valid data
      | email                | password   |
      | xidsc@eaglemail.top | Password32 |
    Then User is signed up and home page is shown

  Scenario: Signup using facebook
    Given User is in signup page of Learnyst website
    When User clicks signup using facebook
    And User gives permission to use facebook information
    Then User is signed up and home page is shown
