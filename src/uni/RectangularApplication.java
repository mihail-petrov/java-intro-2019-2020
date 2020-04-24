package uni;

import java.util.Scanner;

/**
 * Реализация на домашна работа 2
 *
 * @author Emil Doychev
 */
public class RectangularApplication {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Домашна работа 2");
		System.out.println("================");

		float a = readFloat(scanner, "Страна A");
		float b = readFloat(scanner, "Страна B");

		System.out.println(String.format("Периметъра на правоъгълник със страни %2.2f и %2.2f е: %2.2f", a, b, calculatePerimeter(a, b)));
		System.out.println(String.format("Лицето на правоъгълник със страни %2.2f и %2.2f е: %2.2f", a, b, calculateSurface(a, b)));
	}

	public static float readFloat(Scanner scanner, String promptMessage) {
		System.out.print(promptMessage + ": ");

		return scanner.nextFloat();
	}

	/**
	 * Методът изчислява периметъра на правоъгълник със страни {@code a} и {@code b}.
	 *
	 * @param a едната страна на правоъгълника
	 * @param b втората страна на правоъгълника
	 * @return периметъра на правоъгълника
	 */
	public static double calculatePerimeter(float a, float b) {
		return 2*a + 2*b;
	}

	/**
	 * Методът изчислява лицето на правоъгълник със страни {@code a} и {@code b}.
	 *
	 * @param a едната страна на правоъгълника
	 * @param b втората страна на правоъгълника
	 * @return лицето на правоъгълника
	 */
	public static double calculateSurface(float a, float b) {
		if (a + b > Float.MAX_VALUE) {
			System.err.println("Твърде големи стойности за страните на правоъгълника. Прекъсваме ненормално.");
			System.exit(1);
		}

		return a*b;
	}
}
