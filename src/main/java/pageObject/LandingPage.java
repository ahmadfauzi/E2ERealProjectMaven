package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	public static WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[href*='sign_in']")
	private WebElement signin;
	
	@FindBy(xpath="//div[@class='text-center']/h2")
	private WebElement title;
	
	@FindBy(css="div[class*='video-banner'] h3")
	private WebElement header;
	
	private By NavBar = By.cssSelector("ul.nav.navbar-nav.navbar-right li > a");
	private By popup = By.xpath("//button[text()='NO THANKS']");

	public WebElement getLogin() {
		return signin;
	}
	
	public WebElement getTitle() {
		return title;
	}
	
	public WebElement getHeader() {
		return header;
	}
	
	public WebElement getNavBar() {
		return driver.findElement(NavBar);
	}
	
	public List<WebElement> getPopUpSize(){
		return driver.findElements(popup);
	}
	
	public WebElement getPopUp() {
		return driver.findElement(popup);
	}
}
