package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends Base{
	
	private WebDriver driver;
	
	LoginPage page;
	
	public LoginPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//h2[text()= \"Test login\"]")
	WebElement CheckLoginPage;
	
	@FindBy(id="username")
	WebElement textUserName;
	
	@FindBy(id="password")
	WebElement textPassword;
	
	@FindBy(id="")
	WebElement submit;
	
	public void checkLoginPage() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(CheckLoginPage));
		Assert.assertEquals("https://practicetestautomation.com/practice-test-login/", driver.getCurrentUrl());
	}
	
	public void enterUserName(String username) {
		
		textUserName.sendKeys(username);
		
	}
	
	public void enterPassword(String password) {
		
		textPassword.sendKeys(password);
		
	}
	
	public void checkHomepage() {
		
		Assert.assertEquals("https://practicetestautomation.com/logged-in-successfully/", driver.getCurrentUrl());
		driver.close();
		
	}
	
	public void submitButton() {
		
		submit.click();
		
	}

}
