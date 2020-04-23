package Academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class HomePage extends Base{

	public static Logger Log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException{
		driver = initializeDriver();	
		Log.info("Driver is initialized");
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password, String type) {
		driver.get(prop.getProperty("url"));
		Log.info("Navigated to Home Page");
		
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		Log.info("Navigated to Login Page");
		
		LoginPage ln = new LoginPage(driver);
		ln.getEmail().sendKeys(username);
		ln.getPassword().sendKeys(password);
		Log.info(type);
		ln.getLogin().click();
		Log.info("Login using email and password");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		
		data[0][0] = "non.restricted@user.com";
		data[0][1] = "zxc456";
		data[0][2] = "Non Restricted User";
		
		data[1][0] = "restricted@user.com";
		data[1][1] = "qwe123";
		data[1][2] = "Restricted User";
	
		return data;
	}
}
