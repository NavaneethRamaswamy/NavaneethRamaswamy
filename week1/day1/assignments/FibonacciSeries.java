package week1.day1.assignments;

public class FibonacciSeries {
	
	
	public static void findFibonacci(int f)
	 {
		int s0=0,s1=1;
		for (int i=2;i<=f;i++)
		{
		 int s2=s0+s1;
		  System.out.print(s2+",");
	      s0=s1;
	      s1=s2;
		}
	  
	 }
	public static void main(String[] args) {
	int seriesCount=9;	
	System.out.print("0,"+ "1,");
	findFibonacci(seriesCount);
	}

}
