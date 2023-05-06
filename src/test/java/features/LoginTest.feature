Feature: Login

  Scenario: Login with valid information
    Given I am on the login page
    When I enter my login information:
      | email               | password      |
      | test@validlogin.com | Bucharest123! |
    And I click on the login button
    Then I see my account details


  Scenario: Login with invalid information
    Given I am on the login page
    When I enter my login information:
      | email | password |
      | test@invalidlogin.com | Bucharest123!   |
    And I click on the login button
    Then I am met with the error message "Incorrect CAPTCHA"

# Initially, the message below was displayed, but after many many tries it changed to the current one
#  The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.
