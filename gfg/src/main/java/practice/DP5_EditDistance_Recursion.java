package practice;

public class DP5_EditDistance_Recursion {

	private static int cost(String str1, String str2, int m, int n) {

		if (m == 0)
		{
			System.out.println("Returning Cost " + n);
			return n;
		}
		
		if (n == 0)
		{
			System.out.println("Returning Cost " + m);
			return m;
		}

		if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
			return cost(str1, str2, m - 1, n - 1);
		} else {
			System.out.println("Recurring from str1="+ str1.substring(0, m) + ",str2=" + str2.substring(0, n));
			System.out.println("min("
					+ "cost(str1=" + str1.substring(0, m) + ",str2=" + str2.substring(0, n - 1) + "), "
					+ "cost(str1=" + str1.substring(0, m - 1) + ",str2=" + str2.substring(0, n) + "), " 
					+ "cost(str1=" + str1.substring(0, m - 1) + ",str2=" + str2.substring(0, n - 1) + ")");
			System.out.println();
			
			return 1 + min(cost(str1, str2, m, n - 1), cost(str1, str2, m - 1, n), cost(str1, str2, m - 1, n - 1));
		}
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

		System.out.println(cost(str1, str2, str1.length(), str2.length()));
	}

}
