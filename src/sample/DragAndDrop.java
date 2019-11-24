package sample;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
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
	driver.get("https://jqueryui.com/droppable/");
	  Thread.sleep(4000);
	  
	  
	  // Here in this webpage we have to first move the focus to frame
	  // For switching into the frame we have a method called switchTo().frame(0)
	  
	  driver.switchTo().frame(0);
	   Thread.sleep(4000);
	   
	  // For Drag and drop we have to use method click and hold and then release to the target
	  
	  Actions action = new Actions(driver);
	  
	  action.clickAndHold(driver.findElement(By.xpath("//*[@id=\"draggable\"]")))
	  .moveToElement(driver.findElement(By.id("//*[@id=\"droppable\"]")))
	  .release()
	  .build()
	  .perform();
	  
	  Thread.sleep(4000);
	  
	}
}