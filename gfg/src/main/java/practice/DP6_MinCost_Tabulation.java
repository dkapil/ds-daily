package practice;

import java.util.ArrayList;
import java.util.List;

public class DP6_MinCost_Tabulation {

	static int[][] c;
	static int[][] p;
	static List<Integer> parent = new ArrayList<>();
	static int[][] costmat;

	private static int cost(int i, int j) {

		costmat = new int[i + 1][j + 1];

		costmat[0][0] = c[0][0];

		for (int m = 0; m <= i; m++) {
			for (int n = 0; n <= j; n++) {
				if (m == 0 && n == 0) {
					costmat[m][n] = c[0][0];
				} else if (m == 0) {
					costmat[m][n] = c[m][n] + costmat[m][n - 1];
				} else if (n == 0) {
					costmat[m][n] = c[m][n] + costmat[m - 1][n];
				} else {
					costmat[m][n] = c[m][n] + min(costmat[m - 1][n], costmat[m][n - 1], costmat[m - 1][n - 1]);
				}
			}
		}

		return costmat[i][j];
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

		System.out.println(cost(2, 2));
	}
}
