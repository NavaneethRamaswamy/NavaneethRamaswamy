package week3.day2.assignments;

import java.util.Scanner;

public class assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		palindrome();
	}
public static void palindrome() {
	// TODO Auto-generated method stub
	Scanner scan = new Scanner(System.in);
	String word = scan.next();
	char[] char1 = word.toCharArray();
	char[] char2= new char[char1.length];
	int j=char1.length-1;
	for (int i=0;i<=(char1.length-1);i++) {
		char2[i]=char1[j];
		j=j-1;
	}
	

		
}
	
}
