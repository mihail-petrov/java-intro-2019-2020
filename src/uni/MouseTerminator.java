package uni;

import java.util.Random;
import java.util.Scanner;

/**
 * Имплементация на Домашна работа 3
 * @author Emil Doychev
 * @author Konstantin Rusev
 */
public class MouseTerminator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		byte batteryPower = 4;

		boolean active = true;

		do {
			System.out.println(
					String.format("Следващата команда е: %s", findNextCommand(scanner))
			);

			if (isMouseDetected(scanner)) {
				System.out.println("Мишка на прицел!!!");

				if (isHitTooFatal(random)) {
					System.out.println("Ударът ще е разрушителен. Стоп на операцията!");
				} else {
					System.out.println("Ударът ще унищожи само мишката.");

					if (hasBatteryPower(batteryPower)) {
						System.out.printf("Има заряд: %d!\n", batteryPower);

						batteryPower--;

						System.out.println("Мишката е ТЕРМИНИРАНА!");

						greetOwner();
					} else {
						System.out.println("Ups! Няма ток в батерята! Ще зареждаме.");

						findSocketWithPower(random);

						batteryPower = 4;

						System.out.printf("Батерията е заредена. Ниво: %d!\n", batteryPower);
					}
				}

			} else {
				System.out.println("Няма мишка :(");
			}
		} while (active);

		scanner.close();
	}

	/**
	 * Търси контакт с напрежение. Методът приключва изпълнението си едва когато намери такъв
	 * контакт.
	 * @param random - помощен обект за генериране на случайни числа
	 */
	public static void findSocketWithPower(Random random) {
		int firstNumber;
		int secondNumber;

		do {
			firstNumber = random.nextInt(1000) + 1;
			secondNumber = random.nextInt(1000) + 1;

			if (!hasPowerInSocket(firstNumber, secondNumber)) {
				System.out.println("Намерих контакт, но без напрежение :(");
			}
		} while (!hasPowerInSocket(firstNumber, secondNumber));

		System.out.println("Ура! Намерих контакт с напрежение!");
	}

	/**
	 * Определя дали има напрежение в контакта
	 * @return {@code true} ако има напрежение, иначе - {@code false}
	 */
	public static boolean hasPowerInSocket(int firstNumber, int secondNumber) {
		return firstNumber > secondNumber;
	}

	/**
	 * Извежда поздрав към собственика за поредната елиминирана мишка.
	 */
	public static void greetOwner() {
		for (byte i = 10; i > 0; i--) {
			System.out.print(i);

			if (i % 2 == 0) {
				System.out.println(": I am a Robottttt");
			} else {
				System.out.println();
			}
		}
	}

	/**
	 * Определя дали роботът има заряд в батерията за поне още един удар.
	 *
	 * @param currentBatteryPower текущия заряд на батерията
	 * @return {@code true} ако има достатъчно заряд за още един удар, иначе - {@code false}
	 */
	public static boolean hasBatteryPower(int currentBatteryPower) {
		return currentBatteryPower > 0;
	}

	/**
	 * Определя дали предстоящия удар ще е разрушителен за мебелите.
	 *
	 * @param random помощен обект за генериране на случайни числа в цялото приложение
	 * @return {@code true} ако ударът ще е разрушителен, иначе - {@code false}
	 */
	public static boolean isHitTooFatal(Random random) {
		final int FATAL_HIT = 5;

		int hit = random.nextInt(10) + 1;

		return hit == FATAL_HIT;
	}

	/**
	 * Определя дали мишката е на прицел, като проверява дали броя на пикселите в околната среда
	 * са четно число.
	 *
	 * @param scanner Вход за броя на пикслеите
	 * @return {@code true} ако мишката е на прицел, иначе {@code false}.
	 */
	public static boolean isMouseDetected(Scanner scanner) {
		System.out.print("Броя пиксели: ");
		long pixels = scanner.nextLong();
		scanner.nextLine();

		return pixels % 2 == 0;
	}

	/**
	 * <p>Определя каква е следващата команда, в зависимост от препятствието.</p>
	 *
	 * <p>Препятствието се получава от околната среда. Възможностите са:</p>
	 * <ul>
	 *     <li>{@code стена}: {@code Go Sideway}</li>
	 *     <li>{@code стол} : {@code Jump}</li>
	 *     <li>няма препятствие: {@code Forward}</li>
	 * </ul>
	 *
	 * <p>Ако препятствието не може да бъде разпознато се изчаква въвеждане на познато препятствие.</p>
	 * @param scanner Вход за препятствията
	 * @return командата
	 */
	public static String findNextCommand(Scanner scanner) {
		final String OBSTACLE_WALL  = "стена";
		final String OBSTACLE_CHAIR = "стол";
		final String NO_OBSTACLE    = "";

		do {
			System.out.print("Препятствие: ");
			String obstacle = scanner.nextLine();

			switch (obstacle.toLowerCase()) {
				case OBSTACLE_WALL  : return "Go Sideway";
				case OBSTACLE_CHAIR : return "Jump";
				case NO_OBSTACLE    : return "Forward";
			    default:
					System.out.println("Непознато препятствие. Upgrade the robot.");
			}
		} while (true);

	}
}
