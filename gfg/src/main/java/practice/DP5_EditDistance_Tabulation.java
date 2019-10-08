package practice;

public class DP5_EditDistance_Tabulation {

	static int[][] c;

	private static int cost(String str1, String str2, int m, int n) {

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0) {
					c[i][j] = n;
				}
				if (j == 0) {
					c[i][j] = m;
				}
			}
		}
		
		c[0][0]=0;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.println("Recurring from str1=" + str1.substring(0, i) + ",str2=" + str2.substring(0, j));

				if (str1.charAt(i-1) == str2.charAt(j-1)) {
					c[i][j] = c[i - 1][j - 1];
					System.out.println("c["+i+"]["+j+"]="+"c["+(i-1)+"]["+(j-1)+"]");
					System.out.println("Min is "+c[i][j]);
				} else {
					System.out.println("c["+i+"]["+j+"]="+"1+min("
							+ "c["+i+"]["+(j-1)+"]"+"cost(str1=" + str1.substring(0, i) + ",str2=" + str2.substring(0, j - 1) + "), "
							+ "c["+(i-1)+"]["+j+"]"+"cost(str1=" + str1.substring(0, i - 1) + ",str2=" + str2.substring(0, j) + "), "
							+ "c["+(i-1)+"]["+(j-1)+"]"+"cost(str1=" + str1.substring(0, i - 1) + ",str2=" + str2.substring(0, j - 1) + ")");
					System.out.println();
					c[i][j] = 1 + min(c[i][j - 1], c[i - 1][j], c[i - 1][j - 1]);
					System.out.println("Min is "+c[i][j]);
				}
			}
		}

		return c[m][n];
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

		String str1 = "sunday";
		String str2 = "saturday";

		int m = str1.length();
		int n = str2.length();

		c = new int[m + 1][n + 1];

		int cost = cost(str1, str2, m, n);
		System.out.println(cost);
	}

}
