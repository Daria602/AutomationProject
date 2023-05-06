Feature: Registration

  Scenario: Register with valid information
    Given I am on the registration page
    When I enter my registration information:
      | first_name | last_name | password         | confirm_password |
      | John       | Smith     | Testingstuff123! | Testingstuff123! |
    And I click on the register button
    Then I land on the my account page

  Scenario: Register with invalid information
    Given I am on the registration page
    When I enter my registration information:
      | first_name | last_name | password      | confirm_password |
      | Jonas      | Droner    | Bucharest123! | Bucharest124!    |
    And I click on the register button
    Then I am met with the error message "Please make sure your passwords match."

