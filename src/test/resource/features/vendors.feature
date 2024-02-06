Feature: Vendors page fuctionality

  Background: 
    Given User navigate to the home page
    And User navigate to the vendors page

  Scenario: Customer views the vendors page
    Then the customer should see the vendors page with a list of available vendors

  Scenario: Customer search for vendors
    When the customer enters vendor_text in the search bar with suggestions in the dropdown
    Then the customer can see related vendors based on the search text

  Scenario: Customer filters vendors
    When the customer filters vendors by Latest
    Then the vendors should be displayed in the latest order
    When the customer filters vendors by A-Z
    Then the vendors should be displayed in alphabetical order
    When the customer filters vendors by Z-A
    Then the vendors should be displayed in reverse alphabetical order
    When the customer filters vendors by Price Low-High
    Then the vendors should be displayed in ascending order of price
    When the customer filters vendors by Price High-Low
    Then the vendors should be displayed in descending order of price

  Scenario: Customer views all vendors and navigates to main categories
    When the customer chooses to all vendors
    Then the customer should see a list of all available vendors
    When the customer navigate to the first main categories vendors
    Then the customer should see a list of first main categories available vendors
    When the customer navigate to the second main categories vendors
    Then the customer should see a list of second main categories available vendors
    When the customer navigate to the third main categories vendors
    Then the customer should see a list of third main categories available vendors
    When the customer navigate to the forth main categories vendors
    Then the customer should see a list of forth main categories available vendors
    When the customer navigate to the fifth main categories vendors
    Then the customer should see a list of fifth main categories available vendors

  Scenario: Customer clicks on a vendors and views the respective vendor page
    When the customer clicks on a specific vendor
    Then the customer should be redirected to the respective vendor page
