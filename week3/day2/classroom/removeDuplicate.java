package week3.day2.classroom;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class removeDuplicate {

	public static void main(String[] args) {

	    removeDuplicates();
		sortList();
	}
	
	public static void removeDuplicates() {
		String given ="PayPal India";
		char[] chars = given.toCharArray();
		Set<Character> myset = new LinkedHashSet<Character>();
		System.out.print("The duplicate element is: ");
		for (Character i : chars) {
			if(myset.add(i)==false)
				System.out.print(i + " ");
		}
		System.out.print('\n');
		for (Character i : myset) {
			if (i!=' ')
			System.out.print(i);
		}
	}

	public static void sortList() {
		String[] input = {"HCL","Wipro","Aspire Systems","CTS"};
		int arrsize = input.length;
		Arrays.sort(input);
		for (int i=arrsize-1; i>=0; i--) {
			System.out.print(input[i] );
			if (i>0) {
				System.out.print(",");
			}
		}
	}
}

