package week1.day2.classroom;

public class Armstrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=372;
		int orginal=i;
		int sum=0;
		while (i>0)
		{
			int org=i%10;
			sum=(org*org*org)+sum;
			i=i/10;
		}
		if (sum==orginal)
			System.out.println("Given number is an Armstrong number");
		else
			System.out.println("Given number is NOT an Armstrong number");
	}

}
