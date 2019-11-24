package sample;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksKipos {
	
	public static void main(String args[]) throws InterruptedException, MalformedURLException, IOException
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
		driver.get("https://www.kiposcollective.com/#/");
		   Thread.sleep(5000);
		   
		   WebElement login= driver.findElement(By.xpath("//span[@class='btn btn-sign']"));
	       login.click();
	       Thread.sleep(4000);
	       //explicitWait(driver,login,4000);
	       
	       //Verify the text New Customer
	       
	       String customer = driver.findElement(By.xpath("//h5[contains(text(),'New Customer')]")).getText();
	           System.out.println(customer);
	           
	       // Enter the customer details
	           driver.findElement(By.id("email")).sendKeys("prashanth.burri@srijaytech.com");
	              Thread.sleep(4000);
	           
	           driver.findElement(By.id("password_login")).sendKeys("welcome123");
	              Thread.sleep(4000);
	           
	           driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
	              Thread.sleep(4000);
       
		   
		 //Step 1:Find all the links and images in the webpage
		  List<WebElement> linkList =  driver.findElements(By.tagName("a")); 
		   
		   linkList.addAll(driver.findElements(By.tagName("img")));
		   
		   System.out.println("The total no of links are :"+linkList.size());
		     
		   // Now we have to create a separate array list for storing active links only
		      
		   List<WebElement> activeLinks = new ArrayList<WebElement>();
		   
		      
		 //Step 2: Now we have to iterate the loop which stores only the active links
		   
		   for(int i=0;i<linkList.size();i++)
		   {
			   if(linkList.get(i).getAttribute("href")!= null)
			   {
				   activeLinks.add(linkList.get(i));
				   
			   }
		   }
		// Here are printing the total no of active links
           
           System.out.println("The total no of active links are :"+activeLinks.size());
        
        // Step 3: Now we have to verify the href attribute with HTTP connection API
           
           for (int j=0;j<activeLinks.size();j++)
           {
        	   HttpURLConnection conn = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
        	   
        	   conn.connect();
        	   
        	   String response = conn.getResponseMessage();
        	     System.out.println(activeLinks.get(j).getAttribute("href")+"--->"+response);
        	     
        	     conn.disconnect();
        	   
           }
      }
  }
