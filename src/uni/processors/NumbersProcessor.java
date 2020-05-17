package uni.processors;

public class NumbersProcessor {
	/**
	 * Извежда простите числа в целочислен едномерен масив
	 *
	 * @param numbersArray масивът
	 */
	public static void printPrimeNumbers(int[] numbersArray) {
		System.out.print("Простите числа в масива са: ");

		for (int number: numbersArray) {
			if (isPrimeNumber(number)) {
				System.out.printf("%d, ", number);
			}
		}
		System.out.println();
	}

	private static boolean isPrimeNumber(int number) {

		if (number == 0) {
			return false;
		}

		if (number == 1) {
			return true;
		}

		for (int i = 2; i < number/2; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}
}
