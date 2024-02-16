package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import utility.ElementUtils;

public class VendorsPage {

	WebDriver driver;
	private ElementUtils elementUtils;
	private SoftAssert softAssert;

	public VendorsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
		softAssert = new SoftAssert();
	}

	// Vendors page title
	@FindBy(xpath = "(//p[text()='Vendors'])[1]")
	private WebElement vendorsPageTitle;

	public void displayVendorsPageTitle() {
		softAssert.assertEquals(true, elementUtils.visibleTextFromElement(vendorsPageTitle, 10),
				"The customer shouldn't see the vendors page with a list of available vendors");
	}
	
	//Search functionality
	public void searchText() {
		softAssert.assertFalse(true, "This feature still not implemented in services page");
	}
	
	//Search result functionality
	public void searchResult() {
		softAssert.assertFalse(true, "This feature still not implemented in services page");
	}

	// Filter dropdown
	@FindBy(id = "popular-button")
	private WebElement vendorsFilterButton;

	public void clickVendorsFilterButton() {
		elementUtils.clickOnElement(vendorsFilterButton, 10);
	}

	@FindBy(id = "latest")
	private WebElement vendorsLatestFilterOption;

	public void selectVendorsLatestFilterOption() {
		elementUtils.clickOnElement(vendorsLatestFilterOption, 10);
	}

	@FindBy(id = "atoz")
	private WebElement atozFilterOption;

	public void selectVendorsAtoZfilterOption() {
		elementUtils.clickOnElement(atozFilterOption, 10);
	}

	@FindBy(id = "ztoa")
	private WebElement ztoaFilterOption;

	public void selectVendorsZtoAfilterOption() {
		elementUtils.clickOnElement(ztoaFilterOption, 10);
	}

	@FindBy(xpath = "(//div[contains(@class,'MuiGrid-root MuiGrid-container')]/following-sibling::div)[1]//a")
	public List<WebElement> vendors;

	// Function to check if vendors are displayed in the latest order
	public boolean isLatestOrder(List<WebElement> vendors) {
     //	Get the list of vendors
        List<WebElement> vendorsList = getAllVendors();
        
     // Verify the order of vendors
        boolean isLatestOrder = isLatestOrder(vendorsList);
        
     // Print the result
        if (isLatestOrder) {
        	softAssert.assertTrue(true, "vendors are displayed in the latest order.");
            System.out.println("vendors are displayed in the latest order.");
        } else {
            System.out.println("vendors are not displayed in the latest order.");
        }
        
		for (int i = 0; i < vendors.size() - 1; i++) {
			// Compare the position of each vendors with the next one
			if (vendors.get(i).getLocation().getY() < vendors.get(i + 1).getLocation().getY()) {
				return false;
			}
		}
		return true;
	}

	public List<WebElement> getAllVendors() {
		return vendors;
	}

	public VendorPage clickOnVendor() {
		for (WebElement vendor : vendors) {
			elementUtils.clickOnElement(vendor, 10);
		}

		return new VendorPage(driver);
	}

	// Vendors title
	@FindBy(xpath = "(//div[@class='MuiBox-root css-1axfh76'])/p")
	private List<WebElement> vendorsTitle;

	public List<WebElement> getVendorsTitleList() {
		return vendorsTitle;
	}

	// Vendors category
	@FindBy(xpath = "//div[@role='tablist']/button[1]")
	private WebElement allVendorsCategory;

	public void clickOnAllVendors() {
		elementUtils.clickOnElement(allVendorsCategory, 10);
	}

	@FindBy(xpath = "//div[@role='tablist']/button[2]")
	private WebElement firstMainVendorsCategory;

	public void clickOnFirstMainCategory() {
		elementUtils.clickOnElement(firstMainVendorsCategory, 10);
	}

	@FindBy(xpath = "//div[@role='tablist']/button[3]")
	private WebElement secondMainVendorsCategory;

	public void clickOnSecondMainCategory() {
		elementUtils.clickOnElement(secondMainVendorsCategory, 10);
	}

	@FindBy(xpath = "//div[@role='tablist']/button[4]")
	private WebElement thirdMainVendorsCategory;

	public void clickOnThirdMainCategory() {
		elementUtils.clickOnElement(thirdMainVendorsCategory, 10);
	}

	@FindBy(xpath = "//div[@role='tablist']/button[5]")
	private WebElement forthMainVendorsCategory;

	public void clickOnForthMainCategory() {
		elementUtils.clickOnElement(forthMainVendorsCategory, 10);
	}

	@FindBy(xpath = "//div[@role='tablist']/button[6]")
	private WebElement fifthMainVendorsCategory;

	public void clickOnFifthMainCategory() {
		elementUtils.clickOnElement(fifthMainVendorsCategory, 10);
	}

	// First vendors
	@FindBy(xpath = "(//div[contains(@class,'account-box MuiBox-root')])[1]")
	private WebElement firstVendor;

	public VendorPage selectFirstVendor() {
		elementUtils.clickOnElement(firstVendor, 10);
		return new VendorPage(driver);
	}
	
	public SoftAssert getSoftAssert() {
		return softAssert;
	}
}
