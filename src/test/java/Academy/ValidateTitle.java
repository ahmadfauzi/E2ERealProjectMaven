package Academy;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	
	public static Logger Log = LogManager.getLogger(Base.class.getName());
	LandingPage lp;
	
	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();
		Log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		Log.info("Navigated to Home Page");
	}
	
	@Test
	public void validateTitle() {
		lp = new LandingPage(driver);
		AssertJUnit.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		Log.info("Successfully validated title");
	}
	
	@Test
	public void validateHeader() {
		AssertJUnit.assertEquals(lp.getHeader().getText(), "An Academy to learn Everything about Testing");
		Log.info("Successfully validated header");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}
}
