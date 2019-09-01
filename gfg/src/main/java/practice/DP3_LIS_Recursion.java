package practice;

public class DP3_LIS_Recursion {

	static int max_ref; // stores the LIS

	public static void main(String args[]) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;
		System.out.println("Length of lis is " + lis(arr, n) + "\n");
	}

	static int calcLis(int[] arr, int n) {

		System.out.println("Calculating LIS For Size (" + n + ")");

		if (n == 1)
			return 1;

		int res, max_ending_here = 1;

		for (int i = 1; i < n; i++) {
			res = calcLis(arr, i);
			System.out.println("Comparing " + arr[i - 1] + " with " + arr[n - 1]);
			if (arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here)
				max_ending_here = res + 1;
		}

		if (max_ref < max_ending_here)
			max_ref = max_ending_here;

		System.out.println("At n=" + n + " Max ending here" + max_ending_here);
		return max_ending_here;
	}

	static int lis(int[] arr, int n) {
		max_ref = 1;

		calcLis(arr, n);

		return max_ref;
	}

}