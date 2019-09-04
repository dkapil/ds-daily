package practice;

import java.util.ArrayList;
import java.util.List;

public class BT_GenerateSubsequence {

	static int n;

	static String str;

	static List<String> combs = new ArrayList<>();

	public static void main(String[] args) {
		str = "abc";
		n = str.length();
		printSubSequence(-1, "");
		System.out.println(combs);
	}

	private static void printSubSequence(int index, String current) {
		if (index == n) {
			System.out.println("Index is equal to String length");
			return;
		}
		combs.add(current);
		System.out.println(current + " index=" + index);

		for (int i = index + 1; i < n; i++) {
			current = current + str.charAt(i);
			printSubSequence(i, current);
			System.out.println("Backtracking to " + index);
			current = current.substring(0, current.length() - 1);
			System.out.println("Updating current to " + current);
		}

	}
}