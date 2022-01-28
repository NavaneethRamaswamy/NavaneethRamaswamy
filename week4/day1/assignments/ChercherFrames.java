package week4.day1.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChercherFrames {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(cOptions);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		iFrames(driver);

	}

	public static void iFrames(WebDriver driver) throws IOException  {

//	    Step1: Load ServiceNow application URL 
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("NavTopics");
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id='a']")).click();
		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();
		driver.switchTo().frame("frame2");
		WebElement webelement = driver.findElement(By.id("animals"));
		Select select = new Select(webelement);
		select.selectByValue("avatar");
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./test-output/screenshot/iframe.jpg");
		FileUtils.copyFile(src, dest);
		System.out.println("All the 3 frames navigated successfuly");
	}

}
