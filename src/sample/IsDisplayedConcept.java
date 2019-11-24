	package sample;
	
	
	import java.awt.AWTException;
	import java.util.concurrent.TimeUnit;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	
	public class IsDisplayedConcept {
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
	driver.get("https://register.freecrm.com/register/");
	Thread.sleep(4000);
	
	
	//IsDisplayed method is verify the presence of element in the webpage
	// Below code will return a boolean type value
	
	boolean b1= driver.findElement(By.id("email")).isDisplayed();
	System.out.println(b1);
	Thread.sleep(3000);
	
	
	// IsEnabled method is to verify whether the element is enabled r disabled 
	
	boolean b2 = driver.findElement(By.xpath("//button[@class='ui fluid large blue submit button']")).isEnabled();
	System.out.println(b2);
	Thread.sleep(3000);
	
	// IsSelected method is to verify whether the particular element is selected r not, it is used only for checkboxes, radio button and 
	boolean b3 = driver.findElement(By.id("terms")).isSelected();
	System.out.println(b3);
	Thread.sleep(3000);
	
	
	driver.findElement(By.id("terms")).click();
	
	boolean b4 = driver.findElement(By.id("terms")).isSelected();
	System.out.println(b4);
	Thread.sleep(4000);
	}
	}