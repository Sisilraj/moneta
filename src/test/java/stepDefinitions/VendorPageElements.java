package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.VendorPage;
import pages.VendorsPage;

public class VendorPageElements {

	WebDriver driver;
	private HomePage homePage;
	private VendorsPage vendorsPage;
	private VendorPage vendorPage;

	SoftAssert softAssert = new SoftAssert();

	@Given("the customer is on the Vendor company profile page")
	public void the_customer_is_on_the_vendor_company_profile_page() {
		driver = DriverFactory.getDriver();

		homePage = new HomePage(driver);
		homePage.clickOnVendors();

		vendorsPage = new VendorsPage(driver);
		vendorsPage.selectFirstVendor();

		vendorPage = new VendorPage(driver);
	}

	@When("the customer should see the company name, logo, and tagline at top")
	public void the_customer_should_see_the_company_name_logo_and_tagline_at_top() {
		if (vendorPage.displayVendorCompanyLogo() 
			  && !vendorPage.vendorCompanyName.getText().isEmpty()
				&& !vendorPage.vendorCompanyTagline.getText().isEmpty()) {
			
			softAssert.assertTrue(true, "The customer should see the company name, logo, and tagline at top");
			
		} else {
			
			softAssert.assertFalse(true, "Vendor tagline feature is still not implemented");
		}
	}

	@Then("the logo size should be correct pixels")
	public void the_logo_size_should_be_128_x128_pixels() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int vendorImageWidth = vendorPage.getWidth();
		int vendorImageHeight = vendorPage.getHeight();

		String expectedVendorImageSize = "Vendor image : 128 x 128px";
		String actualVendorImageSize = "Vendor image : " + vendorImageWidth + " x " + vendorImageHeight + "px";

		softAssert.assertEquals(expectedVendorImageSize, actualVendorImageSize,
				"Vendor image is not expected size with 128x128px");
	}

	@And("the description should be visible below the company details")
	public void the_description_should_be_visible_below_the_company_details() {
		softAssert.assertFalse(true, "This feature still not implemented in services page");
	}

	@And("the social handles, contact options, country, and member since details should be in the right corner")
	public void the_social_handles_contact_options_country_and_member_since_details_should_be_in_the_right_corner() {
		if(vendorPage.verifyElementAtRightCorner(vendorPage.socialOptions) &&
			vendorPage.verifyElementAtRightCorner(vendorPage.verifiedVendorOptions) &&
			 vendorPage.verifyElementAtRightCorner(vendorPage.memberSinceDetails) &&
			  vendorPage.verifyElementAtRightCorner(vendorPage.fromCountry)){
			
			softAssert.assertTrue(true, "The social handles, contact options, country, and member since details are in the right corner");
			
		}else {
			softAssert.assertFalse(true, "country option is not appear in right corner");
		}
	}

	@When("the customer looks at the service categories section")
	public void the_customer_looks_at_the_service_categories_section() {
		vendorPage.scrollDownServiceCategoriesSection();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@And("the customer click on the service categories")
	public void the_customer_click_on_the_service_categories() {
		vendorPage.clickServiceCategoriesSection();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("the customer should see service tiles with filters and a view all option")
	public void the_customer_should_see_service_tiles_with_filters_and_a_view_all_option() {
		softAssert.assertFalse(true, "This feature still not implemented in services page");
	}

	@And("by default, eight tiles should be visible")
	public void by_default_eight_tiles_should_be_visible() {
		softAssert.assertFalse(true, "This feature still not implemented in services page");
	}

	@When("the customer selects view all")
	public void the_customer_selects_view_all() {
		softAssert.assertFalse(true, "This feature still not implemented in services page");
	}

	@Then("all services of the vendor should be visible in the expanded section")
	public void all_services_of_the_vendor_should_be_visible_in_the_expanded_section() {
		softAssert.assertFalse(true, "This feature still not implemented in services page");
	}

	@When("the customer looks at the company profile section")
	public void the_customer_looks_at_the_company_profile_section() {
		vendorPage.scrollDownProfileSection();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@And("the customer click on the company profile section")
	public void the_customer_click_on_the_company_profile_section() {
		vendorPage.clickProfileSection();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("by default, a list of three categories like Contact Details, Resume and Experience should be visible")
	public void by_default_a_list_of_three_categories_like_contact_details_resume_and_experience_should_be_visible() {
		
		List<WebElement> profileTabs = vendorPage.basicProfileTabs;
		
		for(WebElement profileTab : profileTabs) {
			
			if(profileTab.getText() == "Contact Details" && 
				profileTab.getText() == "Resume" && 
				 profileTab.getText() == "Experience") {
				
				softAssert.assertTrue(true, "By default, a list of three categories like Contact Details, Resume and Experience are visible properly");				
			}else {
				softAssert.assertFalse(true, "By default, a list of three categories like Contact Details, Resume and Experience are not visible properly");
			}
		}
	}

	@When("the customer select Contact Details")
	public void the_customer_select_contact_details() {
		vendorPage.clickOnContactDetails();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("the customer should be see all Contact Details")
	public void the_customer_should_be_see_all_contact_details() {
		softAssert.assertTrue(vendorPage.displayPhoneNumber());
		softAssert.assertTrue(vendorPage.displayEmail());
		softAssert.assertTrue(vendorPage.displayWebsite());
		softAssert.assertTrue(vendorPage.displaySocialPages());
	}

	@When("the customer select Resume")
	public void the_customer_select_resume() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		vendorPage.clickOnResume();
	}

	@Then("the customer should be see Resume Details")
	public void the_customer_should_be_see_resume_details() {
		softAssert.assertFalse(true, "This feature still not implemented in services page");
	}

	@When("the customer select Experience")
	public void the_customer_select_experience() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		vendorPage.clickOnExperience();
	}

	@Then("the customer should be see all Experiences")
	public void the_customer_should_be_see_all_experiences() {
		softAssert.assertFalse(true, "This feature still not implemented in services page");
	}

	@When("the customer expands an experience")
	public void the_customer_expands_an_experience() {
		softAssert.assertFalse(true, "This feature still not implemented in services page");
	}

	@Then("the customer should be able to view the description of the experience")
	public void the_customer_should_be_able_to_view_the_description_of_the_experience() {
		softAssert.assertFalse(true, "This feature still not implemented in services page");
	}

}
