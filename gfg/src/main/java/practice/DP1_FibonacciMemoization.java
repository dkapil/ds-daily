package practice;

public class DP1_FibonacciMemoization {

	static int[] lookup = new int[100];

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			lookup[i] = -1;
		}

		System.out.println(fib(11));
	}

	static int fib(int n) {

		if (lookup[n] == -1) {
			System.out.println("Calculating fib(" + n + ")");
			if (n <= 1) {
				lookup[n] = n;
			} else {
				lookup[n] = fib(n - 1) + fib(n - 2);
			}
		}
		return lookup[n];
	}

}
