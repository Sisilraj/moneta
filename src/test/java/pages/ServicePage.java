package pages;

import java.util.List;

import org.openqa.selenium.Dimension;
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
	@FindBy(xpath = "(//div[contains(@class,'technology-box-wrap-inner MuiBox-root')])")
	private List<WebElement> techTags;
	
	@FindBy(xpath = "//p[text()='Technology Tags']")
	private WebElement techTagsTitle;
	
	public void scrollDownIntoTechTags() {
		elementUtils.javascriptScrollIntoElement(techTagsTitle, 10);
	}
	
	public List<WebElement> getTechTags() {
		return techTags;
	}
	
	//Top service name title
	@FindBy(xpath = "(//div[@class='MuiBox-root css-wg3sr9']//p)[1]")
	private WebElement topPageServiceTitle;
	
	public boolean verifyTopOfServiceTitle() {
		return elementUtils.visibleTextFromElement(topPageServiceTitle, 10);
	}
	
	//Service image 
	@FindBy(xpath = "(//div[contains(@class,'slide-img MuiBox-root')])[1]/img")
	private WebElement serviceImage;
	
	public int getWidth() {
		Dimension imageSize = serviceImage.getSize();
		int imageWidth = imageSize.width;
		return imageWidth;
	}
	
	public int getHeight() {
		Dimension imageSize = serviceImage.getSize();
		int imageHeight = imageSize.height;
		return imageHeight;
	}
	
	//Service tagline
	@FindBy(xpath = "(//div[@class='MuiBox-root css-0'])[1]")
	private WebElement serviceTagline;
	
	public boolean displayServiceTagline() {
		return elementUtils.visibleTextFromElement(serviceTagline, 10);
	}
	
	//service description
	@FindBy(xpath = "(//div[@class='MuiBox-root css-0'])[2]")
	private WebElement serviceDescription;
	
	public boolean displayServiceDescription() {
		return elementUtils.visibleTextFromElement(serviceDescription, 10);
	}
}
