package practice;

import java.util.LinkedHashSet;
import java.util.Set;

public class DP4_LCS_Memoization {

	static String s1;
	static String s2;

	static Set<Character> subs = new LinkedHashSet<>();

	static int[][] lookup;

	public static int lcs(int n, int m) {

		int lcs;
		if (n == 0 || m == 0)
			return 0;

		if (lookup[n - 1][m - 1] != -1) {
			System.out.println("Already Computed For lcs(" + n + "," + m + ")");
			return lookup[n - 1][m - 1];
		}

		System.out.println("Recursing to find lcs(" + n + "," + m + ")");
		if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
			System.out.println(s1.charAt(n - 1));
			subs.add(s1.charAt(n - 1));
			lcs = 1 + lcs(n - 1, m - 1);
		} else {
			lcs = Math.max(lcs(n, m - 1), lcs(n - 1, m));
		}
		lookup[n - 1][m - 1] = lcs;
		return lcs;
	}

	public static void main(String args[]) {

		s1 = "AGGTAB";
		s2 = "GXTXAYB";

		lookup = new int[s1.length()][s2.length()];
		for (int i = 0; i < s1.length(); i++)
			for (int j = 0; j < s2.length(); j++)
				lookup[i][j] = -1;

		System.out.println(lcs(s1.length(), s2.length()));
		System.out.println(subs);
	}

}