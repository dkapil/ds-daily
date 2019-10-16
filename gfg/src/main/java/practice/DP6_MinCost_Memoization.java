package practice;

import java.util.ArrayList;
import java.util.List;

public class DP6_MinCost_Memoization {

	static int[][] c;
	static int[][] memo;
	static int[][] p;
	static List<Integer> parent = new ArrayList<>();

	private static int cost(int i, int j) {
		if (i < 0 || j < 0)
			return Integer.MAX_VALUE;

		if (memo[i][j] != -1)
			return memo[i][j];

		else if (i == 0 && j == 0)
			memo[i][j] = c[i][j];

		else
			memo[i][j] = c[i][j] + min(cost(i - 1, j), cost(i, j - 1), cost(i - 1, j - 1));
		return memo[i][j];
	}

	private static int min(int cost1, int cost2, int cost3) {
		if (cost1 < cost2 && cost1 < cost3) {
			return cost1;
		} else if (cost2 < cost1 && cost2 < cost3) {
			return cost2;
		} else {
			return cost3;
		}
	}

	public static void main(String[] args) {

		int m = 3;
		int n = 3;

		c = new int[m][n];
		p = new int[m][n];

		c[0][0] = 1;
		c[0][1] = 2;
		c[0][2] = 3;

		c[1][0] = 4;
		c[1][1] = 8;
		c[1][2] = 2;

		c[2][0] = 1;
		c[2][1] = 5;
		c[2][2] = 3;

		memo = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				memo[i][j] = -1;
			}
		}

		System.out.println(cost(2, 1));
	}
}
