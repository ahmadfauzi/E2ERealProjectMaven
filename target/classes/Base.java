package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/data.properties");
		
		prop.load(fis);
//		String browserName = prop.getProperty("browser"); //get browser from data.properties
		String browserName = System.getProperty("browser"); //get browser from command line ==> mvn test -D browser=chrome
		System.out.println(browserName);
				
		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/resources/chromedriver");
			if(browserName.contains("headless")) {
				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--no-sandbox");
//				options.addArguments("--disable-gpu");
//				options.addArguments("--disable-extensions");
//				options.addArguments("--start-maximized");
				options.addArguments("--headless"); //should be enabled for Jenkins
//				options.addArguments("--disable-dev-shm-usage"); //should be enabled for Jenkins
//				options.addArguments("--window-size=1920,1080");
				driver = new ChromeDriver(options);
			} else {
				driver = new ChromeDriver();
			}
			
		} else if(browserName.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/resources/geckodriver");
			driver = new FirefoxDriver();	
		}
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/home/fauziprofio/Pictures/" + result+ "_screenshot.png"));
	}
}
