package practice;

public class DP1_FibonacciTabulation {

	static int[] lookup = new int[100];

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			lookup[i] = -1;
		}

		System.out.println(fib(11));
	}

	static int fib(int n) {

		lookup[0] = 0;
		lookup[1] = 1;

		for (int i = 2; i <= n; i++) {
			lookup[i] = lookup[i - 1] + lookup[i - 2];
		}
		return lookup[n];
	}

}
