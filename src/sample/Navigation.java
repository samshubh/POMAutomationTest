package sample;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Navigation {


	public static void main(String args[]) throws InterruptedException
	{
		// Setting the path and property of chrome driver
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
		   		
		   // Navigate to back page and forward page by back() and forward()
		   		
		   		driver.navigate().back();
		   		  Thread.sleep(5000);

		   		driver.navigate().forward();
		   		  Thread.sleep(5000);
		   		  
		   // Now if we have to refresh the page, we can use refresh method
		   		  driver.navigate().refresh();
		   		   Thread.sleep(4000);
	}
	
}