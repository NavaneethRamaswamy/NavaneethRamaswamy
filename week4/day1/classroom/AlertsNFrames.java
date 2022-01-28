package week4.day1.classroom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsNFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		// Launch the Chrome Browser
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(cOptions);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//	frameSwitch(driver);
		tabSwitch(driver);
	}

	public static void  tabSwitch(ChromeDriver driver) {
		driver.get("https://www.irctc.co.in");
		
		driver.manage().window().maximize();	
		
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'FLIGHTS')]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		for (String string : windowHandles) {
			System.out.println(string);
		}
		ArrayList<String> arrayList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(arrayList.get(1));
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(arrayList.get(0));
		System.out.println(driver.getTitle());
		
		
		
		
		
		
		
		
	}
	
	public static void frameSwitch(ChromeDriver driver) {
		// Load the URL
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		
		driver.manage().window().maximize();
		
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
		
		driver.findElement(By.xpath("//body[@contenteditable='false']/button")).click();
		driver.switchTo().alert().sendKeys("Nav");
		driver.switchTo().alert().accept();
	//	driver.switchTo().defaultContent();
		String s = driver.findElement(By.xpath("//h2")).getText();
		System.out.println(s);
	}

}
