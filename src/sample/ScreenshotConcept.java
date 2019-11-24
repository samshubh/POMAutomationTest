package sample;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotConcept {

	public static void main(String[] args) throws InterruptedException, IOException
	{
		
		//Setting the path and property of chrome driver
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver_win32\\chromedriver.exe");
		
		// Creating instance of webdriver 
		WebDriver driver = new ChromeDriver();
		
		//Maximizing the browser
		
		driver.manage().window().maximize();
		
		// clearing the browser cookies
		
		driver.manage().deleteAllCookies();
		
		//Setting the page load timeout for the web page 
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		//Syntax for implicit wait
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//Enter Url
		driver.get("https://www.google.com/");
		   Thread.sleep(5000);
		   
		   
		 //Now if we have to navigate to any other external link, we have to use navigate().to() method
			  
		   driver.navigate().to("https://www.facebook.com/");
		   		Thread.sleep(5000);
		   		
		   		
		   	driver.navigate().to("https://www.youtube.com/watch?v=u-FaTNxrWhw&list=RDVbfRhbZwLjI&index=2");
		   		Thread.sleep(5000);
		   		
		   // Now if we have to take screenshot, we have one method called getScreenshotAs which returns file object
	
		   		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   		
		   		FileUtils.copyFile(src, new File("F:\\Example1.png"));
		   		
		   		Thread.sleep(4000);
    }
		   
 }
		   