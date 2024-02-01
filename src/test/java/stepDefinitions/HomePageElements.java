package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.ServicesPage;
import pages.ServicesProvidersPage;
import pages.VendorsPage;

public class HomePageElements {
	
	WebDriver driver;
	private HomePage homePage;
	private ServicesPage servicesPage;
	private VendorsPage vendorsPage;
	private ServicesProvidersPage servicesProvidersPage;
	
	@Given("User navigate to Aytra marketplace home page")
	public void user_navigate_to_aytra_marketplace_home_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
	}

	@When("User go to service menu place")
	public void user_go_to_service_menu_place() {
	    // Write code here 
	}

	@And("User verify the recommended set of services should be viewed")
	public void user_verify_the_recommended_set_of_services_should_be_viewed() {
	    // Write code here 
	}

	@And("User verify the services should be filtered according to the selected category tab.")
	public void user_verify_the_services_should_be_filtered_according_to_the_selected_category_tab() {
	    // Write code here 
	}

	@And("User should be see proper service image")
	public void user_should_be_see_proper_service_image() {
	    // Write code here 
	}

	@And("User should be see service company logo")
	public void user_should_be_see_service_company_logo() {
	    // Write code here 
	}

	@And("User should be see service name")
	public void user_should_be_see_service_name() {
	    // Write code here 
	}

	@And("User should be see proper price range")
	public void user_should_be_see_proper_price_range() {
	    // Write code here 
	}

	@And("User should be see any applicable discounts in a service card")
	public void user_should_be_see_any_applicable_discounts_in_a_service_card() {
	    // Write code here 
	}

	@Then("user click on one service, that particular service navigate to proper service page")
	public void user_click_on_one_service_that_particular_service_navigate_to_proper_service_page() {
	    // Write code here 
	}

	@When("User go to Vendors\\/Providers menu place")
	public void user_go_to_vendors_providers_menu_place() {
	    // Write code here
	}

	@And("User verify the recommended set of vendors\\/providers should be viewed")
	public void user_verify_the_recommended_set_of_vendors_providers_should_be_viewed() {
	    // Write code here 
	}

	@And("User should be see vendors\\/providers company logo")
	public void user_should_be_see_vendors_providers_company_logo() {
	    // Write code here 
	}

	@And("User should be see vendor company name")
	public void user_should_be_see_vendor_company_name() {
	    // Write code here 
	}

	@Then("user click on one vendors\\/providers, that particular vendors\\/providers navigate to proper vendors\\/providers page")
	public void user_click_on_one_vendors_providers_that_particular_vendors_providers_navigate_to_proper_vendors_providers_page() {
	    // Write code here 
	}

	@When("User go to youtube screen place")
	public void user_go_to_youtube_screen_place() {
		homePage.scrollDownToYoutube();
	}

	@Then("User verify that video succesfully playable")
	public void user_verify_that_video_succesfully_playable() {
		if(homePage.youtubePlay.getAttribute("src").equals("https://www.youtube.com/embed/0ytcSOKm-mk?rel=0")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}

	@When("User click on the Services at navbar")
	public void user_click_on_the_services_at_navbar() {
		homePage.clickOnServices();
	}

	@Then("The page should be navigate to services page succesfully")
	public void the_page_should_be_navigate_to_services_page_succesfully() {
		servicesPage = new ServicesPage(driver);
		Assert.assertTrue(servicesPage.displayServicePageTitle());
	}

	@When("User click on the Vendors at navbar")
	public void user_click_on_the_vendors_at_navbar() {
		homePage.clickOnVendors();
	}

	@Then("The page should be navigate to Vendors page succesfully")
	public void the_page_should_be_navigate_to_vendors_page_succesfully() {
		vendorsPage = new VendorsPage(driver);
		Assert.assertTrue(vendorsPage.displayrVendorsPageTitle());
	}

	@When("User click on the Services Providers at navbar")
	public void user_click_on_the_services_providers_at_navbar() {
		homePage.clickOnServicesProviders();
	}

	@Then("The page should be navigate to Services Providers page succesfully")
	public void the_page_should_be_navigate_to_services_providers_page_succesfully() {
		servicesProvidersPage = new ServicesProvidersPage(driver);
		Assert.assertTrue(servicesProvidersPage.displayServiceProviderPageTitle());
	}

}
