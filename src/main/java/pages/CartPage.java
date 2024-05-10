package pages;

import java.io.IOException;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage extends Base {
	
	private WebDriver driver;
	
	UtilClass objUtil = new UtilClass();
	
	@FindBy(xpath="//*[text()=\" Your order is eligible for FREE Delivery. \"]")
	WebElement freeDelivery;
	
	public CartPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void cartScreenshot(String product) throws IOException {
		
		objUtil.screenshotFullPage(Base.driver, objUtil.pathSS + "FullPageSS_" + product +".png");
		
	}

	public void freeDeliveryVisible() {
		try {
			
			Assert.assertTrue(freeDelivery.isDisplayed());
			
		} catch(TimeoutException e) {
			
			System.out.println("ExceptionVisbility:" + e);
			
		}
		
	}

}
