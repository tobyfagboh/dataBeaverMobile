package appiumTest.TestCase;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.Keys;
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

public class virtualAssistance extends TestBase {
	
	@Rule
    public TestWatcher watcher = Factory.createWatcher();

	@Test
	public void VirtualAssistance() throws IOException, InterruptedException {

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

		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("loginSkip3_XPATH"))).click();
		log.info("Login is successful");
		
		driver.findElement(By.xpath(OR.getProperty("virtualAss_XPATH"))).click();
		log.info("Virtual Assistance Clicked");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String actualString = driver.findElement(By.xpath(OR.getProperty("helpText_XPATH"))).getText();
		assertTrue(actualString.contains(OR.getProperty("helpText_TEXT")));
		log.info("Successfully laaunched Virtual Assistancel");
		
		driver.findElement(By.xpath(OR.getProperty("vaTextField_XPATH"))).sendKeys(OR.getProperty("vaEnterText"));
		log.info("Enter text successful");
		
		driver.findElement(By.xpath(OR.getProperty("sendkeys_XPATH"))).click();
		log.info("Send key clicked");
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("yesBtn_XPATH"))).click();
		log.info("Yes button clicked");
		
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("yes2Btn_XPATH"))).click();
		log.info("Yes button clicked again");
		
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath(OR.getProperty("labData_XPATH"))).click();
		log.info("Lab Data clicked");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String actualString2 = driver.findElement(By.xpath(OR.getProperty("labReport_XPATH"))).getText();
		assertTrue(actualString2.contains(OR.getProperty("labReport_TEXT")));
	}

}
