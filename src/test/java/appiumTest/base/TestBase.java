package appiumTest.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import com.microsoft.appcenter.appium.Factory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {
	public static WebDriverWait wait;
	private static EnhancedAndroidDriver<MobileElement> driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();

	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");

	// public static String loadPropertyFile = "OR.properties";

	@BeforeClass
	public static EnhancedAndroidDriver<MobileElement> Capabilities() throws IOException, InterruptedException {

		/*
		 * Runtime.getRuntime().
		 * exec("cmd /c start C:\\SummitechTest\\appiumTest\\startappium.bat");
		 * Thread.sleep(7000);
		 */

		File appDir = new File("src");
		File app = new File(appDir, "/test/resources/executables/app-release.apk");

		DesiredCapabilities cap = new DesiredCapabilities();
		log.debug("BASE URL"+ System.getProperty("user.dir"));
		PropertyConfigurator
		.configure("log4j.properties");
		//System.out.println(System.getProperty("user.dir") + "/src/test/resources/properties/log4j.properties");

		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 2913);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.mycareai");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.mycareai.MainActivity");

		URL url = new URL("http://localhost:4723/wd/hub");
		// driver = Factory.createAndroidDriver(url, cap);

		return Factory.createAndroidDriver(url, cap);

	}

	@BeforeClass

	public void setUp() {

		if (driver == null) {

			try {
				fis = new FileInputStream("Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded !!!");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				fis = new FileInputStream("OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded !!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void click(String Locator) {
		if (Locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(Locator))).click();
		} else if (Locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(Locator))).click();
		} else if (Locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(Locator))).click();
		} else if (Locator.endsWith("_CLASSNAME")) {
			driver.findElement(By.className(OR.getProperty(Locator))).click();
		} else if (Locator.endsWith("_LINKTEXT")) {
			driver.findElement(By.linkText(OR.getProperty(Locator))).click();
		}

		// test.log(LogStatus.INFO, "Clicking on : "+Locator);
	}

	public void type(String Locator, String value) {
		if (Locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(Locator))).sendKeys(value);
		} else if (Locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(Locator))).sendKeys(value);
		} else if (Locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(Locator))).sendKeys(value);
		} else if (Locator.endsWith("_CLASSNAME")) {
			driver.findElement(By.className(OR.getProperty(Locator))).sendKeys(value);
		} else if (Locator.endsWith("_LINKTEXT")) {
			driver.findElement(By.linkText(OR.getProperty(Locator))).sendKeys(value);
		}
	}

	public boolean isElementPresent(By by) {

		try {

			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;

		}

	}

	@SuppressWarnings("unused")
	public void log4j_demo() {
		Logger log = Logger.getLogger("log4j_demo");
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/properties/log4j.properties");

	}

	@AfterClass
	public void TearDown() {

		if (driver != null) {
			driver.label("Stopping App");
			driver.quit();
		}
	}

}
