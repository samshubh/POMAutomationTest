package sample;


import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovement {
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
	driver.get("https://www.spicejet.com/");
	  Thread.sleep(4000);
	  
	  // To handle mouse over we have to Use Action class for Addons

	  
	    Actions action = new Actions(driver);
	    
	    action.moveToElement(driver.findElement(By.id("highlight-addons"))).build().perform();
	    
	    
	    
	    Thread.sleep(4000);
	    
	    
	    //Selecting hot meals after mouse over by using link text as they are the links
		    
		    driver.findElement(By.linkText("Hot Meals")).click();
		    
		    Thread.sleep(4000);
		    
		    driver.navigate().back();
		    
		    Thread.sleep(4000);
		    
		    
		    action.moveToElement(driver.findElement(By.id("highlight-addons"))).build().perform();
		    
		    driver.findElement(By.linkText("SpiceBiz")).click();
		    
		    Thread.sleep(4000);
		    
		    driver.navigate().back();
		    
		    Thread.sleep(4000);
		    
		    //Selecting the element inside the element of element
		    
		    action.moveToElement(driver.findElement(By.id("ctl00_HyperLinkLogin"))).build().perform();
		    
		    Thread.sleep(4000);
		    
			    action.moveToElement(driver.findElement(By.linkText("SpiceClub Members"))).build().perform();
			    
			    Thread.sleep(4000);
		    
			    driver.findElement(By.linkText("Member Login")).click();
			    
			    Thread.sleep(4000);
			    
			    String link = driver.findElement(By.linkText("Member Login")).getText();
			    
			    System.out.println("The link name is:+link");
			    Thread.sleep(4000);
			    
			    driver.quit();
}
}
