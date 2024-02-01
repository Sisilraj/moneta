package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtils;

public class VendorPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public  VendorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//p[text()='Super Vendors']")
	private WebElement superVendorsTitle;
	
	public String displaySuperVendorsTitle() {
		return elementUtils.getTextFromElement(superVendorsTitle, 10);
	}

}
