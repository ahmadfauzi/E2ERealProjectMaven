package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import junit.framework.Assert;
import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.PortalHomePage;
import resources.Base;

import java.util.List;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Cucumber.class)
public class stepDefinition extends Base{

    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
		driver = initializeDriver();
    }
    
    @Given("^Navigate to \"([^\"]*)\" Site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
    	driver.get(strArg1);
    }
    
    @Given("^Click on login link in home page to land on secure sign in page$")
    public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
    	System.out.println("landing_begin");
    	LandingPage lp = new LandingPage(driver);
    	if(lp.getPopUpSize().size()>0) {
    		lp.getPopUp().click();
    		System.out.println("Popup clicked");
    	}
		lp.getLogin().click();
		System.out.println("landing_last");
    }
    
    @When("^Users enters (.+) and (.+) and login$")
    public void users_enters_and_and_login(String username, String password) throws Throwable {
    	LoginPage ln = new LoginPage(driver);
		System.out.println("login_begin");
		ln.getEmail().sendKeys(username);
		ln.getPassword().sendKeys(password);
		ln.getLogin().click();
		System.out.println("login_last");
    }

    @Then("^Verify that user is successfully logged in$")
    public void verify_that_user_is_successfully_logged_in() throws Throwable {
    	PortalHomePage ph = new PortalHomePage(driver);
    	Assert.assertTrue(ph.getSearchBox().isDisplayed());
    }
    
    @And("^Close browser$")
    public void close_browser() throws Throwable {
        driver.close();
    }

    

    

}