package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Crmslogin {

	public static void main(String[] args) {

			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			//Launch the URL
			driver.get("http://leaftaps.com/opentaps/");
			
			//Maximize it
			driver.manage().window().maximize();
			
			//Enter Credentials..
			driver.findElement(By.id("username")).sendKeys("DemoCSR");
			driver.findElement(By.id("password")).sendKeys("crmsfa");
			
			//Click Login decorativeSubmit
			driver.findElement(By.className("decorativeSubmit")).click();
			
			//Click on  CRMS/FA
			driver.findElement(By.xpath("//*[@id=\'button\']/a/img")).click();
			

			//Click on  Create a Contact
			driver.findElement(By.linkText("Create Lead")).click();
			
			//Enter Lead Info..
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys("NavTech");
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Navaneeth");
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Krishnan");
			
		    WebElement source_dd = driver.findElement(By.id("createLeadForm_dataSourceId"));
			Select ddselect = new Select(source_dd);
	
			//	    System.out.println(ddselect.getOptions());
			//ddselect.selectByVisibleText("Partner");
									
			driver.findElement(By.className("smallSubmit")).click();
			
			
			System.out.println("Created a Lead successfully");
			System.out.println(driver.getTitle());
			
			// Browser Close
			driver.close();
			
		}
	}


