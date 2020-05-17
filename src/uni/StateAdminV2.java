package uni;

import uni.processors.NumberProcessor;

import java.util.Scanner;

public class StateAdminV2 {
	private static String[] mainMenu = {
			"Работа с числа",
			"Работа с думи",
			"Изход от програмата"
	};

	private static String[] numbersMenu = {
			"Извеждане само на простите числа от масива",
			"Извеждане на най-често срещан елемент в масива",
			"Извеждане на максимална редица от нарастващи елементи в масива",
			"Извеждане на максимална редица от намаляващи елементи в масива",
			"Извеждане на максимална редица от еднакви елементи в масива",
			"Извеждане на последователност от числа от масива, които имат сума равна на число, генерирано на случаен принцип",
			"Връщане назад към основното меню"
	};

	private static String[] wordsMenu = {
			"Обърнете буквите на думите от масива наобратно и ги визуализирайте в конзолата",
			"Изведете броя на повтарящите се символи за всяка една от думите в масива",
			"Изведете броя на символите за всяка една от думите в масива",
			"Изведете броя на повтарящите се думи от масива",
			"Връщане назад към основното меню"
	};

	private static  Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		executeMainMenu();
	}

	private static void executeMainMenu() {
		int option = -1;

		do {
			option = getMenuOption("Основно меню", mainMenu);

			if (option == 1) {
				executeNumbersMenu();
			} else if (option == 2) {
				executeWordsMenu();
			}
		} while (option != mainMenu.length);

		System.out.println("Довиждане!!!");
	}

	private static void executeNumbersMenu() {
		int[] numbersArray = readNumbersArray();

		int option;

		do {
			option = getMenuOption("Работа с числа", numbersMenu);

			switch (option) {
				case 1: NumberProcessor.printPrimeNumbers(numbersArray); break;
				case 2: NumberProcessor.printMostFrequentNumber(numbersArray); break;
				case 3: NumberProcessor.printMaxIncSequence(numbersArray, NumberProcessor.CMP_LOWER); break;
			    case 4: NumberProcessor.printMaxIncSequence(numbersArray, NumberProcessor.CMP_GREATER); break;
			    case 5: NumberProcessor.printMaxIncSequence(numbersArray, NumberProcessor.CMP_EQUAL); break;
				case 6: NumberProcessor.printSumSequence(numbersArray); break;
				default: break;
			}
		} while (option != numbersMenu.length);
	}

	private static void executeWordsMenu() {
		int option = -1;

		do {
			option = getMenuOption("Работа с думи", wordsMenu);

		} while (option != wordsMenu.length);
	}

	private static int getMenuOption(String title, String[] menuOptions) {

		System.out.println(title);
		System.out.println("===============================");

		for (int i = 0; i < menuOptions.length; i++) {
			System.out.printf("[%d] %s %n", i+1, menuOptions[i]);
		}

		return chooseMenuOption(menuOptions.length);
	}

	private static  int chooseMenuOption(int maxOption) {
		int choice = -1;

		do {
			System.out.print("Въведете опция: ");
			choice = scanner.nextInt();
			scanner.nextLine();
		} while (choice < 0 || choice > maxOption);

		return choice;
	}

	private static int readInt(String prompt, int minValue, int maxValue) {
		int count = -1;
		do {
			System.out.print(prompt);
			count = scanner.nextInt();
			scanner.nextLine();
		} while (count < minValue || count > maxValue);

		return count;
	}

	private static int[] readNumbersArray() {
		int numbersCount = readInt("Въведете броя на числата: ", 1, 100);

		int[] numbersArray = new int[numbersCount];

		for (int i = 0; i < numbersArray.length; i++) {
			numbersArray[i] = readInt(String.format("Въведете число [%d]: ", i), 0, 10000);
		}

		return numbersArray;
	}
}
