Feature: Home page elements fuctionality

  Background: 
    Given User navigate to Aytra marketplace home page

  Scenario: verify of view the main service categories under the “Service” menu
    When User go to service menu place
    And User verify the recommended set of services should be viewed
    And User verify the services should be filtered according to the selected category tab.
    And User should be see proper service image
    And User should be see service company logo
    And User should be see service name
    And User should be see proper price range
    And User should be see any applicable discounts in a service card
    Then user click on one service, that particular service navigate to proper service page

  Scenario: verify of view the main vendors/providers categories under the “Vendors/Providers” menu
    When User go to Vendors/Providers menu place
    And User verify the recommended set of vendors/providers should be viewed
    And User should be see vendors/providers company logo
    And User should be see vendor company name
    Then user click on one vendors/providers, that particular vendors/providers navigate to proper vendors/providers page
