	package sample;
	
	import java.awt.AWTException;
	import java.util.List;
	import java.util.concurrent.TimeUnit;	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	
	public class HandlingDynamicCalendar {
	
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
	driver.get("https://ui.freecrm.com/");
	Thread.sleep(4000);
	
	// Enter Email & Password
	
	driver.findElement(By.name("email")).sendKeys("subhambiswas895@gmail.com");
	Thread.sleep(3000);
	
	driver.findElement(By.name("password")).sendKeys("Welcome123$");
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]")).click();
	Thread.sleep(3000);
	
	// Now click on Calendar menu item
	driver.findElement(By.xpath("//span[contains(text(),'Calendar')]")).click();
	Thread.sleep(4000);
	
	// Now click on next month to change the month and year value
	driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]/span[1]/button[2]")).click();
	Thread.sleep(4000);
	
	//Now we will split the xpath into two parts
	
	String before_xpath = "//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[";
	
	String after_xpath = "]/div[2]/div/div[";
	
	boolean flag = false;
	
		for (int rowNum = 2; rowNum <= 7; rowNum++) {
			int k = 1;
			if (rowNum == 2)
				k = 2;
			for (int colNum = k; colNum <= 7; colNum++) {
				String dayValue = driver.findElement(By.xpath(before_xpath + rowNum + after_xpath + colNum + "]"))
						.getText();

				System.out.println(dayValue);

				if (dayValue.contains("18")) {

					driver.findElement(By.xpath(before_xpath + rowNum + after_xpath + colNum + "]")).click();
					flag = true;
					break;
				}
			}

			if (flag) {
				break;
			}
		}
	}
}