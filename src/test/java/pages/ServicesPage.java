package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtils;

public class ServicesPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public  ServicesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath = "(//p[text()='Services'])[1]")
	private WebElement servicePageTitle;
	
	public boolean displayServicePageTitle() {
		return elementUtils.visibleTextFromElement(servicePageTitle, 10);
	}
	
	@FindBy(xpath = "//button[text()='All']")
	private WebElement allTag;
	
	public void clickOnAllTag() {
		elementUtils.clickOnElement(allTag, 10);
	}
	
	@FindBy(xpath = "//button[text()='Application Servers']")
	private WebElement appServerTag;
	
	public void clickOnAppSerTag() {
		elementUtils.clickOnElement(appServerTag, 10);
	}
	
	@FindBy(xpath = "//button[text()='Blockchain']")
	private WebElement blockchainTag;
	
	public void clickOnBlockchainTag() {
		elementUtils.clickOnElement(blockchainTag, 10);
	}
	
	@FindBy(xpath = "(//button[text()='DevOps'])[1]")
	private WebElement devopsTag;
	
	public void clickOnDevOpsTag() {
		elementUtils.clickOnElement(devopsTag, 10);
	}
	
	@FindBy(xpath = "(//button[text()='Business Applications'])[1]")
	private WebElement busAppTag;
	
	public void clickOnBusinessApplicationsTag() {
		elementUtils.clickOnElement(busAppTag, 10);
	}
	
	@FindBy(xpath = "(//div[contains(@class,'MuiGrid-root MuiGrid-container')]/following-sibling::div)[1]/div[1]")
	private WebElement firstServiceTag;
	
	public void clickOnFirstService() {
		elementUtils.clickOnElement(firstServiceTag, 10);
	}
	
	@FindBy(xpath = "(//div[contains(@class,'MuiGrid-root MuiGrid-container')]/following-sibling::div)[1]/div[2]")
	private WebElement secondServiceTag;
	 
	public void clickOnSecondService() {
		elementUtils.clickOnElement(secondServiceTag, 10);
	}
	
	@FindBy(xpath = "//p[text()='ECB Supply']")
	private WebElement ecbSupplyTitle;
	
	public boolean displyEcbSupplyTitle() {
		return elementUtils.visibleTextFromElement(ecbSupplyTitle, 10);
	}
	
	@FindBy(xpath = "//div[contains(@class,'technology-box-wrap MuiBox-root')]")
	private WebElement technologyTags;
	
	public void displyAllTechnologyTags() {
		elementUtils.visibleTextFromElement(technologyTags, 10);
	}
	
}
