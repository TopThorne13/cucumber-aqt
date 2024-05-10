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

public class SearchPage extends Base{
	
	private WebDriver driver;
	
	UtilClass objUtil = new UtilClass();
	
	SearchPage searchPage;
	
	@FindBy(xpath="//*[text()=\"Results\"]")
	WebElement ResultsText;
	
	@FindBy(id="low-price")
	WebElement minBox;
	
	@FindBy(id="high-price")
	WebElement maxBox;
	
	@FindBy(id="a-autoid-21")
	WebElement rangeSubmit;
	
	@FindBy(xpath="(//span[@class=\"a-declarative\"])[1]")
	WebElement firstProduct;
	
	@FindBy(xpath="(//button[contains(text(), \"Add to cart\")])[1]")
	WebElement addToCartFirst;
	
	@FindBy(id="nav-cart")
	WebElement cart;
	
	@FindBy(xpath="//strong[text() = \"Item Added\"]")
	WebElement itemAdded;
	
	public SearchPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void resultsPageVisible() {
		
		objUtil.waitExplicit(driver, ResultsText);
		
		Assert.assertTrue(ResultsText.isDisplayed());
	}
	
	public void setMinMax(int min, int max) {
		
		if (min > 0) minBox.sendKeys(Integer.toString(min));
		
		if (max > 0) maxBox.sendKeys(Integer.toString(max));
		
		maxBox.sendKeys(Keys.ENTER);
		
		//rangeSubmit.click();
		
		objUtil.waitExplicit(Base.driver, ResultsText);
		
	}
	
	public void ssFirstProduct(String product) throws IOException {
		
		objUtil.waitExplicit(Base.driver, firstProduct);
		
		objUtil.screenshotElement(firstProduct, objUtil.pathSS + "FirstResultSS_" + product +".png");
		
	}
	
	public void addFirstProductToCart() throws InterruptedException {
		
		addToCartFirst.sendKeys(Keys.ENTER);
		
		objUtil.waitExplicit(Base.driver, itemAdded);
		
		Thread.sleep(3000);
		
		objUtil.waitClickable(Base.driver, cart);
		
	}
	
	public void cartClick() {
		
		cart.click();
		
	}

}
