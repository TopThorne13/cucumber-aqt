package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilClass {
	
	public void waitClickable(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public void waitExplicit(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void screenshotElement(WebElement element, String fullPath) throws IOException  {
		
		File source = element.getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(source, new File(fullPath));
	}
	
	public void screenshotFullPage(WebDriver driver, String fullPath) throws IOException {
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(source, new File(fullPath));
		
	}

	String pathSS = new File("").getAbsolutePath() + "\\Screenshots\\";

}
