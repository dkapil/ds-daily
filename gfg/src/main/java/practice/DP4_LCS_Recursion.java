package practice;

import java.util.LinkedHashSet;
import java.util.Set;

public class DP4_LCS_Recursion {

	static String s1;
	static String s2;

	static Set<Character> subs = new LinkedHashSet<>();

	public static int lcs(int n, int m) {

		if (n == 0 || m == 0)
			return 0;

		System.out.println("Recursing to find lcs(" + n + "," + m + ")");

		if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
			System.out.println(s1.charAt(n - 1));
			subs.add(s1.charAt(n - 1));
			return 1 + lcs(n - 1, m - 1);
		} else {
			return Math.max(lcs(n, m - 1), lcs(n - 1, m));
		}
	}

	public static void main(String args[]) {

		s1 = "ABCDGH";
		s2 = "AEDFHR";

		System.out.println(lcs(s1.length(), s2.length()));
		System.out.println(subs);
	}

}