package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class eRailSort {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		Launch the browser
//		Launch the URL - https://erail.in/
		driver.get("https://erail.in");
		
//		Uncheck the check box - sort on date
		driver.findElement(By.xpath("//input[@id='chkSelectDateOnly']")).click();
		
//		clear and type in the source station 
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).clear();
		driver.findElement(By.xpath("//input[@id='txtStationFrom']")).sendKeys("MAS",Keys.TAB);
		
			
//		clear and type in the destination station
		driver.findElement(By.xpath("//input[@id='txtStationTo']")).clear();
		driver.findElement(By.xpath("//input[@id='txtStationTo']")).sendKeys("MTP",Keys.TAB);
		
		
		Thread.sleep(2000);
//		Find all the train names using xpath and store it in a list
		int rCount = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr")).size();
		List<String> trainNames=new ArrayList<String>();
		
		for(int i=1;i<=rCount;i++)
		{
			String names = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]")).getText();
			trainNames.add(names);
		}
		
//		Use Java Collections sort to sort it and then print it
		Collections.sort(trainNames);
		
		for (String string : trainNames) {
			System.out.println(string);
		}
		
		driver.close();
		driver.quit();
	}
	}


