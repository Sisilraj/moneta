package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ServicePage;
import pages.ServicesPage;

public class ServicePageElements {
	
	WebDriver driver;
	private HomePage homePage;
	private ServicePage servicePage;
	private ServicesPage servicesPage;
	
	@Given("User navigate to service page")
	public void user_navigate_to_service_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnServices();
		servicesPage = new ServicesPage(driver);
		servicesPage.clickOnFirstService();
		servicePage = new ServicePage(driver);
	}

	@When("The blue stripe should display the category name with the respective category icon")
	public void the_blue_stripe_should_display_the_category_name_with_the_respective_category_icon() {
		Assert.assertFalse("This feature still not implemented in services page", true);
	}

	@And("The customer clicks on the category name")
	public void the_customer_clicks_on_the_category_name() {
		Assert.assertFalse("This feature still not implemented in services page", true);
	}

	@Then("They should be directed to the respective category page with services")
	public void they_should_be_directed_to_the_respective_category_page_with_services() {
		Assert.assertFalse("This feature still not implemented in services page", true);
	}

	@When("User can be seen at the top of service name")
	public void user_can_be_seen_at_the_top_of_service_name() {
		Assert.assertTrue(servicePage.verifyTopOfServiceTitle());
	}

	@Then("the service image should have a size of correct pixels")
	public void the_service_image_should_have_a_size_of_420x425_pixels() {  
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int serviceImageWidth = servicePage.getWidth();
		int serviceImageHeight = servicePage.getHeight();
		
		String expectedServiceImageSize = "Service image : 420 x 425px";
		String actualServiceImageSize = "Service image : " + serviceImageWidth + " x " + serviceImageHeight + "px";
		
		Assert.assertEquals(expectedServiceImageSize, actualServiceImageSize, "Service image is not expected size with 420x425px");
	}

	@Then("the vendor logo should be visible with a size of correct pixels")
	public void the_vendor_logo_should_be_visible_with_a_size_of_56x56_pixels() {
		Assert.assertFalse("This feature still not implemented in services page", true);
	}

	@Then("the vendor company name and tagline should be visible with the vendor logo")
	public void the_vendor_company_name_and_tagline_should_be_visible_with_the_vendor_logo() {
		Assert.assertFalse("This feature still not implemented in services page", true);
	}

	@When("the available catalogs should be displayed on the right side")
	public void the_available_catalogs_should_be_displayed_on_the_right_side() {
		Assert.assertFalse("This feature still not implemented in services page", true);
	}

	@And("the customer hovers over a catalog")
	public void the_customer_hovers_over_a_catalog() {
		Assert.assertFalse("This feature still not implemented in services page", true);
	}

	@Then("the cart option should appear")
	public void the_cart_option_should_appear() {
		Assert.assertFalse("This feature still not implemented in services page", true);
	}

	@Then("the service tagline should be visible")
	public void the_service_tagline_should_be_visible() {
		servicePage.scrollDownIntoTechTags();
		Assert.assertTrue(servicePage.displayServiceTagline());
	}

	@Then("the service description should be visible")
	public void the_service_description_should_be_visible() {
		servicePage.scrollDownIntoTechTags();
		Assert.assertTrue(servicePage.displayServiceDescription());
	}

	@Then("the subcategories and technology tags of the service should be visible")
	public void the_subcategories_and_technology_tags_of_the_service_should_be_visible() {
		servicePage.scrollDownIntoTechTags();
		List<WebElement> technologies = servicePage.getTechTags();
		
		if(technologies.containsAll(technologies)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse("Technologies tags are not visible", true);
		}
	}

	@When("the vendor organization details should be visible in the footer section")
	public void the_vendor_organization_details_should_be_visible_in_the_footer_section() {
		Assert.assertFalse("This feature still not implemented in services page", true);
	}

	@And("the View marketplace profile link should be clickable")
	public void the_view_marketplace_profile_link_should_be_clickable() {
		Assert.assertFalse("This feature still not implemented in services page", true);
	}

	@Then("they should be directed to the profile of the vendor organization")
	public void they_should_be_directed_to_the_profile_of_the_vendor_organization() {
		Assert.assertFalse("This feature still not implemented in services page", true); 
	}

}
