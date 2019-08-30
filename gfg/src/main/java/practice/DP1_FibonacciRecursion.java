package practice;

public class DP1_FibonacciRecursion {

	public static void main(String[] args) {
		System.out.println(fib(4));
	}

	static int fib(int n) {
		System.out.println("Calculating fib(" + n + ")");
		if (n <= 1) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}
}
