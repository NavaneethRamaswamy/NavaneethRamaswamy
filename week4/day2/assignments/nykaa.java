package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//			1) Go to https://www.nykaa.com/
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriver driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
			driver.get("https://www.nykaa.com/");
			
//			2) Mouse over on Brands and Search L'Oreal Paris
			Actions action = new Actions(driver);
			WebElement webElement = driver.findElement(By.xpath("//a[text()='brands']"));
			action.moveToElement(webElement).perform();
			driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris");
			Thread.sleep(2000);
			
//			3) Click L'Oreal Paris
			driver.findElement(By.linkText("L'Oreal Paris")).click();
			Thread.sleep(2000);
			
//			4) Check the title contains L'Oreal Paris(Hint-GetTitle)
			String text = driver.findElement(By.xpath("//div[@id=\"title\"]/h1")).getText();
			if (text=="L'Oreal Paris") {
				System.out.println("Title is correctly matched to L'Oreal Paris");
			}
			Thread.sleep(2000);
			
//			5) Click sort By and select customer top rated
			driver.findElement(By.xpath("//div[@id=\"filter-sort\"]//div")).click();
			driver.findElement(By.xpath("//input[contains(@id,'customer')]")).click();
	
			
//			6) Click Category and click Hair->Click haircare->Shampoo
			driver.findElement(By.id("first-filter")).click();
			driver.findElement(By.xpath("//li/div/span[contains(text(),'Hair')]")).click();
			driver.findElement(By.xpath("//li/div/span[contains(text(),'Hair Care')]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Shampoo')]/ancestor::label")).click();
			
			
//			7) Click->Concern->Color Protection
			
			driver.findElement(By.xpath("//span[contains(text(),'Concern')]/parent::div")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Color Protection')]/ancestor::label")).click();
			
//			8)check whether the Filter is applied with Shampoo
			String filterText = driver.findElement(By.xpath("//span[contains(text(),'Color Protection')][@class='filter-value']")).getText();
			if (filterText=="Color Protection")
			System.out.println("Color protection filter applied with Shampoo");

//			9) Click on L'Oreal Paris Colour Protect Shampoo
			driver.findElement(By.xpath("//div[contains(@class,'productWrapper')][1]")).click();
			
			
//			10) GO to the new window and select size as 175ml
			Set<String> windowHandles = driver.getWindowHandles();
			List<String>windows=new ArrayList<String>(windowHandles);
			driver.switchTo().window(windows.get(1));
			WebElement wdropdown = driver.findElement(By.xpath("//div[@class='css-11wjdq4']/select[@title='SIZE']"));
			Select dropdown=new Select(wdropdown);
			dropdown.selectByVisibleText("175ml");
			
//			11) Print the MRP of the product
			String MRP = driver.findElement(By.xpath("//span[text()='MRP:']//following-sibling::span")).getText();
			System.out.println("MRP of the L'Oreal Shampoo - 175 ml is: "+ MRP);
			
//			12) Click on ADD to BAG
			driver.findElement(By.xpath("//div[@class='css-1rn9gza']//span[@class='btn-text']")).click();
			
//			13) Go to Shopping Bag 
			driver.findElement(By.xpath("//button[@class='css-5s18zx eoh7kvv0']")).click();
			
//			14) Print the Grand Total amount
			driver.switchTo().frame(0);
			String grandTotal = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
			System.out.println("Grand total amount: "+grandTotal);
			
//			15) Click Proceed
			driver.findElement(By.xpath("	//span[text()='PROCEED']")).click();
		
					
//			16) Click on Continue as Guest
			driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
			
			
//			17) Check if this grand total is the same in step 14
			String grandTotalCart = driver.findElement(By.xpath("//div[contains(@class,'grand-total')]/div/span")).getText();
			
			if (grandTotalCart==grandTotal)
				System.out.println("Both the Grand totals are same");
			else 
				System.out.println("Both the Grand totals are NOT same");
			
//			18) Close all windows
		//	driver.switchTo().defaultContent();
		//  driver.close();
//		
		
	}

}
