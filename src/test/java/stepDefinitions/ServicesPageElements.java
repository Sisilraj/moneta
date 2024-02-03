package stepDefinitions;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ServicePage;
import pages.ServicesPage;

public class ServicesPageElements {
	
	WebDriver driver;
	private HomePage homePage;
	private ServicesPage servicesPage;
	private ServicePage servicePage;
	
	@Given("User navigate to services page")
	public void user_navigate_to_services_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnServices();
		servicesPage = new ServicesPage(driver);
		servicePage = new ServicePage(driver);
	}

	@Then("the customer should see the services page with a list of available services")
	public void the_customer_should_see_the_services_page_with_a_list_of_available_services() {
		Assert.assertTrue("There are more than 4 services", servicesPage.services.size()>4);
	}

	@When("the customer enters search_text in the search bar with suggestions in the dropdown")
	public void the_customer_enters_search_text_in_the_search_bar_with_suggestions_in_the_dropdown() {
		Assert.assertFalse("This feature still not implemented in services page", true);	
	}

	@Then("the customer can see related services based on the search text")
	public void the_customer_can_see_related_services_based_on_the_search_text() {
		Assert.assertFalse("This feature still not implemented in services page", true);
	}

	@When("the customer filters services by Latest")
	public void the_customer_filters_services_by_latest() {
		servicesPage.clickOnFilterOfServices();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		servicesPage.selectLatestServicesFilterOptions();
	}

	@Then("the services should be displayed in the latest order")
	public void the_services_should_be_displayed_in_the_latest_order() {
	 //	 Get the list of services
        List<WebElement> servicesList = servicesPage.getAllServices();
        
     // Verify the order of services
        boolean isLatestOrder = servicesPage.isLatestOrder(servicesList);
        
     // Print the result
        if (isLatestOrder) {
        	Assert.assertTrue("Services are displayed in the latest order.", true);
            System.out.println("Services are displayed in the latest order.");
        } else {
            System.out.println("Services are not displayed in the latest order.");
        }
	}

	@When("the customer filters services by A-Z")
	public void the_customer_filters_services_by_a_z() {
		servicesPage.clickOnFilterOfServices();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		servicesPage.select_A_Z_ServicesFilterOptions(); 
	}

	@Then("the services should be displayed in alphabetical order")
	public void the_services_should_be_displayed_in_alphabetical_order() {
		List<WebElement> services = servicesPage.getServicesTitleList();
		
		List<String> serviceNames = services.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
		
		List<String> sortedServiceNames = serviceNames.stream()
                .sorted()
                .collect(Collectors.toList());
		
		// Now, compare if the original list and the sorted list are the same
		assert serviceNames.equals(sortedServiceNames) : "Services are not displayed in alphabetical order";
	}

	@When("the customer filters services by Z-A")
	public void the_customer_filters_services_by_z_a() {
		servicesPage.clickOnFilterOfServices();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		servicesPage.select_Z_A_ServicesFilterOptions(); 
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("the services should be displayed in reverse alphabetical order")
	public void the_services_should_be_displayed_in_reverse_alphabetical_order() {
		List<WebElement> services = servicesPage.getServicesTitleList();

        List<String> serviceNames = services.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        List<String> sortedServiceNames = serviceNames.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        // Now, compare if the original list and the sorted list are the same
        assert serviceNames.equals(sortedServiceNames) : "Services are not displayed in reverse alphabetical order"; 
	}

	@When("the customer filters services by Price Low-High")
	public void the_customer_filters_services_by_price_low_high() {
		Assert.assertFalse("This feature still not implemented in services page", true); 
	}

	@Then("the services should be displayed in ascending order of price")
	public void the_services_should_be_displayed_in_ascending_order_of_price() {
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

	@When("the customer filters services by Price High-Low")
	public void the_customer_filters_services_by_price_high_low() {
		Assert.assertFalse("This feature still not implemented in services page", true);
	}

	@Then("the services should be displayed in descending order of price")
	public void the_services_should_be_displayed_in_descending_order_of_price() {
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

	@When("the customer chooses to all services")
	public void the_customer_chooses_to_all_services() {
		servicesPage.clickOnAllCategory();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("the customer should see a list of all available services")
	public void the_customer_should_see_a_list_of_all_available_services() {
		if(servicesPage.displayDevOpsText().equals("DevOps")
			&& servicesPage.displayBusinessApplicationsText().equals("Business Applications")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@When("the customer choose to Application servers category")
	public void the_customer_choose_to_application_servers_category() {
	    servicesPage.clickOnAppSerCategory();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("the customer should see a list of Application servers available services")
	public void the_customer_should_see_a_list_of_application_servers_available_services() {
		
		servicesPage.selectAppSerCategoryFirstService();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		servicePage.scrollDownIntoTechTags();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<WebElement> technologies = servicePage.getTechTags();
		
		for(WebElement technology: technologies) {
			String techTag = technology.getText();
			System.out.println(techTag);
			if(techTag.equals("Application Servers")){
				Assert.assertTrue(true);
			}
		}
		
		driver.navigate().back();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

	@When("the customer choose to Blockchain category")
	public void the_customer_choose_to_blockchain_category() {
		servicesPage.clickOnBlockchainCategory();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("the customer should see a list of Blockchain available services")
	public void the_customer_should_see_a_list_of_blockchain_available_services() {
		
		servicesPage.selectBlockchainCategoryFirstService();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		servicePage.scrollDownIntoTechTags();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<WebElement> technologies = servicePage.getTechTags();
		
		for(WebElement technology: technologies) {
			String techTag = technology.getText();
			if(techTag.equals("Blockchain")) {
				Assert.assertTrue(true);
			}
		}
		
		driver.navigate().back();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("the customer choose to DevOps category")
	public void the_customer_choose_to_dev_ops_category() {
		servicesPage.clickOnDevOpsCategory();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("the customer should see a list of DevOps available services")
	public void the_customer_should_see_a_list_of_dev_ops_available_services() {
		
		servicesPage.selectDevOpsCategoryFirstService();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		servicePage.scrollDownIntoTechTags();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<WebElement> technologies = servicePage.getTechTags();
		
		for(WebElement technology: technologies) {
			String techTag = technology.getText();
			if(techTag.equals("DevOps")) {
				Assert.assertTrue(true);
			}
		}
		
		driver.navigate().back();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("the customer choose to Business Applications category")
	public void the_customer_choose_to_business_applications_category() {
		servicesPage.clickOnBusinessApplicationsCategory();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("the customer should see a list of Business Applications available services")
	public void the_customer_should_see_a_list_of_business_applications_available_services() {
		
		servicesPage.selectBusAppCategoryFirstService();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		servicePage.scrollDownIntoTechTags();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<WebElement> technologies = servicePage.getTechTags();
		
		for(WebElement technology: technologies) {
			String techTag = technology.getText();
			if(techTag.equals("Business Applications")) {
				Assert.assertTrue(true);
			}
		}
	}

	@When("the customer clicks on a specific service")
	public void the_customer_clicks_on_a_specific_service() {
		servicesPage.clickOnFirstService();
	}

	@Then("the customer should be redirected to the respective service page")
	public void the_customer_should_be_redirected_to_the_respective_service_page() {
		servicePage = new ServicePage(driver);	
		Assert.assertTrue(servicePage.displyEcbSupplyTitle());
	}

}
