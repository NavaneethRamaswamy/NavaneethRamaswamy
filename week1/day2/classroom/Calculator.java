package week1.day2.classroom;

public class Calculator {

	public int add(int a,int b)
	{
		return(a+b);
	}
	
	public int sub(int a, int b) {
		return(a-b);
	}
	
	public double multi(int a, int b) {
		return(a*b);
	}
	
	public double div(double a, double b) {
		return (a/b);
	}
	

	
	public static void main(String[] args) {
		Calculator calc= new Calculator();
		System.out.println(calc.add(10, 20));
		System.out.println(calc.sub(30, 20));
		System.out.println(calc.multi(10, 2));
		System.out.println(calc.div(100, 23.4));


	}

}
