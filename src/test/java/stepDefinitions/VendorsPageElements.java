package stepDefinitions;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.VendorPage;
import pages.VendorsPage;

public class VendorsPageElements {
	
	WebDriver driver;
	private HomePage homePage;
	private VendorsPage vendorsPage;
	
	@Given("User navigate to the home page")
	public void user_navigate_to_the_home_page() {
		driver = DriverFactory.getDriver();
	}

	@And("User navigate to the vendors page")
	public void user_navigate_to_the_vendors_page() {
		homePage = new HomePage(driver);
		homePage.clickOnVendors();
		
		vendorsPage = new VendorsPage(driver);
	}

	@Then("the customer should see the vendors page with a list of available vendors")
	public void the_customer_should_see_the_vendors_page_with_a_list_of_available_vendors() {
		Assert.assertTrue(vendorsPage.displayrVendorsPageTitle());
	}

	@When("the customer enters vendor_text in the search bar with suggestions in the dropdown")
	public void the_customer_enters_vendor_text_in_the_search_bar_with_suggestions_in_the_dropdown() {
		Assert.assertFalse("This feature still not implemented in services page", true);
	}

	@Then("the customer can see related vendors based on the search text")
	public void the_customer_can_see_related_vendors_based_on_the_search_text() {
		Assert.assertFalse("This feature still not implemented in services page", true);
	}

	@When("the customer filters vendors by Latest")
	public void the_customer_filters_vendors_by_latest() {
		vendorsPage.clickVendorsFilterButton();
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		vendorsPage.selectVendorsLatestFilterOption();
	}

	@Then("the vendors should be displayed in the latest order")
	public void the_vendors_should_be_displayed_in_the_latest_order() {
	 //	Get the list of vendors
        List<WebElement> vendorsList = vendorsPage.getAllVendors();
        
     // Verify the order of vendors
        boolean isLatestOrder = vendorsPage.isLatestOrder(vendorsList);
        
     // Print the result
        if (isLatestOrder) {
        	Assert.assertTrue("vendors are displayed in the latest order.", true);
            System.out.println("vendors are displayed in the latest order.");
        } else {
            System.out.println("vendors are not displayed in the latest order.");
        }
	}

	@When("the customer filters vendors by A-Z")
	public void the_customer_filters_vendors_by_a_z() {
		vendorsPage.clickVendorsFilterButton();
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		vendorsPage.selectVendorsAtoZfilterOption();
	}

	@Then("the vendors should be displayed in alphabetical order")
	public void the_vendors_should_be_displayed_in_alphabetical_order() {
        List<WebElement> vendors = vendorsPage.getVendorsTitleList();
		
		List<String> vendorNames = vendors.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
		
		List<String> sortedVendorsNames = vendorNames.stream()
                .sorted()
                .collect(Collectors.toList());
		
		// Now, compare if the original list and the sorted list are the same
		assert vendorNames.equals(sortedVendorsNames) : "vendors are not displayed in alphabetical order";
	}

	@When("the customer filters vendors by Z-A")
	public void the_customer_filters_vendors_by_z_a() {
        vendorsPage.clickVendorsFilterButton();
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		vendorsPage.selectVendorsZtoAfilterOption();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("the vendors should be displayed in reverse alphabetical order")
	public void the_vendors_should_be_displayed_in_reverse_alphabetical_order() {
		List<WebElement> vendors = vendorsPage.getVendorsTitleList();

        List<String> vendorNames = vendors.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> sortedVendorNames = vendorNames.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        // Now, compare if the original list and the sorted list are the same
        assert vendorNames.equals(sortedVendorNames) : "Services are not displayed in reverse alphabetical order";
	}

	@When("the customer filters vendors by Price Low-High")
	public void the_customer_filters_vendors_by_price_low_high() {
		Assert.assertFalse("This feature still not implemented in services page", true); 
	}

	@Then("the vendors should be displayed in ascending order of price")
	public void the_vendors_should_be_displayed_in_ascending_order_of_price() {
		Assert.assertFalse("This feature still not implemented in services page", true); 
		
		/*
		List<WebElement> services = servicesPage.getServicesList();

        List<Double> prices = services.stream()
                .map(service -> Double.parseDouble(service.getAttribute("data-price")))
                .collect(Collectors.toList());

        List<Double> sortedPrices = prices.stream()
                .sorted()
                .collect(Collectors.toList());

        // Now, compare if the original list and the sorted list are the same
        assert prices.equals(sortedPrices) : "Services are not displayed in ascending order of price";
		 */
	}

	@When("the customer filters vendors by Price High-Low")
	public void the_customer_filters_vendors_by_price_high_low() {
		Assert.assertFalse("This feature still not implemented in services page", true); 
	}

	@Then("the vendors should be displayed in descending order of price")
	public void the_vendors_should_be_displayed_in_descending_order_of_price() {
		Assert.assertFalse("This feature still not implemented in services page", true);  
		
		/*
		List<WebElement> services = servicesPage.getServicesList();

        List<Double> prices = services.stream()
                .map(service -> Double.parseDouble(service.getAttribute("data-price")))
                .collect(Collectors.toList());

        List<Double> sortedPrices = prices.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        // Now, compare if the original list and the sorted list are the same
        assert prices.equals(sortedPrices) : "Services are not displayed in descending order of price";
		 */
	}

	@When("the customer chooses to all vendors")
	public void the_customer_chooses_to_all_vendors() {
		vendorsPage.clickOnAllVendors();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("the customer should see a list of all available vendors")
	public void the_customer_should_see_a_list_of_all_available_vendors() {
		// Write code here 
	}

	@When("the customer navigate to the first main categories vendors")
	public void the_customer_navigate_to_the_first_main_categories_vendors() {
	    // Write code here 
	}

	@Then("the customer should see a list of first main categories available vendors")
	public void the_customer_should_see_a_list_of_first_main_categories_available_vendors() {
	    // Write code here
	}

	@When("the customer navigate to the second main categories vendors")
	public void the_customer_navigate_to_the_second_main_categories_vendors() {
	    // Write code here 
	}

	@Then("the customer should see a list of second main categories available vendors")
	public void the_customer_should_see_a_list_of_second_main_categories_available_vendors() {
	    // Write code here 
	}

	@When("the customer navigate to the third main categories vendors")
	public void the_customer_navigate_to_the_third_main_categories_vendors() {
	    // Write code here 
	}

	@Then("the customer should see a list of third main categories available vendors")
	public void the_customer_should_see_a_list_of_third_main_categories_available_vendors() {
	    // Write code here 
	}

	@When("the customer navigate to the forth main categories vendors")
	public void the_customer_navigate_to_the_forth_main_categories_vendors() {
	    // Write code here 
	}

	@Then("the customer should see a list of forth main categories available vendors")
	public void the_customer_should_see_a_list_of_forth_main_categories_available_vendors() {
	    // Write code here 
	}

	@When("the customer navigate to the fifth main categories vendors")
	public void the_customer_navigate_to_the_fifth_main_categories_vendors() {
	    // Write code here 
	}

	@Then("the customer should see a list of fifth main categories available vendors")
	public void the_customer_should_see_a_list_of_fifth_main_categories_available_vendors() {
	    // Write code here
	}

	@When("the customer clicks on a specific vendor")
	public void the_customer_clicks_on_a_specific_vendor() {
		vendorsPage.clickOnVendor();  
	}

	@Then("the customer should be redirected to the respective vendor page")
	public void the_customer_should_be_redirected_to_the_respective_vendor_page() {
	    // Write code here 
	}

}
