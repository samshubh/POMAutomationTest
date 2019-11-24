package sample;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingSelenium {
	
	public static void main(String args[]) throws InterruptedException, AWTException
	{
	// Setting the path and property of chrome driver
	System.setProperty("webdriver.chrome.driver","D:\\Subham Files\\chromedriver_win32\\chromedriver.exe");
	
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
	driver.get("http://www.amazon.in/");
	  Thread.sleep(4000);
    	  
     //Scroll downwards by 250 pixels
	  
	  JavascriptExecutor js1 = (JavascriptExecutor)driver;
	  
	  js1.executeScript("window.scrollBy(0,500)","");
	  
	  Thread.sleep(4000);

	  
	  //Scroll upwards by 250 pixels
	 
	  js1.executeScript("window.scrollBy(0,-500)","");
	  Thread.sleep(4000);
	  
	 //Scroll to the bottom of the web element
	  
	  //js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	  //Thread.sleep(4000);
	  
     //Scroll to a particular Web Element
	  
	  WebElement about = driver.findElement(By.linkText("About Us"));
	  
	  js1.executeScript("arguments[0].scrollIntoView();",about);
	  
	  Thread.sleep(4000);
	  
	  // Scroll Horizontally
	  
	  driver.navigate().to("http://www.clholloway.co.za/");
	  js1.executeScript("window.scrollBy(1000,0)","");
	  Thread.sleep(4000);
	  
}
}
