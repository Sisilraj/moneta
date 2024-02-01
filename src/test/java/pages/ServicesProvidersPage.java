package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtils;

public class ServicesProvidersPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public  ServicesProvidersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//p[text()='Providers']")
	private WebElement serviceProviderPageTitle;
	
	public boolean displayServiceProviderPageTitle() {
		return elementUtils.visibleTextFromElement(serviceProviderPageTitle, 10);
	}

}
