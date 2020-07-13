package appiumTest.rough;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class log4j_demo {
	
	public static void main (String[] args) {
		
		Logger logger = Logger.getLogger("log4j_demo");
		PropertyConfigurator.configure("/Users/netowsolutions/Documents/Parallelscore/Mobile-Automation/mc-appium/src/test/resources/properties/log4j.properties");
		logger.debug("This is debug");
		logger.info("This is info");
		logger.warn("This is warn");
		logger.error("This is error");
		logger.fatal("This is fatal");
		
	}

}
