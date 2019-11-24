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

public class BrokenLinksConcept {
	
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
		driver.get("https://test.rockinterview.in/");
		   Thread.sleep(5000);
		   
		   //Step 1:Find all the links and images in the webpage
		   
		     List<WebElement> linksList= driver.findElements(By.tagName("a"));
		      
		        linksList.addAll(driver.findElements(By.tagName("img")));
		        
		        System.out.println("The total no of links and images are :"+linksList.size());
            
		        
		        // Now we have to create a separate array list for storing active links only
		        
		          List<WebElement> activeLinks= new ArrayList <WebElement>();
		           
		          
		          //Step 2: Now we have to iterate the loop which stores only the active links
		          
		           for(int i=0;i<linksList.size();i++)
		           {
		        	   
		        	   System.out.println(linksList.get(i).getAttribute("href"));
		        	   
		   
		        	   if(linksList.get(i).getAttribute("href")!= null &&(!linksList.get(i).getAttribute("href").contains("javascript")))
		           
		        	   {	    
		        		   activeLinks.add(linksList.get(i));
		        		   
		        	   }
		           }
		           
		           // Here are printing the total no of active links
		           
		              System.out.println("The total no of active links are :"+activeLinks.size());
		           
		           // Step 3: Now we have to verify the href attribute with HTTP connection API
		              
		              for (int j=1;j<activeLinks.size();j++)
		              {
		            	  HttpURLConnection connection =  (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
		            	  
		            	  connection.connect();
		            	  
		            	  String responseMessage = connection.getResponseMessage();
		            	    System.out.println(activeLinks.get(j).getAttribute("href")+"----->"+responseMessage);
		            	    
		            	    connection.disconnect();
		            	  
		              }
		           
		          
   }
}
