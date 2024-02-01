Feature: Service page fuctionality

  Background: 
    Given User navigate to service page

  Scenario: Check that the categories and links correspond to the appropriate category page
    When The blue stripe should display the category name with the respective category icon
    And The customer clicks on the category name
    Then They should be directed to the respective category page with services

  Scenario: Customer views the service page with service name
    When User can be seen at the top of service name

  Scenario: Customer views the service page with correct service image size
    Then the service image should have a size of correct pixels

  Scenario: Customer views the service page with vendor logo
    Then the vendor logo should be visible with a size of correct pixels

  Scenario: Customer views the service page with vendor information
    Then the vendor company name and tagline should be visible with the vendor logo

  Scenario: Customer views the service page with catalogs and cart option
    When the available catalogs should be displayed on the right side
    And the customer hovers over a catalog
    Then the cart option should appear

  Scenario: Customer views the service page with service tagline
    Then the service tagline should be visible

  Scenario: Customer views the service page with service description
    Then the service description should be visible

  Scenario: Customer views the service page with subcategories and technology tags
    Then the subcategories and technology tags of the service should be visible

  Scenario: Customer views the service page with vendor organization details
    When the vendor organization details should be visible in the footer section
    And the View marketplace profile link should be clickable
    Then they should be directed to the profile of the vendor organization
