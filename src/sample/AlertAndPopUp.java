package sample;



	import java.util.concurrent.TimeUnit;
    import org.openqa.selenium.Alert;
    import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	
	public class AlertAndPopUp {


		public static void main(String args[]) throws InterruptedException
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
			driver.get("https://www.rediff.com/");
			
			Thread.sleep(5000);
			
			//Click on Sign in 
			
			driver.findElement(By.linkText("Sign in")).click();
		       Thread.sleep(4000);
		       
		  //Now without entering any details just click on sign in button, it will display alert popup
		       
		       driver.findElement(By.xpath("//input[@name='proceed']")).submit();
		       Thread.sleep(4000);
		       
		   // Now to handle alert pop up text we have a method called (switchTo().alert());
		     // To handle alert We have to use Alert API
		       
		        Alert alert = driver.switchTo().alert();
		       
		        String text = alert.getText();
		       
		        System.out.println("The alert text is :"+text);
		        
		       // For validating whether the text is correct or not we can use equals to compare with the string
		        
		        if(text.equals("Please enter a valid user name"))
		        {
		        	System.out.println("The text is correct");
		        }
		        else
		        {
		        	System.out.println(" The text is incorrect");
		        }
		        Thread.sleep(4000);
                
		        // To click on ok button we have to use accept method 
		        
		           alert.accept();
		           Thread.sleep(4000);
		       
		       // For some pop up we have cancel button, for handling that cancel button , we have to use dismiss method
		           
		           //alert.dismiss();
		           
		           //Thread.sleep(4000);
}
}
	