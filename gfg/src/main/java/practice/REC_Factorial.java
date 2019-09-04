package practice;

public class REC_Factorial {

	static int depth = 0;

	public static void main(String[] args) {
		System.out.println(fact(6));
	}

	private static int fact(int n) {
		System.out.println(depth++);
		if (n <= 1)
			return 1;
		else
			return n * fact(n - 1);
	}
}