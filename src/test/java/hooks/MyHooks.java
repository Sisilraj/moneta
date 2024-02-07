package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.ConfigReader;

public class MyHooks {
	
WebDriver driver;
//SoftAssert softAssert = new SoftAssert();
	
	@Before
	public void setup() {
		Properties prop = new ConfigReader().initializeProperties();
		driver = DriverFactory.initializeBrowser(prop.getProperty("browser"));
		driver.get(prop.getProperty("url"));	
	}
	
	@After
	public void teardown(Scenario scenario) {
		
		String scenarioName = scenario.getName().replaceAll(" ", "_");
		
		if(scenario.isFailed()) {
			byte[] srcScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcScreenShot, "image/png", scenarioName);
		}
		
		driver.quit();
		
		//softAssert.assertAll();
	}

}
