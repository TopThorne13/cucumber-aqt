package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
	
	private WebDriver driver;
	
	UtilClass objUtil = new UtilClass();
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[5]/div/div[1]/div[3]/div/a")
	WebElement digitalServices;
	
	@FindBy(xpath="(//a[@class=\"devicename\"])[13]")
	WebElement primeGaming;
	
	@FindBy(xpath="//div[@class=\"landing_section\"]//li[1]//a")
	WebElement getStarted;
	
	@FindBy(xpath="//article")
	WebElement article;
	
	public CustomerPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickDigitalServices() {
		
		objUtil.waitExplicit(driver, digitalServices);
		
		digitalServices.click();
		
	}

	public void clickPrimeGaming() {

		objUtil.waitExplicit(driver, primeGaming);
		
		primeGaming.click();
		
	}

	public void clickGetStarted() {

		objUtil.waitExplicit(driver, getStarted);
		
		getStarted.click();
		
	}

	public void screenshotSetup() throws IOException {

		objUtil.waitExplicit(driver, article);
		
		objUtil.screenshotElement(article, objUtil.pathSS + "SetupInstructions.png");
		
	}

}
