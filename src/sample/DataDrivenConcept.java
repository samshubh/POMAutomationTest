package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.test.util.Xls_Reader;



public class DataDrivenConcept {
	
	 public static WebDriver driver;
	
	  
	public static void main(String args[]) throws InterruptedException
	{

        System.setProperty("webdriver.chrome.driver","F:\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("https://www.kiposcollective.com/#/");  
		
		 driver.findElement(By.xpath("//div[@class='col-lg-4 col-xl-4 col-md-5 col-sm-4 col-8 sign-right order-aline-2 ng-scope']//span[@class='btn btn-login'][contains(text(),'Signup')]")).click();
		 
		   Thread.sleep(5000);
		   
		   Xls_Reader reader = new Xls_Reader("C:\\Users\\Shubham\\eclipse-workspace\\NuqiProject\\src\\com\\testdata\\TestData.xlsx");
		   
		   //etting rowcount here
	       int rowCount = reader.getRowCount("SignUpData");
	       
	      // here we can add the new column in excel sheet 
	       
	        reader.addColumn("SignUpData", "Status");
	        
	        // Here we can add the new sheet
	        
	         reader.addSheet("Shubham");
	         
	          int colCount = reader.getColumnCount("SignUpData");
	          
	           System.out.println(colCount);
	           
	        for(int rowNum=2;rowNum<=rowCount;rowNum++)
	        {
	        String name =reader.getCellData("SignUpData", "Name", rowNum);
	           System.out.println(name);
	           
	           String email =reader.getCellData("SignUpData", "Email", rowNum);
	           System.out.println(email);
	             
	           String password =reader.getCellData("SignUpData", "Password", rowNum);
	           System.out.println(password);
	           
	           String confirmpassword =reader.getCellData("SignUpData", "ConfirmPassword", rowNum);
	           System.out.println(confirmpassword);
	           
	         driver.findElement(By.id("signup-fullname")).clear();
	         driver.findElement(By.id("signup-fullname")).sendKeys(name);
	  		 Thread.sleep(4000);
	  		
	  		driver.findElement(By.id("signup-email")).clear();
	  		driver.findElement(By.id("signup-email")).sendKeys(email);
	  		 Thread.sleep(4000);
	  		
	  		driver.findElement(By.id("password")).clear();
	  		driver.findElement(By.id("password")).sendKeys(password);
	  		 Thread.sleep(4000);
	  		
	  		driver.findElement(By.id("changepwd-confirm-password")).clear();
	  		driver.findElement(By.id("changepwd-confirm-password")).sendKeys(confirmpassword);
	  		 Thread.sleep(4000);
	  		 
	  		reader.setCellData("SignUpData", "Status", rowNum, "Pass");
	             
	}
	        
	        driver.quit();

}
}