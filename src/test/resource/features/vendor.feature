Feature: View Vendor Company Profile

  Scenario: Customer views company details and services
    Given the customer is on the Vendor company profile page
    When the customer should see the company name, logo, and tagline at top
    Then the logo size should be correct pixels
    And the description should be visible below the company details
    And the social handles, contact options, country, and member since details should be in the right corner

    When the customer looks at the service categories section
    And the customer click on the service categories
    Then the customer should see service tiles with filters and a view all option
    And by default, eight tiles should be visible
    When the customer selects view all
    Then all services of the vendor should be visible in the expanded section

    When the customer looks at the company profile section
    And the customer click on the company profile section
    Then by default, a list of three categories like Contact Details, Resume and Experience should be visible
    When the customer select Contact Details
    Then the customer should be see all Contact Details
    When the customer select Resume
    Then the customer should be see Resume Details
    When the customer select Experience
    Then the customer should be see all Experiences
    When the customer expands an experience
    Then the customer should be able to view the description of the experience
    Then I assert all Vendor page soft assertions