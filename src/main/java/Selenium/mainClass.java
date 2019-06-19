package Selenium;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import Pages.landingPage;
import Pages.loginPage;
//rahulonlinetutor@gmail.com

public class mainClass extends base{
	
	public Logger logger;
	
	
	@Test(dataProvider="object")
	public void basePageNavigation(String user,String pass) throws Exception
	{
		//logger		
		logger=Logger.getLogger("mainclass");
		PropertyConfigurator.configure("Log4j.properties");
		
		
		driver=initializeDriver();
		logger.info("The driver is initialized");
		driver.get("http://www.qaclickacademy.com/");
		
		landingPage lp=new landingPage(driver);
		String title=lp.getTitle();
		logger.info("The title is "+title);
		//Assert.assertEquals(title, "Featured");	//assert	
		lp.getLogin();
		
		
		
		loginPage lg=new loginPage(driver);
		lg.enterData(user,pass);
		logger.info("The user id is -----"+user+" The password is ----"+pass);
		String err=lg.getError();
		Assert.assertEquals(err, "");
		
	}
	
	@DataProvider(name="object")
	public Object[][] getData()
	{
		Object[][] data=new Object[2][2];
		
		data[0][0]="abc@gmail.com";
		data[0][1]="abc123$";
		
		data[1][0]="madhuri.nirmale@gmail.com";
		data[1][1]="vanita786$";
		
		return data;
	}
	
	

	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}
