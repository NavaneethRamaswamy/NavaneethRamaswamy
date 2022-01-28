package week4.day1.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundFrame {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(cOptions);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		leafFrames(driver);

	}
	public static void leafFrames(WebDriver driver) throws IOException{
		
		driver.get("http://leafground.com/pages/frame.html");
		
	//1.Take the the screenshot of the click me button of first frame
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@src=\"default.html\"]"));
		TakesScreenshot ts = (TakesScreenshot)frameElement;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./test-output/screenshot/leafgroundframe.jpg");
		FileUtils.copyFile(src, dest);
		System.out.println("Screenshot of 'ClickMe' button is taken");
	
	//	2.Find the number of frames
	//  - find the Elements by tagname - iframe
	//  - Store it in a list
		List<WebElement> frameElements = driver.findElements(By.xpath("//iframe"));  
		System.out.println("Total number of Frames is :"+ frameElements.size());
		  
		
	}
}
