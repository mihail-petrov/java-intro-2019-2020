package uni.processors;

public class NumberProcessor {
	public static String CMP_LOWER   = "<";
	public static String CMP_GREATER = ">";
	public static String CMP_EQUAL   = "==";

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

	/**
	 * Извежда най-често срещания елемент в масива
	 *
	 * @param numbersArray масива
	 */
	public static void printMostFrequentNumber(int[] numbersArray) {
		int[] frequencyArray = new int[10001];

		for (int number: numbersArray) {
			frequencyArray[number]++;
		}

		int mostFrequentNumber = getIndexOfMaxNumber(frequencyArray);

		System.out.printf("Най-често срещаното число е: %d %n", mostFrequentNumber);
	}

	public static void printMaxIncSequence(int[] numbersArray, String compareOperation) {
		int maxCount = 0;
		int maxIndex = 0;

		int currentCount = 1;

		for (int i = 0; i < numbersArray.length-1; i++) {

			if (
					(numbersArray[i] < numbersArray[i+1]) && (CMP_LOWER.equals(compareOperation)) ||
					(numbersArray[i] > numbersArray[i+1]) && (CMP_GREATER.equals(compareOperation)) ||
					(numbersArray[i] == numbersArray[i+1]) && (CMP_EQUAL.equals(compareOperation))
			) {
				currentCount++;
				continue;
			}

			if (maxCount < currentCount) {
				maxCount = currentCount;
				maxIndex = i - currentCount + 1;
			}

			currentCount = 1;
		}

		if (maxCount < currentCount) {
			maxCount = currentCount;
			maxIndex = numbersArray.length - currentCount;
		}

		System.out.printf("Максималната редица е от %d елемента: ", maxCount);

		for (int i = maxIndex; i < maxIndex + maxCount; i++) {
			System.out.printf("%d, ", numbersArray[i]);
		}

		System.out.println();
	}

	public static void printSumSequence(int[] numbersArray) {
		int randomNumber = 11;

		int index = 0;
		int count = 0;
		int sum;
		boolean isSequenceFound = false;

		for (int i = 0; i < numbersArray.length; i++) {
			index = i;
			count = 1;
			sum = 0;

			for (int j = i; j < numbersArray.length; j++) {
				sum += numbersArray[j];

				if (sum < randomNumber) {
					continue;
				}

				if (sum == randomNumber) {
					count = j - i + 1;
					isSequenceFound = true;
					break;
				}

				break;
			}

			if (isSequenceFound) {
				break;
			}
		}

		if (isSequenceFound) {
			System.out.printf("Редицата, чиято сума е %d е от %d елемента: ", randomNumber, count);

			for (int i = index; i < index + count; i++) {
				System.out.printf("%d, ", numbersArray[i]);
			}

			System.out.println();
		} else {
			System.out.printf("Не съществува последователност от числа със сума %d %n", randomNumber);
		}
	}

	/**
	 * Връща индекса на най-голямото число в масива
	 * @param frequencyArray масива
	 * @return индекса на най-голямото число в масива
	 */
	private static int getIndexOfMaxNumber(int[] frequencyArray) {
		int maxFrequency = frequencyArray[0];
		int index = 0;

		for (int i = 1; i < frequencyArray.length; i++) {
			if (frequencyArray[i] > maxFrequency) {
				maxFrequency = frequencyArray[i];
				index = i;
			}
		}

		return index;
	}

	/**
	 * Определя дали дадено цяло число е просто
	 *
	 * @param number числото
	 * @return true ако числото е просто
	 */
	private static boolean isPrimeNumber(int number) {

		if (number == 0) {
			return false;
		}

		if (number == 1) {
			return true;
		}

		for (int i = 2; i <= number/2; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}
}
