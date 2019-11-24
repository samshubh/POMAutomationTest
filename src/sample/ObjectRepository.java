	package sample;
	
	
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
	
	public class ObjectRepository {
	
	//As we are not going to create the Webdriver instance again and again we are making it global
	static WebDriver driver; 
	
	public static void main(String[] args) throws IOException, InterruptedException 
	{
	
	
	// Now if we have to read the properties file, we have to create object of Properties class
	
	Properties prop = new Properties();
	
	// Then we have to create the object of FileInputStream class which takes the path of file to be read
	FileInputStream file = new FileInputStream("C:\\Users\\subham\\eclipse-workspace\\SeleniumClass\\src\\sample\\config.properties");
	
	//Then we are loading the file by using load method by passing file as an argument
	prop.load(file);
	
	//Now suppose if we want to display the property for key value name
	
	//String name = prop.getProperty("name");
	System.out.println(prop.getProperty("name"));
	Thread.sleep(2000);
	
	//Similarly if i want to print the other property in config file, first we need to use the getProperty method which returns a String
	
	//String age = prop.getProperty("age");
	System.out.println(prop.getProperty("age"));
	Thread.sleep(2000);
	
	String city = prop.getProperty("city");
	System.out.println(city);
	Thread.sleep(2000);
	
	String url = prop.getProperty("url");
	System.out.println(url);
	Thread.sleep(2000);
	
	
	String browser = prop.getProperty("browser");
	System.out.println(browser);
	Thread.sleep(2000);
	
	
	// Now we are validating the browser and then changing in the config file to verify
	
	if(browser.equals("chrome"))
	{
	System.setProperty("webdriver.chrome.driver","F:\\chromedriver_win32\\chromedriver.exe");
	
	driver = new ChromeDriver();
	Thread.sleep(4000);
	
	driver.manage().window().maximize();
	Thread.sleep(4000);
	
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	else
	{
	System.setProperty("webdriver.gecko.driver","C:\\Users\\Shubham\\Downloads\\geckodriver-v0.26.0-win32\\geckodriver.exe");
	
	driver = new FirefoxDriver();
	Thread.sleep(4000);
	
	driver.manage().window().maximize();
	Thread.sleep(4000);
	
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	
	
	//Calling the url from config file
	driver.get(url);
	Thread.sleep(4000);
	
	
	//Now calling the xpath from the config file
	
	driver.findElement(By.xpath(prop.getProperty("firstname_xpath"))).sendKeys(prop.getProperty("firstname"));
	Thread.sleep(4000);
	
	driver.findElement(By.xpath(prop.getProperty("lastname_xpath"))).sendKeys(prop.getProperty("lastname"));
	Thread.sleep(4000);
	
	driver.findElement(By.xpath(prop.getProperty("city_xpath"))).sendKeys(prop.getProperty("cityname"));
	Thread.sleep(4000);
	
	 
	Select state = new Select(driver.findElement(By.xpath(prop.getProperty("state_xpath"))));
	 state.selectByVisibleText("Indiana");
	 Thread.sleep(4000);
	 
	 
	}
	
	}