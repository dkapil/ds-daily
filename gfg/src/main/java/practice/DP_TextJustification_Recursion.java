package practice;

import java.util.Arrays;
import java.util.List;

public class DP_TextJustification_Recursion {

	static List<String> words;

	static int pageWidth = 10;

	static int n;

	static int[][] lc;

	static int[] p;

	private static double cost(int i) {

		if (i == 0)
			return 0;

		double[] allcosts = new double[i];

		for (int j = i; j >= 1; j--) {
			allcosts[j - 1] = cost(j - 1) + lc[j][i];
		}

		return min(allcosts, i);
	}

	private static double min(double[] allcosts, int row) {
		int minxIndex = 0;
		double min = allcosts[0];

		for (int i = 0; i < allcosts.length; i++) {
			double j = allcosts[i];

			if (j < min) {
				minxIndex = i;
				min = j;
			}
		}
		p[row] = minxIndex + 1;
		return min;
	}

	public static void main(String[] args) {

//		words = Arrays.asList("a", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog");
		words = Arrays.asList("aaa", "bb", "cc", "ddddd");

		n = words.size();

		int[] l = new int[n];

		for (int i = 0; i < l.length; i++) {
			l[i] = words.get(i).length();
		}

		lc = computelc(l, n, 6);

		p = new int[n + 1];

		cost(n);

		System.out.println("************");
		for (int i = 0; i < p.length; i++) {
			System.out.print(p[i] + ",");
		}
	}

	static int[][] computelc(int[] l, int n, int M) {
		// extras[i][j] will have number of extra spaces if words from i
		// to j are put in a single line
		int extras[][] = new int[n + 1][n + 1];

		// lc[i][j] will have cost of a line which has words from
		// i to j
		int lc[][] = new int[n + 1][n + 1];

		// calculate extra spaces in a single line. The value extra[i][j]
		// indicates extra spaces if words from word number i to j are
		// placed in a single line
		for (int i = 1; i <= n; i++) {
			extras[i][i] = M - l[i - 1];
			for (int j = i + 1; j <= n; j++)
				extras[i][j] = extras[i][j - 1] - l[j - 1] - 1;
		}

		// Calculate line cost corresponding to the above calculated extra
		// spaces. The value lc[i][j] indicates cost of putting words from
		// word number i to j in a single line
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				if (extras[i][j] < 0)
					lc[i][j] = Integer.MAX_VALUE;
				else if (j == n && extras[i][j] >= 0)
					lc[i][j] = 0;
				else
					lc[i][j] = extras[i][j] * extras[i][j];
			}
		}
		return lc;
	}

	private static int badness(int splitFrom, int splitTo) {
		int cost;
		int wordsLength = 0;

		List<String> subwords = words.subList(splitFrom, splitTo + 1);

		for (int i = 0; i < subwords.size(); i++) {
			wordsLength = wordsLength + subwords.get(i).length();
		}

		wordsLength = wordsLength + subwords.size() - 1;

		if (wordsLength <= pageWidth)
			cost = (pageWidth - wordsLength) * (pageWidth - wordsLength);
		else
			cost = Integer.MAX_VALUE;

		return cost;
	}
}
