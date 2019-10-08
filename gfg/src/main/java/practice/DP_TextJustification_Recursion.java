package practice;

import java.util.Arrays;
import java.util.List;

public class DP_TextJustification_Recursion {

	static int[][] lc;

	static int[] parentPointers;

	private static double cost(int i) {

		if (i == 0)
			return 0;

		double[] allcosts = new double[i];

		for (int j = i; j >= 1; j--) {
			System.out.println("Recur - Calculating cost(" + (j - 1) + ")");
			allcosts[j - 1] = cost(j - 1) + lc[j][i];
		}  

		System.out.print("Allcosts c(" + i + ")=");
		for (int j = 0; j < allcosts.length; j++) {
			System.out.print(allcosts[j] + ",");
		}
		System.out.println();

		return min(allcosts, i);
	}

	private static double min(double[] allcosts, int row) {
		int minIndex = 0;
		double min = allcosts[0];

		for (int i = 0; i < allcosts.length; i++) {
			double j = allcosts[i];

			if (j < min) {
				minIndex = i;
				min = j;
			}
		}
		parentPointers[row] = minIndex + 1;
		return min;
	}

	public static void main(String[] args) {

//		words = Arrays.asList("a", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog");
		List<String> words = Arrays.asList("aaa", "bb", "cc", "ddddd");

		int n = words.size();

		int[] l = new int[n];

		for (int i = 0; i < l.length; i++) {
			l[i] = words.get(i).length();
		}

		lc = computelc(l, n, 6);

		parentPointers = new int[n + 1];

		cost(n);

		for (int i = 0; i < parentPointers.length; i++) {
			System.out.print(parentPointers[i] + ",");
		}
	}

	static int[][] computelc(int[] wordsLength, int n, int pageWidth) {
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
			extras[i][i] = pageWidth - wordsLength[i - 1];
			for (int j = i + 1; j <= n; j++)
				extras[i][j] = extras[i][j - 1] - wordsLength[j - 1] - 1;
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
}
