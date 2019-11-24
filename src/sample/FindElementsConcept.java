package sample;

import java.awt.AWTException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FindElementsConcept {
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
	driver.get("https://www.facebook.com/");
	  Thread.sleep(4000);
	  
	  // To get the total count of links
	  
	  List <WebElement> linklist = driver.findElements(By.tagName("a"));
	  
	  System.out.println(linklist.size());
	  
	  // To print the text of all the links
	  
	    for( int i=0; i<linklist.size();i++)
	    {
	    	String linktext = linklist.get(i).getText();
	    	
	    	System.out.println(linktext);
	    	
	    }
	    	
	    	
	  
	  
	}
}