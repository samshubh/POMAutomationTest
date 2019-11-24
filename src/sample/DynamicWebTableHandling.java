	package sample;
	
	
	import java.awt.AWTException;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.concurrent.TimeUnit;
	
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	
	public class DynamicWebTableHandling {
	public static void main(String args[]) throws InterruptedException, AWTException
	{
	// Setting the path and property of chrome driver
	System.setProperty("webdriver.chrome.driver","D:\\Subham Files\\chromedriver_win32\\chromedriver.exe");
	
	// Creating instance of webdriver 
	WebDriver driver = new ChromeDriver();
	
	//Maximizing the browser
	
	driver.manage().window().maximize();
	
	// clearing the browser cookies
	
	driver.manage().deleteAllCookies();
	
	//Setting the page load timeout for the web page 
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	
	
	//Enter Url
	driver.get("http://13.127.181.42:8066/");
	Thread.sleep(5000);
	
	//Clicking on login button
	
	driver.findElement(By.linkText("Log in")).click();
	Thread.sleep(5000);
	
	//Entering the email id and password
	
	driver.findElement(By.id("email")).sendKeys("admin@yourstore.com");
	Thread.sleep(4000);
	
	driver.findElement(By.id("Password")).sendKeys("admin");
	Thread.sleep(4000);
	
	driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	Thread.sleep(4000);
	
	// Now click on administration link
	
	driver.findElement(By.linkText("Administration")).click();
	Thread.sleep(5000);
	
	//Now click on Sales menu 
	
	driver.findElement(By.xpath("//span[contains(text(),'Sales')]")).click();
	Thread.sleep(3000);
	
	//Now click on orders link
	driver.findElement(By.xpath("//span[contains(text(),'Orders')]")).click();
	Thread.sleep(4000);
	
	// Calling scroll method 
	
	WebElement search = driver.findElement(By.id("search-orders"));
	
	scrollIntoElement(search,driver);
	Thread.sleep(4000);
	
	// Now For handling the dynamic web table, we have two methods
	// In first method, we have to break down the xpath in two parts and then iterate and compare
	
	String firstpart_xpath = "//*[@id=\"orders-grid\"]/table/tbody/tr[";
	String secondpart_xpath = "]/td[2]";
	
	
	for (int i = 1; i <= 3; i++) {
	String id = driver.findElement(By.xpath(firstpart_xpath + i + secondpart_xpath)).getText();
	System.out.println(id);
	
	if (id.contains("1778")) {	
	break;
	}
	driver.findElement(By.xpath("//*[@id=\"orders-grid\"]/table/tbody/tr[" + i + "]/td[10]/a")).click();
	
	Thread.sleep(5000);	
	// Now we are clicking on cancel order	
	driver.findElement(By.id("cancelorder")).click();
	Thread.sleep(5000);	
	// Now we have to accept the pop up message
	
	driver.findElement(By.id("cancelorder-action-confirmation-submit-button")).click();
	Thread.sleep(3000);
	
	// Now click on Back to order list
	
	driver.findElement(By.linkText("back to order list")).click();
	Thread.sleep(4000);
	}
	
	}
	
	public static void scrollIntoElement(WebElement element,WebDriver driver)
	{
	JavascriptExecutor js = ((JavascriptExecutor)driver);
	js.executeScript("arguments[0].scrollIntoView(true);",element);
	
	}
	}