package week1.day1.classromm;

public class Factorial {

	public static int factorial(int f)
	{ 
		int fact=1;
		if (f>0)
		{
			fact=f*(factorial(f-1));
		}
		return fact;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int findfact=9;
        System.out.println("The factorial of " + findfact + ": "+ factorial(findfact));
	}

}
