package sample;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserPopUpWindow {
	

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
		driver.get("http://popuptest.com/");
		   Thread.sleep(5000);
		  
		   
		   clickOn(driver,driver.findElement(By.linkText("Multi-PopUp Test")),20);
		   
		 // Now for handling Pop up window we have a method called Windowhandles(), it will return set of string
		   
		  Set<String> handler = driver.getWindowHandles();
		
		  //For Set type of class, we can use Iterator as it has no index value
		  
		   Iterator<String> it =handler.iterator();
		  
             //To move the focus to first field in set elements we have to use next method, first we are creating parent window id
		     String ParentWindowid = it.next();
		     
		     Thread.sleep(4000);
		     System.out.println(ParentWindowid);
		     
		     
		   // Now we are creating child window
		     
				     String ChildWindowid1 = it.next();
				     
				     Thread.sleep(4000);
				     System.out.println(ChildWindowid1);

		     
		     		String ChildWindowid2 = it.next();
		     		  Thread.sleep(4000);
		     		  System.out.println(ChildWindowid2);
		     		
		     		String ChildWindowid3 = it.next();
			     		Thread.sleep(4000);
			     		System.out.println(ChildWindowid3);
		     		
		     		String ChildWindowid4 = it.next();
			     		Thread.sleep(4000);
			     		System.out.println(ChildWindowid4);
		     		
		     		String ChildWindowid5 = it.next();
			     		Thread.sleep(4000);
			     		System.out.println(ChildWindowid5);
		     		
		     		String ChildWindowid6 = it.next();
			     		Thread.sleep(4000);
			     		System.out.println(ChildWindowid6);
		     		/*
		     		String ChildWindowid7 = it.next(); 
			     		Thread.sleep(4000);
			     		System.out.println(ChildWindowid7);
		     		
		     		String ChildWindowid8 = it.next();
		     		Thread.sleep(4000);
		     		System.out.println(ChildWindowid8);
		     		*/
		     
		     // Now switching to child window 
		     driver.switchTo().window(ChildWindowid1); 
			     Thread.sleep(4000);
			     System.out.println("The title of the page is:"+driver.getCurrentUrl());
			     driver.close();
		     
		     driver.switchTo().window(ChildWindowid2);
			     Thread.sleep(4000);
			     System.out.println("The title of the page is:"+driver.getCurrentUrl());
			     driver.close();

			     driver.switchTo().window(ChildWindowid3);
				     Thread.sleep(4000);
				     System.out.println("The title of the page is:"+driver.getCurrentUrl());
				     driver.close();
				     
				     driver.switchTo().window(ChildWindowid4);
					     Thread.sleep(4000);
					     System.out.println("The title of the page is:"+driver.getCurrentUrl());
					     driver.close();

					     driver.switchTo().window(ChildWindowid5);
						     Thread.sleep(4000);
						     System.out.println("The title of the page is:"+driver.getCurrentUrl());
						     driver.close();

						     driver.switchTo().window(ChildWindowid6);
							     Thread.sleep(4000);
							     System.out.println("The title of the page is:"+driver.getCurrentUrl());
							     driver.close();
							     Thread.sleep(4000);
                 //Now again switch to parent window
							     
				  driver.switchTo().window(ParentWindowid);
				    Thread.sleep(4000);
           
	   
		   }

	// Writing the Explicit wait for the element
	
        public static void clickOn(WebDriver driver,WebElement locator, int timeout)
        {
        	new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class)
        	.until(ExpectedConditions.elementToBeClickable(locator));
        	locator.click();
        }
	
	
}