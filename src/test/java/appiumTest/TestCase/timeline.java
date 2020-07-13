package appiumTest.TestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import com.microsoft.appcenter.appium.Factory;

import appiumTest.base.TestBase;
import io.appium.java_client.MobileElement;

public class timeline extends TestBase {
	
	@Rule
    public TestWatcher watcher = Factory.createWatcher();
	
	@Test
	public void TimelineTest() throws IOException, InterruptedException {

		EnhancedAndroidDriver<MobileElement> driver = Capabilities();
		log.info("App opened");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("login_XPATH"))).click();
		log.info("I already have an account clicked");

		Thread.sleep(4000);
		driver.findElement(By.xpath(OR.getProperty("email_XPATH"))).sendKeys(OR.getProperty("email_TEXT"));
		log.info("user email passed into text box");

		driver.findElement(By.xpath(OR.getProperty("password_XPATH"))).sendKeys(OR.getProperty("password_TEXT"));
		log.info("user password passed into text box");

		driver.findElement(By.xpath(OR.getProperty("loginBtn2_XPATH"))).click();
		log.info("log in button clicked");

		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("loginSkip3_XPATH"))).click();

		log.info("Login is successful");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//driver.findElement(By.xpath(OR.getProperty("skip_XPATH"))).click();
		//log.info("Skip clicked");
		
		driver.findElement(By.xpath(OR.getProperty("timeline_XPATH"))).click();
		log.info("Timeline clicked");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("skipTimeline_XPATH"))).click();
		log.info("Skip button clicked");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("healthHistory_XPATH"))).click();
		log.info("Health history clicked");
		
		driver.findElement(By.xpath(OR.getProperty("skipTimeline_XPATH"))).click();
		log.info("Skip button clicked");
		
		driver.findElement(By.xpath(OR.getProperty("claimsDropDown_XPATH"))).click();
		log.info("Claims drop down button clicked");
		
		driver.findElement(By.xpath(OR.getProperty("viewClaims_XPATH"))).click();
		log.info("View Claims is clicked");
		
		driver.findElement(By.xpath(OR.getProperty("margaret_XPATH"))).isDisplayed();
		log.info("Magret is Displayed");
		
		
	}
	
}
