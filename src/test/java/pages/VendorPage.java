package pages;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	//Logo, company name, tagline, and description
	@FindBy(xpath = "//div[@class='profile-details-img']//img[1]")
	private WebElement vendorCompanyLogo;

	public boolean displayVendorCompanyLogo() {
		return elementUtils.visibleTextFromElement(vendorCompanyLogo, 10);
	}
	
	@FindBy(xpath = "//div[@class='profile-details-text']//div[1]//p[1]")
	public WebElement vendorCompanyName;
	
	@FindBy(xpath = "//div[@class='profile-details-text']//div[1]//p[2]")
	public WebElement vendorCompanyTagline;
	
	//Vendor image 
	@FindBy(xpath = "(//div[contains(@class,'profile-details MuiBox-root')]//div)[1]//img")
	private WebElement vendorImage;
		
	public int getWidth() {
		Dimension imageSize = vendorImage.getSize();
		int imageWidth = imageSize.width;
		return imageWidth;
	}
		
	public int getHeight() {
		Dimension imageSize = vendorImage.getSize();
		int imageHeight = imageSize.height;
		return imageHeight;
	}
	
	//social handles, contact options, country, and member since details
	@FindBy(xpath = "(//div[contains(@class,'MuiGrid-root MuiGrid-item')])[3]/div//a")
	public WebElement socialOptions;
	
	public boolean displaySocialOptions() {
		return elementUtils.visibleTextFromElement(socialOptions, 10);
	}
	
	@FindBy(xpath = "(//div[contains(@class,'MuiGrid-root MuiGrid-item')])[3]/div[2]/div[2]")
	public WebElement verifiedVendorOptions;
	
	public boolean displayVerifiedVendorOptions() {
		return elementUtils.visibleTextFromElement(verifiedVendorOptions, 10);
	}
	
	@FindBy(xpath = "(//div[contains(@class,'MuiGrid-root MuiGrid-item')])[3]/div[3]/div[2]")
	public WebElement memberSinceDetails;
	
	public boolean displayMemberSinceDetailsOptions() {
		return elementUtils.visibleTextFromElement(memberSinceDetails, 10);
	}
	
	@FindBy(xpath = "(//div[contains(@class,'MuiGrid-root MuiGrid-item')])[3]/div[3]/div[1]")
	public WebElement fromCountry;
	
	public boolean displayFromCountryOptions() {
		return elementUtils.visibleTextFromElement(fromCountry, 10);
	}
	
	//Elements are appear at the right position
	public boolean verifyElementAtRightCorner(WebElement element) {
        // Get the window width and height
        int windowWidth = element.getSize().getWidth();
        int windowHeight = element.getSize().getHeight();

        // Calculate the position of the right corner
        int xOffset = windowWidth - element.getSize().getWidth();
        int yOffset = windowHeight - element.getSize().getHeight();

        // Use Actions class to move the element to the right corner
        Actions actions = new Actions(driver);
        actions.moveToElement(element, xOffset, yOffset).build().perform();

        // Verify the element's position
        int actualX = element.getLocation().getX();
        int actualY = element.getLocation().getY();

        if (actualX == xOffset && actualY == yOffset) {
            System.out.println("Element is at the right corner.");
        } else {
            System.out.println("Element is not at the right corner.");
        }
		return false;
	}    
	
	//service category section
	@FindBy(xpath = "(//button[@role='tab'])[1]")
	private WebElement serviceCategory;
	
	public void scrollDownServiceCategoriesSection() {
		elementUtils.javascriptScrollIntoElement(serviceCategory, 10);
	}
	
	public void clickServiceCategoriesSection() {
		elementUtils.clickOnElement(serviceCategory, 10);
	}
	
	//profile category section
	@FindBy(xpath = "(//button[@role='tab'])[2]")
	private WebElement profileSection;
	
	public void scrollDownProfileSection() {
		elementUtils.javascriptScrollIntoElement(profileSection, 10);
	}
	
	public void clickProfileSection() {
		elementUtils.clickOnElement(profileSection, 10);
	}
	
	@FindBy(xpath = "(//div[@class='MuiTabs-root css-orq8zk']//div)//button")
	public List <WebElement> basicProfileTabs;
	
	@FindBy(xpath = "(//div[@class='MuiTabs-root css-orq8zk']//div)//button[1]")
	private WebElement contactDetails;
	
	public void clickOnContactDetails() {
		elementUtils.clickOnElement(contactDetails, 10);
	}
	
	//Contact details section
	@FindBy(xpath = "(//div[@class='MuiBox-root css-1laqemv'])[1]//a")
	private WebElement phoneNumber;
	
	@FindBy(xpath = "(//div[@class='MuiBox-root css-1laqemv'])[1]//p")
	private WebElement phoneHeading;
	
	public boolean displayPhoneNumber() {
		if(phoneNumber.getText() == "7939335218" && phoneHeading.getText() == "Phone Number") {
			System.out.println("Phone number and Phone number heading are correct");
		}else {
			System.out.println("Phone number and Phone number heading are not correct");
		}
		return false;
	}
	
	@FindBy(xpath = "(//div[@class='MuiBox-root css-1laqemv'])[2]//a")
	private WebElement email;
	
	@FindBy(xpath = "(//div[@class='MuiBox-root css-1laqemv'])[2]//p")
	private WebElement emailHeading;
	
	public boolean displayEmail() {
		if(email.getText() == "shauom@yahoo.com" && email.getText() == "Direct email contact.") {
			System.out.println("Email and email heading are correct");
		}else {
			System.out.println("Email and email heading are not correct");
		}
		return false;
	}
	
	@FindBy(xpath = "(//div[@class='MuiBox-root css-1laqemv'])[3]//a")
	private WebElement website;
	
	@FindBy(xpath = "(//div[@class='MuiBox-root css-1laqemv'])[3]//p")
	private WebElement websiteHeading;
	
	public boolean displayWebsite() {
		if(website.getText() == "https://www.moneta.lk" && websiteHeading.getText() == "Website") {
			System.out.println("website and website heading are correct");
		}else {
			System.out.println("website and website heading are not correct");
		}
		return false;
	}
	
	@FindBy(xpath = "(//div[@class='MuiBox-root css-1laqemv'])[4]//a")
	private List <WebElement> socialPages;
	
	@FindBy(xpath = "(//div[@class='MuiBox-root css-1laqemv'])[4]//p")
	private WebElement socialPageHeadings;
	
	public boolean displaySocialPages() {
		List<WebElement> socialMediaOptions = socialPages;
		
		for(WebElement socialMediaOption : socialMediaOptions) {
			if(socialMediaOption.isDisplayed() && socialPageHeadings.getText() == "Social Pages") {
				System.out.println("socialMediaOptions icon and socialPages heading are correct");
			}else {
				System.out.println("socialMediaOptions icon and socialPages heading are not correct");
			}
		}
		return false;
	}
	
	//Resume details section
	@FindBy(xpath = "(//div[@role='tablist'])[2]//button[2]")
	private WebElement resumeSection;
	
	public void clickOnResume() {
		elementUtils.clickOnElement(resumeSection, 10);
	}
	
	//Experience details section
	@FindBy(xpath = "(//div[@role='tablist'])[2]//button[3]")
	private WebElement experienceSection;
	
	public void clickOnExperience() {
		elementUtils.clickOnElement(experienceSection, 10);
	}
}
