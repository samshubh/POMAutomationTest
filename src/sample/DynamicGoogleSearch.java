package sample;
		
	import java.awt.AWTException;
	import java.util.List;
	import java.util.concurrent.TimeUnit;	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	
	public class DynamicGoogleSearch {
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
	
	
	//Enter Url
	driver.get("https://www.google.com/");
	Thread.sleep(4000);
	
	   //We have to search in googles search box 
	
	    driver.findElement(By.name("q")).sendKeys("testing");
	       Thread.sleep(4000);
	       
	       // Now we have to click on the fourth option in the search
	   List<WebElement> suggestion = driver.findElements(By.xpath("//ul[@role='listbox']/li/descendant::div[@class='sbl1']"));
	        
	    System.out.println("The total no of suggestions are:"+suggestion.size());
	    
	    for(int i=0;i<suggestion.size(); i++)
	    {
	    	System.out.println(suggestion.get(i).getText());
	    
	    if(suggestion.get(i).getText().contains("testing jobs"))
	    {
	    	suggestion.get(i).click();
	    	break;
	    	
	    }
	
	}
	}
}