package week4.day2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyActions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		draggable(driver);
		droppable(driver);
		resizable(driver);
		selectable(driver);

	}
	
public static void draggable(WebDriver driver) {
	
	driver.get("https://jqueryui.com/draggable");
	Actions action = new Actions(driver);
	WebElement frameElement = driver.findElement(By.xpath("//*[@id='content']/iframe"));
	driver.switchTo().frame(frameElement);
	WebElement dragElement = driver.findElement(By.id("draggable"));
	//action.dragAndDropBy(dragElement, 300, 50).perform();
	action.clickAndHold(dragElement).moveByOffset(60,50).perform();
	System.out.println("Element is moved..!");
	
	driver.switchTo().parentFrame();
	driver.quit();

}

///----------------------------------------------------------------------------//

public static void droppable(WebDriver driver) {
	driver.get("https://jqueryui.com/droppable");
	Actions action = new Actions(driver);
	WebElement frameElement = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
	driver.switchTo().frame(frameElement);
	WebElement srcElement = driver.findElement(By.id("draggable"));
	WebElement destElement = driver.findElement(By.id("droppable"));
	action.dragAndDrop(srcElement, destElement).perform();
	
	driver.switchTo().parentFrame();
	driver.quit();
	
}

///----------------------------------------------------------------------------//

public static void resizable(WebDriver driver) {
	
	driver.get("https://jqueryui.com/resizable");
	Actions action = new Actions(driver);
	WebElement frameElement = driver.findElement(By.xpath("//*[@id='content']/iframe"));
	driver.switchTo().frame(frameElement);
	WebElement dragElement = driver.findElement(By.xpath("//div[contains(@class,'diagonal')]"));
	action.clickAndHold(dragElement).moveByOffset(60,-50).release().build().perform();
	System.out.println("Element is moved..!");
	
	driver.switchTo().parentFrame();
	driver.quit();

}

///----------------------------------------------------------------------------//
public static void selectable(WebDriver driver) {
	
	driver.get("https://jqueryui.com/selectable");
	Actions action = new Actions(driver);
	WebElement frameElement = driver.findElement(By.xpath("//*[@class='demo-frame']"));
	driver.switchTo().frame(frameElement);
	
	List<WebElement> list = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
	
	action.keyDown(Keys.CONTROL).click(list.get(1))
								.click(list.get(3))
								.keyUp(Keys.CONTROL)
								.build()
								.perform();
	
	driver.switchTo().parentFrame();
	driver.quit();
}
}
