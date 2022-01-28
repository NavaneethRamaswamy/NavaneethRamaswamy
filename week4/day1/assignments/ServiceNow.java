package week4.day1.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(cOptions);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		servicenow(driver);

	}

	public static void servicenow(WebDriver driver) throws InterruptedException, IOException {

//	    Step1: Load ServiceNow application URL 
		driver.get("https://dev84629.service-now.com\r\n");
		Thread.sleep(2000);
//		Step3: Enter password 
//		Step4: Click Login
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Abcd.1234");
		driver.findElement(By.id("sysverb_login")).click();
	
//		Step5: Search “incident “ Filter Navigator and select
		driver.switchTo().parentFrame();
		
		driver.findElement(By.id("filter")).sendKeys("incidents");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//ul[contains(@class,'sn-widget-list')]/li[10]//div/a//div/div")).click();
		
//		Step6: Click “All” to list All incidents
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//span[@id='incident_breadcrumb']/a/b")).click();
		
//		Step7: Click New button
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		
//		Step8: Select a value for Caller and Enter value for short_description
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']/span")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		ArrayList<String> winarray1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(winarray1.get(1));
		
		// click 'All' link to list all Callers..
		driver.findElement(By.xpath("//span[@id='sys_user_breadcrumb']//b")).click();
		//select first Caller from the list..
		driver.findElement(By.xpath("//a[@class='glide_ref_item_link']")).click();
		
		driver.switchTo().window(winarray1.get(0));

		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("NavIncident2");
		
		String incidentid = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(incidentid);
		
//		Step10: Click on Submit button
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		Thread.sleep(2000);
		
//		Step 11: Search the same incident number in the next search screen as below
		
		WebElement sel = driver.findElement(By.xpath("//select[contains(@role,'listbox')]"));
		Select selector = new Select(sel);
		selector.selectByValue("number");
		driver.findElement(By.xpath("//span[contains(text(),'search')]/following-sibling::input")).sendKeys(incidentid + Keys.ENTER);
	
//		Step12: Verify the incident is created successful and take snapshot of the created incident.
		Thread.sleep(1000);
		String text = driver.findElement(By.xpath("//table[@id='incident_table']/tbody/tr/td[3]/a")).getText();
	
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./test-output/screenshot/CreateIncident.jpg");
		FileUtils.copyFile(src, dest);
		System.out.println("Screenshot of the Incident is taken");
		
		if (text.equals(incidentid))
			System.out.println("Incident successfully created");
		else
			System.out.println("Incident failed to create");

	}
}

