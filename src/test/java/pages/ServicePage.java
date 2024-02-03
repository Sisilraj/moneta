package pages;

import java.util.List;

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
	
	@FindBy(xpath = "//p[text()='ECB Supply']")
	private WebElement ecbSupplyTitle;
	
	public boolean displyEcbSupplyTitle() {
		return elementUtils.visibleTextFromElement(ecbSupplyTitle, 10);
	}	
	
	//Technology Tags and related functions
	@FindBy(xpath = "//div[contains(@class,'technology-box-wrap MuiBox-root')]")
	private List<WebElement> techTags;
	
	@FindBy(xpath = "//p[text()='Technology Tags']")
	private WebElement techTagsTitle;
	
	public void scrollDownIntoTechTags() {
		elementUtils.javascriptScrollIntoElement(techTagsTitle, 10);
	}
	
	public List<WebElement> getTechTags() {
		return techTags;
	}
}
