package pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import framework.baseClass;

public class Login extends baseClass {
	
	public By lnk_SignIn_xPath_Locator = By.xpath("//a[@href='http://automationpractice.com/index.php?controller=my-account']");
	public By txt_UserName_Id_Locator = By.id("email");
	public By txt_Password_Id_Locator = By.id("passwd");
	public By btn_SignIn_Id_Locator = By.id("SubmitLogin");
	
	public By lnk_Women_Title_Locator = By.xpath("//a[@title='Women']");
	public By lnk_Tops_xPath_Locator = By.xpath("//ul[contains(@class,'tree')]/li/a[@href='http://automationpractice.com/index.php?id_category=4&controller=category']");
	public By productNameLocator = By.xpath("//img[@title='Faded Short Sleeve T-shirts']");		
	public By iframe_Locator = By.className("fancybox-iframe");
	public By btn_AddToCart = By.xpath("//button[@name='Submit']");	
	public By successfulMessage_Locator = By.xpath("//div[@id='layer_cart']//h2");
	
	
	public void browseUrl(String url)
	{
		driver.get(url);
	}
	
	public void clickOnSignInLink()
	{
		driver.findElement(lnk_SignIn_xPath_Locator).click();
	}
	
	public void loginToApplication(String userName, String password)
	{
		driver.findElement(txt_UserName_Id_Locator).sendKeys(userName);
		driver.findElement(txt_Password_Id_Locator).sendKeys(password);
		driver.findElement(btn_SignIn_Id_Locator).click();
		//waitForElementPresent(lnk_Women_Title_Locator, 30);		
	}
		
	public void navigateToTopsFromWomensCategory() throws Exception
	{
		driver.findElement(lnk_Women_Title_Locator).click();
		driver.findElement(lnk_Tops_xPath_Locator).click();
	}
	
	public void addProductToCart()
	{
		driver.findElement(productNameLocator).click();
		driver.switchTo().frame(driver.findElement(iframe_Locator));
		driver.findElement(btn_AddToCart).click();
		driver.switchTo().defaultContent();
		waitForElementPresent(successfulMessage_Locator, 30);
		String message = driver.findElement(successfulMessage_Locator).getText();
		Assert.assertEquals(message,"Product successfully added to your shopping cart"); 
	}
	
	
	

}
