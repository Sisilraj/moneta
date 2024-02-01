package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public  HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath = "(//img[@alt='logo'])[1]")
	private WebElement logo;
	
	public HomePage clickOnLogo() {
		elementUtils.clickOnElement(logo, 10);
		return new HomePage(driver);
	}
	
	@FindBy(xpath = "//button[text()='Services']")
	private WebElement servicesNavLink;
	
	public ServicesPage clickOnServices() {
		elementUtils.clickOnElement(servicesNavLink, 10);
		return new ServicesPage(driver);
	}
	
	@FindBy(xpath = "//button[text()='Vendors']")
	private WebElement vendorsNavLink;
	
	public VendorsPage clickOnVendors() {
		elementUtils.clickOnElement(vendorsNavLink, 10);
		return new VendorsPage(driver);
	}
	
	@FindBy(xpath = "//button[text()='Services Providers']")
	private WebElement serviceProvidersNavLink;
	
	public ServicesProvidersPage clickOnServicesProviders() {
		elementUtils.clickOnElement(serviceProvidersNavLink, 10);
		return new ServicesProvidersPage(driver);
	}
	
	@FindBy(xpath = "(//button[text()='Dashboard'])[1]")
	private WebElement dashboardNavLink;
	
	public DashboardPage clickOnDashboard() {
		elementUtils.clickOnElement(dashboardNavLink, 10);
		return new DashboardPage();
	}
	
	@FindBy(id = "combo-box-demo")
	public WebElement searchbar;
	
	public ServicePage autoSuggestionWithServicePage() {
		elementUtils.autoSuggestion(searchbar, 10);
		return new ServicePage(driver);
	}
	
	public VendorsPage autoSuggestionWithVendorsPage() {
		elementUtils.autoSuggestion(searchbar, 10);
		return new VendorsPage(driver);
	}
	
	@FindBy(xpath = "//div[@aria-label='Without label']")
	private WebElement dropdownSymbol;
	
	public void clickOnDropdownSymbol() {
		elementUtils.clickOnElement(dropdownSymbol, 10);
	}
	
	@FindBy(xpath = "//li[@data-value='Service']//span[1]")
	private WebElement serviceOption;
	
	public void selectServiceInDropdown() {
		elementUtils.clickOnElement(serviceOption, 10);
	}
	
	@FindBy(xpath = "//li[@data-value='Vendor']//span[1]")
	private WebElement vendorOption;
	
	public void selectVendorInDropdown() {
		elementUtils.clickOnElement(vendorOption, 10);
	}
	
	@FindBy(tagName = "embed")
	public WebElement youtubePlay;
	 
	public void scrollDownToYoutube() {
		elementUtils.javascriptScrollIntoElement(youtubePlay, 10);
	}

}
