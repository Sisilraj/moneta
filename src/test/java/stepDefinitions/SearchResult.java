package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ServicePage;
import pages.VendorsPage;

public class SearchResult {
	
	WebDriver driver;
	private HomePage homePage;
	private ServicePage servicePage;
	private VendorsPage vendorsPage;
	
	@Given("User navigate to search bar page")
	public void user_navigate_to_search_bar_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
	}

	@When("User click the search bar dropdown")
	public void user_click_the_search_bar_dropdown() {
		homePage.clickOnDropdownSymbol();
	}

	@And("User select the search category as services")
	public void user_select_the_search_category_as_services() {
		homePage.selectServiceInDropdown();
	}

	@And("User enter the any service name in the search field and enter")
	public void user_enter_the_any_service_name_in_the_search_field_and_enter() {
		homePage.searchbar.sendKeys("rob");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		homePage.autoSuggestionWithServicePage();
		
//		driver = DriverFactory.getDriver();
//		servicePage = new ServicePage(driver);
	}

	@Then("The search result succesfully navigate to that particular service")
	public void the_search_result_succesfully_navigate_to_that_particular_service() {
		servicePage = new ServicePage(driver);
		String expectTitle = "Robert Cooke temporal";
		String actualTitle = servicePage.displayRobertCookeServiceTitle();
		
		Assert.assertEquals(actualTitle, expectTitle);
	}
	
	@And("User select the search category as vendors")
	public void user_select_the_search_category_as_vendors() {
		homePage.selectVendorInDropdown();
	}

	@And("User enter the any vendor name in the search field and enter")
	public void user_enter_the_any_vendor_name_in_the_search_field_and_enter() {
		homePage.searchbar.sendKeys("su");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		homePage.autoSuggestionWithVendorsPage();
		
//		driver = DriverFactory.getDriver();
//		vendorsPage = new VendorsPage(driver);
	}

	@Then("The search result succesfully navigate to that particular vendor")
	public void the_search_result_succesfully_navigate_to_that_particular_vendor() {
		vendorsPage = new VendorsPage(driver);
		String actualTitle = vendorsPage.displaySuperVendorsTitle();
		String expectTitle = "Super Vendors";
		
		Assert.assertEquals(actualTitle, expectTitle);
	}
	
}
