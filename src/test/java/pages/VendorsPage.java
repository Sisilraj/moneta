package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtils;

public class VendorsPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public  VendorsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath = "(//p[text()='Vendors'])[1]")
	private WebElement vendorsPageTitle;
			
	public boolean displayrVendorsPageTitle() {
		return elementUtils.visibleTextFromElement(vendorsPageTitle, 10);
	}

}
