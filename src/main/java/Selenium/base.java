package Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public static WebDriver driver;
	
	/*public base(WebDriver driver)
	{
		this.driver=driver;
	}
*/
	public WebDriver initializeDriver() throws Exception {
		File src = new File("./Configuration.property");
		FileInputStream fis = new FileInputStream(src);
		Properties prop = new Properties();
		prop.load(fis);

		if (prop.getProperty("Browser").equalsIgnoreCase("firefox")) {
			
			System.setProperty(prop.getProperty("FirefoxDriver"), prop.getProperty("FirefoxDriverPath"));
			driver = new FirefoxDriver();
		}

		if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty(prop.getProperty("ChromeDriver"), prop.getProperty("ChromeDriverPath"));
			driver = new ChromeDriver();
		}

		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 return driver;

	}
	
	public void getScreenshot(String screenShotName) 
	{
		System.out.println("Inside the screenshot method as the test has failed");
		TakesScreenshot ts=(TakesScreenshot)driver;
		System.out.println("screenshot driver initalized");
		File src=ts.getScreenshotAs(OutputType.FILE);
		System.out.println("Screenshot taken");
		try {
			FileUtils.copyFile(src, new File("./Screenshots/"+screenShotName+".png"));
		} catch (IOException e) {
			System.out.println("inside catch of the getScreenshot");
		}
		
		
	}
	

}
