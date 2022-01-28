package week5.day1.assignments;

import org.testng.annotations.Test;

public class testNGAttributes {
	

	@Test(alwaysRun=true)
	public void alwayesRun()
	{
		System.out.println("Executed always");
	}
	@Test
	public void level1()
	{
		System.out.println("In Level-1");
	}

	@Test(dependsOnMethods = "level1")
	public void level2()
	{
		System.out.println("In Level=2 based on Level1");
	}
	
	@Test(priority =2, groups= "SmokeTest")   
	public void priority2() 
	{ 
	   
	   System.out.println("In Priority 2 Testcase"); 
	} 
	
	@Test(priority =1, groups= "SmokeTest")  
	public void testCase10() 
	{ 
		   
		   System.out.println("In Priority 1 Testcase"); 
	} 
	
	@Test(description = "Decription Test")
	public void descriptive()
	{
		System.out.println("In Descriptive Test case");
	}
	
	@Test(enabled = true)
	public void enabled()
	{
		System.out.println("In enabled Test case");
	}

	
	@Test(invocationCount=3)
	public void repeat3()
	{
		System.out.println("Repeat mode testcase");
	}
	
	@Test(timeOut = 500)  
	public void timeout() throws InterruptedException 
	{ 
	   Thread.sleep(3000); 
	   System.out.println("In Timeout case"); 
	} 
	

	

}

