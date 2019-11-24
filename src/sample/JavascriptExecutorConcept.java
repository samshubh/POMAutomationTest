package sample;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException, IOException {
		
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
		driver.get("https://ui.freecrm.com/");
		  Thread.sleep(4000);

		  //Locating web elements using xpath
		WebElement email =  driver.findElement(By.xpath("//input[@placeholder='E-mail address']"));
		  
		     sendKeysByJs(email,driver);
		    Thread.sleep(4000);
		    
		   driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("welcome@123");
		   Thread.sleep(4000);
		    
		   //  Clicking on login button
		   
		   WebElement loginButton = driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']"));
		   
		   // Calling flash method to highlight the element
		   flash(loginButton,driver);
		   
		   Thread.sleep(4000);
		   
		   //Calling drawBorder method to the create a circle 
		   
		   drawBorder(loginButton,driver);
		   
		   // Take a screenshot 
		   File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   
		   FileUtils.copyFile(src, new File("F:\\Example.png"));
		   
		   
		   //Calling the method for generateAlert
		   
		   generateAlert(driver, " There is a bug in the login form");
		   
		   Thread.sleep(8000);
		   
		  Alert pop=  driver.switchTo().alert();
		   
		   pop.accept();
		   
		 
		   
		   //Get page title by calling getTitleByJs
		   
		   System.out.println(getTitleByJs(driver));
		   Thread.sleep(4000);
		   
		   //Get page inner text by using get below getInnerPageText method
		   
		   System.out.println(getInnerPageText(driver));
		   Thread.sleep(4000);
		   
		   //To refresh the page we are calling the refresh 
		   
		   refreshByJs(driver);
		   Thread.sleep(4000);
		   
		   
		   driver.navigate().to("https://www.facebook.com/");
		   Thread.sleep(4000);

		   //Calling scrollBottom method
		   
		   scrollToBottom(driver);
		   Thread.sleep(4000);
		     
		   scrollToTop(driver);
		   Thread.sleep(4000);

		   

	}

	  // To higlight a button/element we have to create a method called flash 
	
	   public static void flash(WebElement element, WebDriver driver) throws InterruptedException
	   {
		   JavascriptExecutor js = ((JavascriptExecutor)driver);
		   
		    String bgcolor = element.getCssValue("backgroundColor");
		   
		   for (int i=0; i<2; i++)
		   {
			   changeColor("rgb(0,200,0)",element,driver);
			   changeColor(bgcolor,element,driver);
			   
		   }
		   
		   
	   }
        // To change the color of the highlighted element, we have use changeColor 
	   public static void changeColor(String color, WebElement element, WebDriver driver) 
	
	{
		   JavascriptExecutor js = ((JavascriptExecutor)driver);
		   
		   js.executeScript("arguments[0].style.backgroundColor ='"+color+"'", element);
		   
		   try
		   {
			   Thread.sleep(2000);
		   } catch(InterruptedException e)
		   {
			   
		   }
		
	}
	    // To Draw a border for the highlighted element, we have use drawBorder method
	   public static void drawBorder(WebElement element, WebDriver driver)
	   {
		   JavascriptExecutor js = ((JavascriptExecutor)driver);
		   
		     js.executeScript("arguments[0].style.border='3px solid red'",element);
		     
	   }
	   
	   
	   //To get the title of the page 
	   public static String getTitleByJs(WebDriver driver)
	   {
		   
		   JavascriptExecutor js = ((JavascriptExecutor)driver);
		      String title =  js.executeScript("return document.title").toString();
		       return title;
		   
	   }
	   
	   //To get all the inner text in the page
	   public static String getInnerPageText(WebDriver driver)

          { 
		   JavascriptExecutor js = ((JavascriptExecutor)driver);
		  String innertext = js.executeScript("return document.documentElement.innerText").toString();
		  
		     return innertext;
		     
		   }
	     
	   //To generate an alert for the highlighted element
	   public static void generateAlert(WebDriver driver, String message)
	   {
		   JavascriptExecutor js = ((JavascriptExecutor)driver);
		     js.executeScript("alert('"+message+"')");
	   }
	   
	   //To refresh the page we have to use history.go(0)
	   
	   public static void refreshByJs(WebDriver driver)
	   {
		   JavascriptExecutor js = ((JavascriptExecutor)driver);
		   	js.executeScript("history.go(0)");  
		   	
	   }
	    // To scroll the page to the bottom of the webpage 
	   public static void scrollToBottom(WebDriver driver)
	   {
		   JavascriptExecutor js = ((JavascriptExecutor)driver);
		     js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	   }
	   
	   // To scroll the page to the top of the webpage 
	   public static void scrollToTop(WebDriver driver)
	   {
		   JavascriptExecutor js = ((JavascriptExecutor)driver);
		     js.executeScript("window.scrollTo(0,0)");
	   }
	   
	   //To send the value to the fields using javascript executor
	   
	   public static void sendKeysByJs(WebElement element, WebDriver driver)
	   {
		   JavascriptExecutor js = ((JavascriptExecutor)driver);
		     js.executeScript("arguments[0].value='Shubham'");
	   }
}
