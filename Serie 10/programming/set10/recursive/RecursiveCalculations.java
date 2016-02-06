package programming.set10.recursive;

public class RecursiveCalculations {

	private RecursiveCalculations() {
	}

	/**
	 * Sums up the digits of {@code n}
	 * 
	 * @param n
	 * @return the sum of the digits of {@code n}
	 */
	public static int digitSum(int n) {
		if (n < 0) // invalid input
			return -1;
		else if (n == 0) // break condition
			return 0;
		else {
			return n % 10 + digitSum(n / 10);
		}
	}

	/**
	 * Returns the number on the {@code n}th position of the fibonacci numbers
	 * 
	 * @param n
	 * @return the number on the {@code n}th position of the fibonacci numbers
	 */
	public static long fibonacci(int n) {
		if (n < 1) // invalid input
			return -1;
		else if (n == 1 || n == 2) // first two numbers are 1
			return 1;
		else {
			return fibonacci(n - 2) + fibonacci(n - 1);
		}
	}

}
