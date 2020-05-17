package uni.processors;

public class WordProcessor {
	public static void printReverseWordInArray(String[] wordsArray) {
		System.out.print("Обърнатите думи в масива са: ");

		for (String word: wordsArray) {
			System.out.printf("%s, ", reverseWord(word));
		}
		System.out.println();
	}

	public static void printNumberOfRepeatingCharsInWords(String[] wordsArray) {
		System.out.println("Списък на думите и повтарящите се символи в тях:");

		for (String word: wordsArray) {
			printNumberOfRepeatingCharsInWord(word);
		}
	}

	public static void printWordsLength(String[] wordsArray) {
		System.out.println("Списък на думите и дължините им:");

		for (String word: wordsArray) {
			System.out.printf("%s - брой символи: %d %n", word, word.length());
		}
	}

	public static void printRepeatingWordsCount(String[] wordsArray) {
		System.out.println("Списък на уникалните думи и броя на срещанията им: ");

		String[] arrayCopy = new String[wordsArray.length];

		for (int i = 0; i < wordsArray.length; i++) {
			arrayCopy[i] = wordsArray[i];
		}

		for (int i = 0; i < arrayCopy.length; i++) {
			int count = 1;
			String currentWord = arrayCopy[i];

			if (currentWord == null) {
				continue;
			}

			for (int j = i+1; j < arrayCopy.length; j++) {
				if (currentWord.equalsIgnoreCase(arrayCopy[j])) {
					count++;
					arrayCopy[j] = null;
				}
			}

			System.out.printf("%s - брой повторения: %d %n", currentWord, count);
		}
	}

	private static void printNumberOfRepeatingCharsInWord(String word) {
		char[] charsArray = word.toCharArray();

		int[] unicodeArray = new int[charsArray.length];

		for (int i = 0; i < charsArray.length; i++) {
			unicodeArray[i] = (int)charsArray[i];
		}

		int mostFrequentCharUnicode = NumberProcessor.getMostFrequentNumber(unicodeArray);

		char mostFrequentChar = (char)mostFrequentCharUnicode;

		int count = 0;

		for (char currentCharacter: charsArray) {
			if (currentCharacter == mostFrequentChar) {
				count++;
			}
		}

		if (count > 1) {
			System.out.printf("%s - брой повтарящи се символи: %d - буква %s %n", word, count, mostFrequentChar);
		} else {
			System.out.printf("%s - няма повтарящи се символи %n", word);
		}
	}

	private static String reverseWord(String word) {
		String reversedWord = "";

		for (int i = word.length() - 1; i >= 0; i--) {
			reversedWord += word.charAt(i);
		}

		return reversedWord;
	}
}
