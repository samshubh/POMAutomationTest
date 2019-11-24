package sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {

	
	public static void main(String args[]) throws InterruptedException, AWTException
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
	driver.get("https://html.com/input-type-file/");
	  Thread.sleep(4000);
	  
	  
	  /*
	  // We have to scroll the page using Robot class 
	   
	     Robot robot = new Robot();

	     robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	     robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	     
		 Thread.sleep(4000);
		 
		 */
	  // Scrolling into particular Web Element
	   
	  WebElement upload = driver.findElement(By.id("fileupload"));
	  
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  
	  js.executeScript("arguments[0].scrollIntoView();",upload);
	  
	  Thread.sleep(4000);
	  		
		 
	   
	  
	  // Here we are uploading the file by using sendKeys
	  
	  driver.findElement(By.id("fileupload")).sendKeys("C:\\Users\\subham\\Desktop\\sample.pdf");
	  
	  Thread.sleep(4000);
	
}
}
