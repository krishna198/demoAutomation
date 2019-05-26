package demoProject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import framework.baseClass;
import pageOperations.Login;

public class Scenarios extends baseClass {
	
	Login obj = new Login();
	public WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver = initializeChromeDriver();
	}
	
	@Test
	public void scenario1() throws Exception
	{
		obj.browseUrl("http://automationpractice.com/index.php");
		obj.clickOnSignInLink();
		obj.loginToApplication("gtl_test@thegatewaycorp.com", "Gtl@123");
		obj.navigateToTopsFromWomensCategory();
		obj.addProductToCart();
	}
	
	@Test
	public void scenario2() throws Exception
	{
		obj.browseUrl("https://www.google.com/");
	}
	
	@AfterClass
	public void afterClass()
	{
		cleanup();
	}

}
