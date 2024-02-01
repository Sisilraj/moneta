Feature: search fuctionality

  Background: 
    Given User navigate to Aytra Public marketplace

  Scenario: User search anything for services category
    When User click the search bar dropdown
    And User select the search category as services
    And User enter the any service name in the search field and enter
    Then The search result succesfully navigate to that particular service

  Scenario: User search anything for vendors category
    When User click the search bar dropdown
    And User select the search category as vendors
    And User enter the any vendor name in the search field and enter
    Then The search result succesfully navigate to that particular vendor
