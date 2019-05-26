package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class baseClass {
	
	public static WebDriver driver;
	
	public WebDriver initializeChromeDriver()
	{
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    return driver;
	}
	
	public void cleanup()
	{
		driver.close();
	}

	public void waitForElementPresent(By locator, int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
