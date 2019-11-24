package sample;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LandingPage {

	public static void main(String args[]) throws InterruptedException
	{
	
		//Here we are setting the path for the chrome driver
	System.setProperty("webdriver.chrome.driver","F:\\chromedriver_win32\\chromedriver.exe");
	
	
	//Here we are creating an object for chrome driver by using webdriver interface
	WebDriver driver= new ChromeDriver();
	
    //Here we are maximizing the browser
	driver.manage().window().maximize();
			Thread.sleep(3000);
	
	
	driver.get("http://13.127.181.42/#/");
	
	Thread.sleep(5000);
	
	
	//getting the Current url  
	 String currenturl =driver.getCurrentUrl();
	
     System.out.println("The Current Url is :"+currenturl);
     
  
 		Thread.sleep(5000);
 	
     
     // Getting class name
     Class clsname =driver.getClass();
     
     System.out.println("The Current class name is :"+clsname);
    
  		Thread.sleep(5000);
  	
      /*
     // getting page source
    String page= driver.getPageSource();
    
    System.out.println("The page source is :"+page);

    try {
  		Thread.sleep(5000);
  	} catch (InterruptedException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
      */
    //getting title of the page
    
     String title =driver.getTitle();
     
     System.out.println("The title of the page is :"+title);
     
     
     //Using equals method for validation
     if(title.equals("Nuqi"))
     {
    	 System.out.println("Correct title");
     }
     else
     {
    	 System.out.println("Incorrect title");
     }
   		Thread.sleep(5000);
     
   		
   		//Using contains method for verifying the char contain
        if(title.contains("S"))
        {
        	System.out.println("It contains");
        }
        else
        {
        	System.out.println("It does not contain");
        }
   		
        
        //
        
        if(title.contentEquals("[u][q]"))
        {
        	System.out.println("It matches");
        }
        else
        {
        	System.out.println("doesnt matches");
        }
     // getting window handle
     
     String handle=driver.getWindowHandle();
     
     System.out.println("The window handle of the page is :"+handle);
     
     Thread.sleep(5000);
     
     
     // getting window handles
     Set windowhandle=driver.getWindowHandles();
     
     System.out.println("The window handle of the page is :"+windowhandle);
     
     Thread.sleep(5000);
     
     /*
     
     //performing actions in firefox browser
     
 	//Here we are setting the path for the firefox driver
 	System.setProperty("webdriver.gecko.driver","C:\\Users\\Shubham\\Downloads\\geckodriver-v0.26.0-win32\\geckodriver.exe");
 	
 	
 	//Here we are creating an object for chrome driver by using webdriver interface
 	WebDriver driver1= new FirefoxDriver();
 	
     //Here we are maximizing the browser
 	driver1.manage().window().maximize();
 			Thread.sleep(3000);
 	
 	
 	driver1.get("http://13.127.181.42/#/");
 	
 	Thread.sleep(5000);
 	
 	
 	String title1 =driver.getTitle();
    
    System.out.println("The title of the page is :"+title1);
    
   
  		Thread.sleep(5000);
  		
  		*/
     driver.quit();
     
 

     
}
}