package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	
	public WebDriver driver;
	
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By uid=By.id("user_email");
	By pwd=By.cssSelector("input[id='user_password']");
	By login=By.cssSelector("input[value='Log In']");
	By err=By.cssSelector(".alert.alert-danger");
	
	public void enterData(String user,String pass)
	{
		driver.findElement(uid).sendKeys(user);
		driver.findElement(pwd).sendKeys(pass);
		driver.findElement(login).click();
	}
	
	public String getError()
	{
		return driver.findElement(err).getText();
	}

}
