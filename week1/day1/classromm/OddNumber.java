package week1.day1.classromm;

public class OddNumber {

	public static void verifyodd(int odd)
	{
		if (odd%2>0)
		{
			System.out.println("The given number"+odd + "is an Odd number");
		}
		else {
			System.out.println("The given number"+odd + "is NOT an Odd number");
		}
	}

	
	public static void main(String[] args) {
		int findodd=9;
		verifyodd(findodd);

	}

}
