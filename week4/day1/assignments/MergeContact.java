package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(cOptions);

	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		mergeContact(driver);
		

	}
	public static void mergeContact(ChromeDriver driver) throws InterruptedException {
		
		driver.get("http://leaftaps.com/opentaps/");
// 1.2. Login
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
// 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
// 4. Click on CRM/SFA Link
		driver.findElement(By.xpath("//*[@id=\'button\']/a/img")).click();
//	5. Click on contacts Button
		driver.findElement(By.linkText("Create Contact")).click(); 	
//		 * 6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
//		 * 7. Click on Widget of From Contact
		driver.findElement(By.xpath("//a[contains(@href,'partyIdFrom')]")).click();
//		 * 8. Click on First Resulting Contact
		Set<String> windowHandles1 = driver.getWindowHandles();
		ArrayList<String> winarray1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(winarray1.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//a[1]")).click();
		driver.switchTo().window(winarray1.get(0));
//		 * 9. Click on Widget of To Contact
		driver.findElement(By.xpath("//a[contains(@href,'partyIdTo')]")).click();
//		 * 10. Click on Second Resulting Contact
		Set<String> windowHandles2 = driver.getWindowHandles();
		ArrayList<String> winarray2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(winarray2.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/following::a[1]")).click();
		driver.switchTo().window(winarray2.get(0));
//		 * 11. Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
//		 * 12. Accept the Alert
		driver.switchTo().alert().accept();
//		 * 13. Verify the title of the page
		String title = driver.getTitle();
		if (title.endsWith("CRM"))
			System.out.println("Pass");
		else
			System.out.println("False");
		
		driver.close();
	}

}
