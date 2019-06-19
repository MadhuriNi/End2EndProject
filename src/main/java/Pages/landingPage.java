package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class landingPage {
	
	
	public WebDriver driver;
	
	public landingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	By login=By.cssSelector("a[href*='sign_in']");
	By title=By.cssSelector(".text-center>h2");
	
	
	public void getLogin()
	{
		driver.findElement(login).click();
	}
	
	public String getTitle()
	{
		return driver.findElement(title).getText();
	}

}
