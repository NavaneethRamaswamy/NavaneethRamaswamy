package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		// 1. Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions builder = new Actions(driver);

		// 2. Go to Mens Fashion
		WebElement mFashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		builder.moveToElement(mFashion).click().perform();

		// 3. Go to Sports Shoes
		WebElement shirt = driver.findElement(By.xpath("//span[text()='Sports Shoes']"));
		builder.moveToElement(shirt).click().perform();

		// 4. Get the count of the sports shoes
		String shoeCount = driver.findElement(By.xpath("//span[contains(@class,'category-count')]")).getText();
		System.out.println("Shoe Count: " + shoeCount);

		// 5. Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();

		// 6. Sort by Low to High
		driver.findElement(
		// By.xpath("//div[@class='sort-drop clearfix']/i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
		By.xpath("//span[contains(@class,'sort-label')]")).click();
		
		driver.findElement(By.xpath("//li[@class='search-li' and @data-index='1']")).click();

		// 8.Select the price range (900-1200)
		WebElement MinValue = driver.findElement(By.name("fromVal"));
		MinValue.clear();
		MinValue.sendKeys("900");

		WebElement MaxVal = driver.findElement(By.name("toVal"));
		MaxVal.clear();
		MaxVal.sendKeys("1200");

		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@data-filtername='Color_s']")).click();

		// 9.Filter with color Navy 
		driver.findElement(By.xpath("//div[@class='sdCheckbox filters-list ']/label[@for='Color_s-Navy']")).click();
		Thread.sleep(3000);

		WebElement firstShoe = driver.findElement(By.xpath("//div[@data-js-pos='0']"));
		builder.moveToElement(firstShoe).perform();

		// 12. click QuickView button
		driver.findElement(By.xpath("//div[contains(text(),'Quick View')]")).click();

		String price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();

		String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();

		// 13. Print the cost and the discount percentage
		System.out.println("Shoe Cost: " + price + " Discount: " + discount);

		// Find shoe image
		WebElement shoeToTakeScreenShot = driver.findElement(By.xpath("//li/img[@class='cloudzoom']"));

		// 14. Take the snapshot of the shoes.
		File source = shoeToTakeScreenShot.getScreenshotAs(OutputType.FILE);
		File destination = new File("./images/FirstShoe.png");
		FileUtils.copyFile(source, destination);

		// close current window
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();

		// close browser
		driver.close();

	}

}
