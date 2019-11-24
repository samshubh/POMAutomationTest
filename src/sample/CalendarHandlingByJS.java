package sample;

import java.awt.AWTException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CalendarHandlingByJS {

	public static void main(String args[]) throws InterruptedException, AWTException {
// Setting the path and property of chrome driver
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver_win32\\chromedriver.exe");

// Creating instance of webdriver 
		WebDriver driver = new ChromeDriver();

//Maximizing the browser

		driver.manage().window().maximize();

// clearing the browser cookies

		driver.manage().deleteAllCookies();

//Setting the page load timeout for the web page 
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

//Enter Url
		driver.get("https://www.tsrtconline.in/oprs-web/");
		Thread.sleep(4000);

// Enter From place and to place

		driver.findElement(By.id("fromPlaceName")).sendKeys("Hyderabad");
		Thread.sleep(4000);

		List<WebElement> fromDate = driver
				.findElements(By.xpath("//ul[@id='ui-id-1']/li/descendant::a[@id='ui-id-22']"));

		System.out.println(fromDate.size());

		for (int i = 0; i < fromDate.size(); i++)

		{
			System.out.println(fromDate.get(i).getText());

		}

//Now click on calendar icon 

		WebElement date = driver.findElement(By.id("txtJourneyDate"));

		String dayVal = "30/12/2019";

		calendarByJs(driver, date, dayVal);
		Thread.sleep(5000);

//Now click on 

	}

	public static void calendarByJs(WebDriver driver, WebElement element, String dayVal) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("arguments[0].setAttribute('value','" + dayVal + "');", element);

	}
}