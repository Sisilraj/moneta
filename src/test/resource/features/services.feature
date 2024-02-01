Feature: Services page fuctionality

  Background: 
    Given User navigate to services page

  Scenario: Customer views the service page
    Then the customer should see the services page with a list of available services
    
  Scenario: Customer search for services
    When the customer enters search_text in the search bar with suggestions in the dropdown
    Then the customer can see related services based on the search text

  Scenario: Customer filters services
    When the customer filters services by Latest
    Then the services should be displayed in the latest order
    When the customer filters services by A-Z
    Then the services should be displayed in alphabetical order
    When the customer filters services by Z-A
    Then the services should be displayed in reverse alphabetical order
    When the customer filters services by Price Low-High
    Then the services should be displayed in ascending order of price
    When the customer filters services by Price High-Low
    Then the services should be displayed in descending order of price

  Scenario: Customer views all services and navigates to main categories
    When the customer chooses to all services
    Then the customer should see a list of all available services
    When the customer navigates to the main categories
    Then the customer should be able to see the main service categories

  Scenario: Customer clicks on a service and views the respective service page
    When the customer clicks on a specific service
    Then the customer should be redirected to the respective service page
