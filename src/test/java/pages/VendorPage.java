package pages;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import utility.ElementUtils;

public class VendorPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	private SoftAssert softAssert;

	public VendorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
		softAssert = new SoftAssert();
	}

	@FindBy(xpath = "//p[text()='Super Vendors']")
	private WebElement superVendorsTitle;

	public String displaySuperVendorsTitle() {
		return elementUtils.getTextFromElement(superVendorsTitle, 10);
	}

	// Logo, company name, tagline, and description
	@FindBy(xpath = "//div[@class='profile-details-img']//img[1]")
	private WebElement vendorCompanyLogo;

	public void displayVendorCompanyLogo() {
		// return elementUtils.visibleTextFromElement(vendorCompanyLogo, 10);
		softAssert.assertEquals(true, elementUtils.visibleTextFromElement(vendorCompanyLogo, 10),
				"Company logo is not present in the page");
	}

	@FindBy(xpath = "//div[@class='profile-details-text']//div[1]//p[1]")
	public WebElement vendorCompanyName;

	public void displayVendorCompanyName() {
		// return elementUtils.visibleTextFromElement(vendorCompanyLogo, 10);
		softAssert.assertEquals(elementUtils.getTextFromElement(vendorCompanyName, 10), "FinTech Hive (PVT) Ltd",
				"Company name is not expected");
	}

	@FindBy(xpath = "//div[@class='profile-details-text']//div[1]//p[2]")
	public WebElement vendorCompanyTagline;

	public void displayVendorCompanyTagline() {
		// return elementUtils.visibleTextFromElement(vendorCompanyLogo, 10);
		softAssert.assertEquals(true, elementUtils.visibleTextFromElement(vendorCompanyTagline, 10),
				"Company tag line is not display");
	}

	// Vendor image
	@FindBy(xpath = "(//div[contains(@class,'profile-details MuiBox-root')]//div)[1]//img")
	private WebElement vendorImage;

	public void verifyLogoSize() {
		Dimension imageSize = vendorImage.getSize();
		int vendorImageWidth = imageSize.width;
		int vendorImageHeight = imageSize.height;

		String expectedVendorImageSize = "Vendor image : 128 x 128px";
		String actualVendorImageSize = "Vendor image : " + vendorImageWidth + " x " + vendorImageHeight + "px";

		softAssert.assertEquals(expectedVendorImageSize, actualVendorImageSize,
				"Vendor image is not expected size with 128x128px");
	}

	// Company description
	@FindBy(xpath = "(//div[@class='profile-features-inner'])[1]//p")
	private WebElement vendorCompanyDescription;

	public void displayVendorCompanyDescription() {
		softAssert.assertEquals(elementUtils.getTextFromElement(vendorCompanyDescription, 10),
				"Vendor company description", "No any vendor company description");
	}

	// social handles, contact options, country, and member since details
	@FindBy(xpath = "(//div[contains(@class,'MuiGrid-root MuiGrid-item')])[3]/div//a[1]")
	public WebElement socialOptions;

	@FindBy(xpath = "(//div[contains(@class,'MuiGrid-root MuiGrid-item')])[3]/div[2]/div[2]")
	public WebElement verifiedVendorOptions;

	@FindBy(xpath = "(//div[contains(@class,'MuiGrid-root MuiGrid-item')])[3]/div[3]/div[2]")
	public WebElement memberSinceDetails;

	@FindBy(xpath = "(//div[contains(@class,'MuiGrid-root MuiGrid-item')])[3]/div[3]/div[1]")
	public WebElement fromCountry;

	// Elements are appear at the right position
	public void verifyElementAtRightCorner(WebElement element) {
		// Get the window width
		int windowWidth = driver.manage().window().getSize().width;

		// Get the element's X position
		int elementX = element.getRect().getX();

		// Calculate the right side of the page
		int rightSide = windowWidth - elementX;

		// Assert that the element is at the right side of the page
		if (element == socialOptions) {
			softAssert.assertEquals(true, elementX >= rightSide, "social options is not at the right side of the page");

		} else if (element == verifiedVendorOptions) {
			softAssert.assertEquals(true, elementX >= rightSide,
					"verified Vendor options is not appear in right corner");

		} else if (element == memberSinceDetails) {
			softAssert.assertEquals(true, elementX >= rightSide, "member since details is not appear in right corner");

		} else if (element == fromCountry) {
			softAssert.assertEquals(true, elementX >= rightSide, "from country option is not appear in right corner");
		}
	}

	// service category section
	@FindBy(xpath = "(//button[@role='tab'])[1]")
	private WebElement serviceCategory;

	public void scrollDownServiceCategoriesSection() {
		elementUtils.javascriptScrollIntoElement(serviceCategory, 10);
	}

	public void clickServiceCategoriesSection() {
		elementUtils.clickOnElement(serviceCategory, 10);
	}

	// profile category section
	@FindBy(xpath = "(//button[@role='tab'])[2]")
	private WebElement profileSection;

	public void scrollDownProfileSection() {
		elementUtils.javascriptScrollIntoElement(profileSection, 10);
	}

	public void clickProfileSection() {
		elementUtils.clickOnElement(profileSection, 10);
	}

	@FindBy(xpath = "(//div[@class='MuiTabs-root css-orq8zk']//div)//button")
	private List<WebElement> basicProfileTabs;

	public void display_ContactDetails_Resume_Experience_Section() {

		softAssert.assertEquals(true,
				basicProfileTabs.get(0).getText().equals("Contact Details")
						&& basicProfileTabs.get(1).getText().equals("Resume")
						&& basicProfileTabs.get(2).getText().equals("Experience"),
				"By default, a list of three categories like Contact Details, Resume and Experience are not visible properly");
	}

	@FindBy(xpath = "(//div[@class='MuiTabs-root css-orq8zk']//div)//button[1]")
	private WebElement contactDetails;

	public void clickOnContactDetails() {
		elementUtils.clickOnElement(contactDetails, 10);
	}

	// Contact details section
	@FindBy(xpath = "(//div[@class='MuiBox-root css-1laqemv'])[1]//a")
	private WebElement phoneNumber;

	@FindBy(xpath = "(//div[@class='MuiBox-root css-1laqemv'])[1]//p")
	private WebElement phoneHeading;

	public void displayPhoneNumber() {

		softAssert.assertEquals(true,
				phoneNumber.getText().equals("7939335218")
						&& phoneHeading.getText().equals("Phone Number Specially for Aytra marketplace"),
				"Phone number and Phone number heading are not correct");
	}

	@FindBy(xpath = "(//div[@class='MuiBox-root css-1laqemv'])[2]//a")
	private WebElement email;

	@FindBy(xpath = "(//div[@class='MuiBox-root css-1laqemv'])[2]//p")
	private WebElement emailHeading;

	public void displayEmail() {

		softAssert.assertEquals(true,
				email.getText().equals("shauom@yahoo.com")
						&& emailHeading.getText().equals("Direct email contact. Specially for Aytra marketplace"),
				"Email and email heading are not correct");
	}

	@FindBy(xpath = "(//div[@class='MuiBox-root css-1laqemv'])[3]//a")
	private WebElement website;

	@FindBy(xpath = "(//div[@class='MuiBox-root css-1laqemv'])[3]//p")
	private WebElement websiteHeading;

	public void displayWebsite() {

		softAssert.assertEquals(true,
				website.getText().equals("https://www.moneta.lk") && websiteHeading.getText().equals("Website"),
				"website and website heading are not correct");
	}
	
	@FindBy(xpath = "(//div[@class='MuiBox-root css-1laqemv'])[4]")
	private WebElement socialPagesSection;

	@FindBy(xpath = "(//div[@class='MuiBox-root css-1laqemv'])[4]//a")
	private List<WebElement> socialPages;

	@FindBy(xpath = "(//div[@class='MuiBox-root css-1laqemv'])[4]//p")
	private WebElement socialPageHeadings;

	public void displaySocialPages() {

//		softAssert.assertEquals(true,
//				socialPagesSection.
//						&& socialPageHeadings.getText().equals("Social Pages"),
//				"socialMediaOptions icon and socialPages heading are not correct");
	}

	// Resume details section
	@FindBy(xpath = "(//div[@role='tablist'])[2]//button[2]")
	private WebElement resumeSection;

	public void clickOnResume() {
		elementUtils.clickOnElement(resumeSection, 10);
	}

	public void displayResume() {
		// write code here
	}

	// Experience details section
	@FindBy(xpath = "(//div[@role='tablist'])[2]//button[3]")
	private WebElement experienceSection;

	public void clickOnExperience() {
		elementUtils.clickOnElement(experienceSection, 10);
	}

	public void displayExperience() {
		// write code here
	}

	public void expandExperience() {
		// write code here
	}

	public void descriptionOfExperience() {
		// write code here
	}

	public SoftAssert getSoftAssert() {
		return softAssert;
	}
}
