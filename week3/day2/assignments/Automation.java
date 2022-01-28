package week3.day2.assignments;

public class Automation  extends MultipleLangauge implements Language, TestTool  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

	public void iselenium() {
		// TODO Auto-generated method stub
		System.out.println("From Interface:TestTool: Selenium");
	}

	public void ijava() {
		// TODO Auto-generated method stub
		System.out.println("From Interface TestTool:Java");
	}

	@Override
	public void aruby() {
		// TODO Auto-generated method stub
		System.out.println("From Abstract method");
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
	}

}


