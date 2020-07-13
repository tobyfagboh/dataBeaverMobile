package appiumTest.TestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import com.microsoft.appcenter.appium.Factory;

import appiumTest.base.TestBase;
import io.appium.java_client.MobileElement;

public class share extends TestBase {
	
	@Rule
    public TestWatcher watcher = Factory.createWatcher();

	@Test
	public void shareConnection () throws InterruptedException, IOException {
		
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
		
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("shareBtn_XPATH"))).click();
		log.info("Share button clicked");
		
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("addContact_XPATH"))).click();
		log.info("Add to contact button clicked");
		
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("yesUnderstandBtn_XPATH"))).click();
		log.info("Yes, I understand button clicked");
	}

}
