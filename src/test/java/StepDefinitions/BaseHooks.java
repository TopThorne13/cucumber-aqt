package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import pages.Base;

public class BaseHooks extends Base {
	@Before
	public void init() {
		
		Base.driver = new ChromeDriver();
		Base.driver.get("https://amazon.in/");
		Base.driver.manage().window().maximize();
	}
	
	@After
	public void quitDriver() {
		Base.driver.quit();
	}
	
}