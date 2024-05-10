package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends Base{
	
	private WebDriver driver;
	
	UtilClass objUtil = new UtilClass();
	
	@FindBy(id="nav-logo-sprites")
	WebElement logo;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(id="nav-cart")
	WebElement cart;
	
	@FindBy(id="nav-global-location-popover-link")
	WebElement pinSelect;
	
	@FindBy(id="GLUXZipUpdateInput")
	WebElement pinBox;
	
	@FindBy(id="GLUXZipError")
	WebElement wrongZipMessage;
	
	@FindBy(id="a-popover-1")
	WebElement pinBoxVisible;
	
	@FindBy(id="nav-hamburger-menu")
	WebElement allOptionsMenu;
	
	@FindBy(xpath="//*[@id=\"hmenu-content\"]//li[30]")
	WebElement customerService;
	
	public HomePage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}

	public void checkLoginPage() {
		
		objUtil.waitExplicit(driver, logo);
		
		Assert.assertTrue(logo.isDisplayed());
		
	}
	
	public void search(String product) {
		
		searchBox.sendKeys(product);
		
		searchBox.sendKeys(Keys.ENTER);
		
	}
	
	public void cartClick() {
		
		cart.click();
		
	}

	public void selectPin() {

		pinSelect.click();
		
	}

	public void changePin(Integer PinCode) throws IOException {
		
		objUtil.waitExplicit(driver, pinBoxVisible);
		
		objUtil.waitExplicit(driver, pinBox);

		pinBox.sendKeys(Integer.toString(PinCode));

		objUtil.screenshotElement(pinBoxVisible, objUtil.pathSS + "PinCode_Entered_" + Integer.toString(PinCode) +".png");
		
		pinBox.sendKeys(Keys.ENTER);
		
	}

	public void pinAvailability(Integer pin) throws IOException {
		
		if (wrongZipMessage.isDisplayed()) objUtil.screenshotElement(pinBoxVisible, objUtil.pathSS + "PinCode_Incorrect.png");
		
		else objUtil.screenshotFullPage(driver, objUtil.pathSS + "PinCode_Correct_" + pin + ".png");
		
	}
	
	public void clickCustomerService() {
		
		allOptionsMenu.sendKeys(Keys.ENTER);
		
		objUtil.waitExplicit(driver, customerService);
		
		customerService.click();
		
	}

}
