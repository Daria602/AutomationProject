Feature: GetItem

  Scenario: Add Item to cart correctly
    Given I have logged in
    And I navigate to pants section
    And I select first item
    When I select size and color options
    And I click Add to cart button
    Then I see success message with selected item name

  Scenario: Add Item to cart without size and color option
    Given I have logged in
    And I navigate to pants section
    And I select first item
    And I click Add to cart button
    Then I see error message