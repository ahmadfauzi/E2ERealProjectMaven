package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHomePage {
	public WebDriver driver;
	
	By searchbox = By.id("search-courses");
	
	public PortalHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSearchBox() {
		return driver.findElement(searchbox);
	}
}
