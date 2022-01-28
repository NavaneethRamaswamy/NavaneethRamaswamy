package week2.day2.assignments;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateFaceBookAcc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\E drive backup\\Learnings\\Drivers\\Chromewebdriver\\chromedriver_96\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		
		driver.findElement(By.xpath("//a[contains(text(),'Create New Account')]")).click();
		
		//div[@id='fullname_field']//div[1]//input
		driver.findElement(By.xpath("//div[@id='fullname_field']//div[1]//input")).sendKeys("TestFirst");
		driver.findElement(By.xpath("//div[@id='fullname_field']//div[2]//input")).sendKeys("TestSurName");
		//div[@id='reg_form_box']/div[2]//div/div/input
		driver.findElement(By.xpath("//div[@id='reg_form_box']/div[2]//div/div/input")).sendKeys("nav+1@gmail.com");
		//select[@id='day']
		Select daydd= new Select(driver.findElement(By.id("day")));
		daydd.selectByValue("27");
		Select daydm= new Select(driver.findElement(By.id("month")));
		daydm.selectByValue("Feb");		
		Select daydy= new Select(driver.findElement(By.id("year")));
		daydy.selectByValue("1990");		
		
		
	}

}
