package appiumTest.TestCase;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.ScrollAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import com.microsoft.appcenter.appium.Factory;

import appiumTest.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class signup extends TestBase {
	
	@Rule
    public TestWatcher watcher = Factory.createWatcher();
	
	@Test
	public void signupTest () throws IOException, InterruptedException  {
		
		EnhancedAndroidDriver<MobileElement> driver = Capabilities();
		log.info("App opened");
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("letsGetStarted_XPATH"))).click();
		
		log.info("Lets Get Started clicked");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("firstname33_XPATH"))).sendKeys(OR.getProperty("firstname_TEXT"));
		
		log.info("user firstname passed into text box");	
		
		driver.findElement(By.xpath(OR.getProperty("lastname2_XPATH"))).sendKeys(OR.getProperty("lastname_TEXT"));
		log.info("user lastname passed into text box");
		
		driver.findElement(By.xpath(OR.getProperty("signUpEmail_XPATH"))).sendKeys(OR.getProperty("signUpEmail_TEXT"));
		log.info("user email passed into text box");	
		
		driver.findElement(By.xpath(OR.getProperty("signUpPassword_XPATH"))).sendKeys(OR.getProperty("signUpPassword_TEXT"));
		log.info("user password passed into text box");
		
		//driver.swipe(688, 1260, 688, 1124, 1467);

		driver.findElement(By.xpath(OR.getProperty("confirmPassword_XPATH"))).sendKeys(OR.getProperty("confirmPassword_TEXT"));
		log.info("user confirm password passed into text box");	
		
		driver.findElement(By.xpath(OR.getProperty("checkbox2_XPATH"))).click();
		log.info("Checkbox clicked");
		
		driver.findElement(By.xpath(OR.getProperty("next2_XPATH"))).click();
		log.info("Next button clicked");
	
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("skipPhoneNumber_XPATH"))).click();
		log.info("Phone verification Skipped button clicked");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("skip_XPATH"))).click();
		log.info("Skip clicked");
		log.info("Sign up successful successful");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("menuBtn_XPATH"))).click();
		log.info("Menu button clicked");
		
		driver.findElement(By.xpath(OR.getProperty("settingsBtn_XPATH"))).click();
		log.info("Settings button clicked");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("accountTab_XPATH"))).click();
		log.info("Account Tab button clicked");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("deactivateAccount_XPATH"))).click();
		log.info("Deactivate button clicked");
		
		driver.findElement(By.xpath(OR.getProperty("confirmBtn_XPATH"))).click();
		log.info("Confirm button clicked");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String actualString = driver.findElement(By.xpath(OR.getProperty("letsGetStarted2_XPATH"))).getText();
	    assertTrue(actualString.contains(OR.getProperty("letsGetStartedText")));
	    log.info("Account successfully deactivated");

	}

}
