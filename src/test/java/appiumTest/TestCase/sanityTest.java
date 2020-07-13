package appiumTest.TestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.microsoft.appcenter.appium.EnhancedAndroidDriver;

import appiumTest.base.TestBase;
import io.appium.java_client.MobileElement;

public class sanityTest extends TestBase {
	
	@Test(priority=1)
	public void InvalidLoginTest() throws IOException, InterruptedException {

		EnhancedAndroidDriver<MobileElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		log.info("App opened");
		
		driver.findElement(By.xpath(OR.getProperty("login_XPATH"))).click();
		log.info("I already have an account clicked");
		
		Thread.sleep(4000);
		driver.findElement(By.xpath(OR.getProperty("email_XPATH"))).sendKeys(OR.getProperty("email_TEXT"));
		log.info("user email passed into text box");	
		
		driver.findElement(By.xpath(OR.getProperty("password_XPATH"))).sendKeys(OR.getProperty("password2_TEXT"));
		log.info("user password passed into text box");
		
		driver.findElement(By.xpath(OR.getProperty("loginBtn2_XPATH"))).click();
		log.info("log in button clicked");
		
		log.info("Login not successful");

	}
	
	@Test(priority=2)
	public void loginR() throws IOException, InterruptedException {

		EnhancedAndroidDriver<MobileElement> driver = Capabilities();
		log.info("App opened");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
	}

	
	@Test(priority=2)
	public void Dashboard() throws IOException, InterruptedException {

		EnhancedAndroidDriver<MobileElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		log.info("App opened");
		
		//Thread.sleep(10000);
		driver.findElement(By.xpath(OR.getProperty("login_XPATH"))).click();
		log.info("I already have an account clicked");
		
		Thread.sleep(4000);
		driver.findElement(By.xpath(OR.getProperty("email_XPATH"))).sendKeys(OR.getProperty("email_TEXT"));
		log.info("user email passed into text box");
		
		
		driver.findElement(By.xpath(OR.getProperty("password_XPATH"))).sendKeys(OR.getProperty("password_TEXT"));
		log.info("user password passed into text box");
		
		driver.findElement(By.xpath(OR.getProperty("loginBtn2_XPATH"))).click();
		log.info("log in button clicked");
		
		Thread.sleep(3000);
//		String actualString = driver.findElement(By.xpath(OR.getProperty("skip_XPATH"))).getText();
//		assertTrue(actualString.contains("Skip"));
			
		log.info("Login is successful");

	}

}
