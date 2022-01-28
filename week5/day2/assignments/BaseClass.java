package week5.day2.assignments;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.beust.jcommander.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	
	@Parameters ({"url","username","password" })
	@BeforeMethod 

	public void login(String url,String userName,String password){
		
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
	
	}
	
	@AfterMethod
	public void logoutNClose() {
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.quit();

	}
	
	// @DataProvider  (name="LeadData", parallel=true)
	
//	public String[][] myLeadData() {
//
//		String a[][] = new String[2][3] ;
//			a[0][0] = "tcs";
//			a[0][1] = "Navaneeth" ;  
//			a[0][2] = "Ramaswamy" ;
//			
//			a[0][0] = "Aspire" ;
//			a[0][1] = "Mani" ;
//			a[0][2] = "Bharathi" ;
//	
//			return a;
//   }
	
	@DataProvider (name="ExcelLeadData")
	public String[][] createLeadData() throws IOException { 
		DataFromExcel dataFromExcel = new DataFromExcel();
		String[][] excelLeadData = dataFromExcel.dataFromExcel();
		return excelLeadData;
	}
	
}


