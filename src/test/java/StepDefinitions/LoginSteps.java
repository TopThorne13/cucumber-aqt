package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Base;
import pages.LoginPage;

public class LoginSteps extends Base {
	
	private LoginPage objLoginPage;
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() throws InterruptedException {
	    driver = new ChromeDriver();
	    driver.get("https://practicetestautomation.com/practice-test-login/");
	    driver.manage().window().maximize();
	    objLoginPage = new LoginPage(driver);
	    objLoginPage.checkLoginPage();
	}

	@When("User enters {string} as UserName and {string} as Password")
	public void user_enters_as_user_name_and_as_password(String UserName, String Password) {
	    objLoginPage.enterUserName(UserName);
		objLoginPage.enterPassword(Password);
	}

	@When("User clicked on Submit Button")
	public void user_clicked_on_submit_button() {
		objLoginPage.submitButton();
	}

	@Then("User is landed to the homepage")
	public void user_is_landed_to_the_homepage() {
		objLoginPage.checkHomepage();
	}

}
