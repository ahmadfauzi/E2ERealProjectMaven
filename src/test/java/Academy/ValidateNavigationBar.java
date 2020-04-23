package Academy;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.Base;

//1. Adding logs
//2. Generating html reports
//3. Screenshots on failure
//4. Jenkins integration

public class ValidateNavigationBar extends Base {

	public static Logger Log = LogManager.getLogger(Base.class.getName());	
	
	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();	
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void basePageNavigation(){
		LandingPage lp = new LandingPage(driver);
		AssertJUnit.assertTrue(lp.getNavBar().isDisplayed());
		Log.info("Navigation Bar is Displayed");
		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}
}
