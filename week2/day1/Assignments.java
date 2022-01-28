package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignments {

	public static void main(String[] args) {
		// Browser SetUp
		WebDriver driver = browserSetup_Login();
		
		//TestCase1:
//		testCase1_CreateContact(driver);
		
		//TestCase2:
 //      testCase2_FindContacts(driver);
		
		//TestCase2:
        testcase3_CreateLead(driver);
        
		// Driver close..
		driver.quit();
	}

	public static WebDriver browserSetup_Login() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Launch the URL
		driver.get("http://leaftaps.com/opentaps/");
		
		//Maximize it
		driver.manage().window().maximize();
		
		//Enter Credentials..
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//Click Login decorativeSubmit
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on  CRMS/FA
		driver.findElement(By.xpath("//*[@id=\'button\']/a/img")).click();
		return driver;
	}

	public static void testCase1_CreateContact(WebDriver driver) {
		//Click on  Create a Contact
		driver.findElement(By.linkText("Create Contact")).click();
		
		//Enter Lead Info..
		driver.findElement(By.id("firstNameField")).sendKeys("NavContact3");
		driver.findElement(By.id("lastNameField")).sendKeys("Krishnan");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("navtest@gmail.com");
		
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println("Created a Contact successfully");
		
		//Verification
		String SavedFirstname = driver.findElement(By.id("viewContact_firstName_sp")).getText();
		System.out.println("Saved First name of Contact is : " + SavedFirstname);
		System.out.println("Page Title of created Contact is: " + driver.getTitle());
		
		// Navigate back to Home
		driver.findElement(By.linkText("My Home")).click();

	}

	public static void testCase2_FindContacts(WebDriver driver) {
		//Click on  Create a Contact
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Find Contacts")).click();
		driver.findElement(By.linkText("Email")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("navtest@gmail.com");
		driver.findElement(By.xpath("//button[@class='x-btn-text'][text()='Find Contacts']")).click();
		
		// Navigate back to Home
		driver.findElement(By.linkText("My Home")).click();
		
	}
	
	public static void testcase3_CreateLead(WebDriver driver) {
			//Click on  Create a Contact
		driver.findElement(By.linkText("Create Lead")).click();
		//Enter Lead Info..
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("NavLead2");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("NavLead");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("01/6/90");
		
		WebElement currencydd = driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select selectcurrencydd = new Select(currencydd);
		
		selectcurrencydd.selectByValue("INR");
		
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println("Created a Lead successfully");
		
		//Verification
		String SavedFirstname = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		System.out.println("Saved Lead name is : " + SavedFirstname);
		System.out.println("Page Title of Created Lead is: " + driver.getTitle());
		
		// Navigate back to Home
		driver.findElement(By.linkText("My Home")).click();
	
		
		
	}

	}
