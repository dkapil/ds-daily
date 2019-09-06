package practice;

import java.util.LinkedHashSet;
import java.util.Set;

public class DP4_LCS_Tabulation {

	static String s1;
	static String s2;

	static Set<Character> subs = new LinkedHashSet<>();

	static int[][] lookup;

	public static int lcs(int n, int m) {

		int[][] lcsmat = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {

				if (i == 0 || j == 0) {
					lcsmat[i][j] = 0;
				} else {
					if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
						System.out.println(s1.charAt(i - 1));
						subs.add(s1.charAt(i - 1));
						lcsmat[i][j] = 1 + lcsmat[i - 1][j - 1];
					} else {
						lcsmat[i][j] = Math.max(lcsmat[i][j - 1], lcsmat[i - 1][j]);
					}
				}
			}
		}

		return lcsmat[n][m];
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