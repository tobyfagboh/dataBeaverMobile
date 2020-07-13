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

public class connection extends TestBase{
	
	@Rule
    public TestWatcher watcher = Factory.createWatcher();
	
	@Test
	public void payerConnection () throws InterruptedException, IOException {
		
		EnhancedAndroidDriver<MobileElement> driver = Capabilities();
		log.info("App opened");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("login_XPATH"))).click();
		log.info("I already have an account clicked");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("email_XPATH"))).sendKeys(OR.getProperty("email_TEXT"));
		log.info("user email passed into text box");

		driver.findElement(By.xpath(OR.getProperty("password_XPATH"))).sendKeys(OR.getProperty("password_TEXT"));
		log.info("user password passed into text box");

		driver.findElement(By.xpath(OR.getProperty("loginBtn2_XPATH"))).click();
		log.info("log in button clicked");

		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("loginSkip3_XPATH"))).click();
		log.info("Login is successful");
		
		driver.findElement(By.xpath(OR.getProperty("eu_connection_XPATH"))).click();
		log.info("Make Connection button clicked");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("eu_payersConnection_XPATH"))).click();
		log.info("Payer Button clicked");
		
		driver.findElement(By.xpath(OR.getProperty("eu_addconnection_XPATH"))).click();
		log.info("Add Payer Button clicked");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("eu_edifecsConnect_XPATH"))).click();
		log.info("Edifecs Payer clicked");
		
		driver.findElement(By.xpath(OR.getProperty("eu_Connect_XPATH"))).click();
		log.info("Connect button clicked");
		
		driver.findElement(By.xpath(OR.getProperty("eu_confirmConnect_XPATH"))).click();
		log.info("Confirm  Connect button clicked");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("eu_selectChrome_XPATH "))).click();
		log.info("Chrome browser clicked");
		
	}

}
