package pages;

import java.util.List;

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
	private WebElement allCategory;
	
	public void clickOnAllCategory() {
		elementUtils.clickOnElement(allCategory, 10);
	}
	
	@FindBy(xpath = "(//button[text()='Application Servers'])[2]")
	public WebElement appServerTag;
	
	public String displayApplicationServerText() {
		return elementUtils.getTextFromElement(appServerTag, 10);
	}
	
	@FindBy(xpath = "(//button[text()='Blockchain'])[2]")
	public WebElement blockchainTag;
	
	public String displayBlockchainText() {
		return elementUtils.getTextFromElement(blockchainTag, 10);
	}
	
	@FindBy(xpath = "(//button[text()='DevOps'])[2]")
	public WebElement devopsTag;
	
	public String displayDevOpsText() {
		return elementUtils.getTextFromElement(devopsTag, 10);
	}
	
	@FindBy(xpath = "(//button[text()='Business Applications'])[2]")
	public WebElement busAppTag;
	
	public String displayBusinessApplicationsText() {
		return elementUtils.getTextFromElement(busAppTag, 10);
	}
	
	@FindBy(xpath = "//div[contains(@class,'MuiCardActions-root MuiCardActions-spacing')]/button")
	public List<WebElement> allCategoriesInCards;
	
	@FindBy(xpath = "//button[text()='Application Servers']")
	private WebElement appServerCategory;
	
	public void clickOnAppSerCategory() {
		elementUtils.clickOnElement(appServerCategory, 10);
	}
	
	@FindBy(xpath = "//button[text()='Blockchain']")
	private WebElement blockchainCategory;
	
	public void clickOnBlockchainCategory() {
		elementUtils.clickOnElement(blockchainCategory, 10);
	}
	
	@FindBy(xpath = "(//button[text()='DevOps'])[1]")
	private WebElement devopsCategory;
	
	public void clickOnDevOpsCategory() {
		elementUtils.clickOnElement(devopsCategory, 10);
	}
	
	@FindBy(xpath = "(//button[text()='Business Applications'])[1]")
	private WebElement busAppCategory;
	
	public void clickOnBusinessApplicationsCategory() {
		elementUtils.clickOnElement(busAppCategory, 10);
	}
	
	@FindBy(xpath = "(//div[contains(@class,'MuiGrid-root MuiGrid-container')]/following-sibling::div)[1]/div")
	public List<WebElement> services;
	
	// Function to check if services are displayed in the latest order
    public boolean isLatestOrder(List<WebElement> services) {
        for (int i = 0; i < services.size() - 1; i++) {
            // Compare the position of each service with the next one
            if (services.get(i).getLocation().getY() < services.get(i + 1).getLocation().getY()) {
                return false;
            }
        }
        return true;
    }
    
    public List<WebElement> getAllServices() {
    	return services;
    }
	
	@FindBy(xpath = "(//div[contains(@class,'MuiGrid-root MuiGrid-container')]/following-sibling::div)[1]/div[1]")
	private WebElement firstServiceTag;
	
	public ServicePage clickOnFirstService() {
		elementUtils.clickOnElement(firstServiceTag, 10);
		return new ServicePage(driver);
	}
	
	@FindBy(xpath = "(//div[contains(@class,'MuiGrid-root MuiGrid-container')]/following-sibling::div)[1]/div[2]")
	private WebElement secondServiceTag;
	 
	public ServicePage clickOnSecondService() {
		elementUtils.clickOnElement(secondServiceTag, 10);
		return new ServicePage(driver);
	}
	
	@FindBy(xpath = "//div[contains(@class,'technology-box-wrap MuiBox-root')]")
	private WebElement technologyTags;
	
	public void displyAllTechnologyTags() {
		elementUtils.visibleTextFromElement(technologyTags, 10);
	}
	
	@FindBy(id = "popular-button")
	private WebElement filterDropdown;
	
	public void clickOnFilterOfServices() {
		elementUtils.clickOnElement(filterDropdown, 10);
	}
	
	@FindBy(xpath = "//li[text()='Latest']")
	private WebElement selectLatestOptions;
	
	public void selectLatestServicesFilterOptions() {
		elementUtils.clickOnElement(selectLatestOptions, 10);
	}
	
	@FindBy(xpath = "//li[text()='A-Z']")
	private WebElement select_A_Z_Options;
	
	public void select_A_Z_ServicesFilterOptions() {
		elementUtils.clickOnElement(select_A_Z_Options, 10);
	}
	
	@FindBy(xpath = "//li[text()='Z-A']")
	private WebElement select_Z_A_Options;
	
	public void select_Z_A_ServicesFilterOptions() {
		elementUtils.clickOnElement(select_Z_A_Options, 10);
	}
	
	public void selectPrice_Low_High_ServicesFilterOptions() {
		//Write logic here..
	}
	
	public void selectPrice_High_Low_ServicesFilterOptions() {
		//Write logic here..
	}
	
	@FindBy(xpath = "(//div[contains(@class,'card-heading text')]//div)")
	private List<WebElement> servicesTitle;
	
	public List<WebElement> getServicesTitleList() {
        return servicesTitle;
    }
	
	//Application first services and related functions
	@FindBy(xpath = "(//div[contains(@class,'MuiGrid-root MuiGrid-container')]/following-sibling::div)[1]/div/div")
	private WebElement appSerCategoryFirstService;
	
	public ServicePage selectAppSerCategoryFirstService() {
		elementUtils.clickOnElement(appSerCategoryFirstService, 10);
		return new ServicePage(driver);
	}
	
	//Blockchain services and related functions
	@FindBy(xpath = "(//div[contains(@class,'MuiGrid-root MuiGrid-container')]/following-sibling::div)[1]/div/div")
	private WebElement blockchainCategoryFirstService;
			
	public ServicePage selectBlockchainCategoryFirstService() {
		elementUtils.clickOnElement(blockchainCategoryFirstService, 10);
		return new ServicePage(driver);
	}
	
	//DevOps services and related functions
	@FindBy(xpath = "(//div[contains(@class,'MuiGrid-root MuiGrid-container')]/following-sibling::div)[1]/div/div")
	private WebElement devOpsCategoryFirstService;
				
	public ServicePage selectDevOpsCategoryFirstService() {
		elementUtils.clickOnElement(devOpsCategoryFirstService, 10);
		return new ServicePage(driver);
	}
	
	//Business applications services and related functions
	@FindBy(xpath = "(//div[contains(@class,'MuiGrid-root MuiGrid-container')]/following-sibling::div)[1]/div/div")
	private WebElement busAppCategoryFirstService;
					
	public ServicePage selectBusAppCategoryFirstService() {
		elementUtils.clickOnElement(busAppCategoryFirstService, 10);
		return new ServicePage(driver);
	}
}
