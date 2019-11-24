package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DifferentLocators {

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
		driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");
		
		Thread.sleep(5000);
		
	
		//  By id locator
		
		//driver.findElement(By.id("firstname")).sendKeys("Shubham");
		
		//Thread.sleep(4000);

		// Same above line can be written using Webelement
		
		WebElement first = driver.findElement(By.id("firstname"));
		
		first.sendKeys("Sarika");
		Thread.sleep(4000);
	
		/*
		Same above line can be written By using CSS selector
		 if id is there, then (#idname) has to be use
		
		driver.findElement(By.cssSelector("#firstname")).sendKeys("Shubham");
		
		Thread.sleep(4000);
	    
		
	   // if class is there, then (.classname) has to be use
	
		driver.findElement(By.cssSelector(".[classname]")).sendKeys("Shubham");
			
		Thread.sleep(4000);
		*/
		
		//By name locator
		
		driver.findElement(By.name("lastname")).sendKeys("Biswas");
		
		Thread.sleep(4000);
		
		//By using CSS selector locator
		 driver.findElement(By.cssSelector("#address1")).sendKeys(" Plot No 74");
			Thread.sleep(4000);

		 driver.findElement(By.cssSelector("#address2")).sendKeys("P & T Colony");
		 	Thread.sleep(4000);
       
		 // By using xpath locator
		   driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Hyderabad");
		     Thread.sleep(4000);
		   
		  /*   
		 //By Using link text locator
		 // Link text can be used only if the html tag  of the element is a
		     
		     driver.findElement(By.linkText("Sign in")).click();
		       Thread.sleep(4000);
		     
		     String linktext = driver.findElement(By.linkText("Sign in")).getText();
		       
		       System.out.println(" The partial link text is :"+linktext);
		       Thread.sleep(4000);
		      
		 //By using partial link text locator
		 
		       //For printing the partial link text we have one method called get text method
		       
		      String partialtext = driver.findElement(By.partialLinkText("Want to register")).getText();
		       
		       System.out.println(" The partial link text is :"+partialtext);
		       Thread.sleep(4000);
		       
		    // Partial link text is used when the link text contains a group of words as link
		       driver.findElement(By.partialLinkText("Want to register")).click();
		       Thread.sleep(4000);
		       
		      */

		 // Selecting a dropdown value using select class
		       
		  Select country = new Select(driver.findElement(By.id("state")));
		  
		      country.selectByVisibleText("Indiana");
		      Thread.sleep(4000);
		  
		  // Entering the postal code
		  
		  WebElement postalcode = driver.findElement(By.id("zip"));
		  
		      postalcode.sendKeys("500015");
		      Thread.sleep(4000);
		      
		  // Entering the mobile  number
		      
		      driver.findElement(By.id("dayphone1")).sendKeys("995");
				Thread.sleep(4000);
		      
				driver.findElement(By.id("dayphone2")).sendKeys("928");
				Thread.sleep(4000);
		       
				driver.findElement(By.id("dayphone3")).sendKeys("8718");
				Thread.sleep(4000);
				
				driver.findElement(By.id("dayphone4")).sendKeys("+91");
				Thread.sleep(4000);
				
		 // Entering the email by using custom xpath
				driver.findElement(By.xpath("//input[@id='email']")).sendKeys("subham@gmail.com");
			       Thread.sleep(4000);
			       
			     driver.findElement(By.xpath("//input[contains(@id,'retype_email')]")).sendKeys("subham@gmail.com");
			       Thread.sleep(4000);
			       
		//Now filling the form
			       
			  driver.findElement(By.id("userid")).sendKeys("subham@gmail.com");
			   Thread.sleep(4000);
			  
			   driver.findElement(By.id("PASSWORD")).sendKeys("Welcome@123");
			   Thread.sleep(4000);
			  
			   driver.findElement(By.id("rpass")).sendKeys("Welcome@123");
			   Thread.sleep(4000);
			  
			  Select question=  new Select(driver.findElement(By.id("SECRET_QUESTION")));
			  question.selectByIndex(4);
			   Thread.sleep(4000);
			  
			   driver.findElement(By.id("SECRET_ANSWER")).sendKeys("Shubh");
			   Thread.sleep(4000);
			  
			   Select month=  new Select(driver.findElement(By.id("birthdate2")));
			       month.selectByIndex(4);
				   Thread.sleep(4000);
				   
				Select day=  new Select(driver.findElement(By.id("birthdate1")));
				       day.selectByValue("10");
					   Thread.sleep(4000);
					   
				Select year=  new Select(driver.findElement(By.id("birthdate3")));
				      year.selectByVisibleText("1996");
						   Thread.sleep(4000);
						   
			  //Selecting radio button 
						   
				WebElement radio = driver.findElement(By.id("acceptq1"));
				
				radio.click();
				Thread.sleep(4000);
				
				//By using classname locator
				
				driver.findElement(By.className("btn")).submit();
				Thread.sleep(4000);
				
				
				
	}
}