package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtils;

public class ServicePage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public  ServicePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath = "//p[text()='Robert Cooke temporal']")
	private WebElement robertCookeServiceTitle;
	
	public String displayRobertCookeServiceTitle() {
		return elementUtils.getTextFromElement(robertCookeServiceTitle, 10);
	}

}
