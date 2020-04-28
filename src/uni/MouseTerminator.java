package uni;

import java.util.Random;

/**
 * Имплементация на Домашна работа 3
 *
 * @author Emil Doychev
 * @author Konstantin Rusev
 */
public class MouseTerminator {
	public static void main(String[] args) throws InterruptedException {
		Random random = new Random();
		byte batteryPower = 4;

		do {
			System.out.printf("Следващата команда е: %s \n", findNextCommand(random));

			batteryPower = lookForMouse(batteryPower, random);

			Thread.sleep(2000);

			System.out.println("-----------------------");
		} while (true);
	}

	/**
	 * Търси мишка и предприема нужното действие
	 *
	 * @param currentBatteryPower текущия заряд на батерията
	 * @param random помощния обект за генериране на случайни числа
	 * @return оставащия заряд на батерията след изпълнението на действието
	 */
	public static byte lookForMouse(byte currentBatteryPower, Random random) {
		if (isMouseDetected(random)) {
			System.out.println("Мишка на прицел!!!");

			return tryToKillIt(currentBatteryPower, random);
		}

		System.out.println("Няма мишка :(");

		return currentBatteryPower;
	}

	/**
	 * Опитва се да нанесе удар за елиминиране на мишката. Ако ударът ще е разрушителен за мебелите не извършва никакво
	 * действие. В противен случай нанася удара ако има батерия или отива да зарежда батерията ако е празна.
	 *
	 * @param currentBatteryPower текущия заряд на батерията
	 * @param random помощния обект за генериране на случайни числа
	 * @return оставащия заряд на батерията след изпълнението на действието
	 */
	public static byte tryToKillIt(byte currentBatteryPower, Random random) {
		if (isHitTooFatal(random)) {
			System.out.println("Ударът ще е разрушителен. Стоп на операцията!");

			return currentBatteryPower;
		}

		System.out.println("Ударът ще унищожи само мишката.");

		return performAction(currentBatteryPower, random);
	}

	/**
	 * Извършва следващото възможно действие - ако има заряд премахва мишката от този свят и поздравява собственика.
	 * Ако няма заряд в батерията - търси контакт с напрежение и зарежда батерията.
	 *
	 * @param currentBatteryPower текущия заряд на батерията
	 * @param random помощния обект за генериране на случайни числа
	 * @return оставащия заряд на батерията след изпълнението на действието
	 */
	public static byte performAction(byte currentBatteryPower, Random random) {
		if (hasBatteryPower(currentBatteryPower)) {
			System.out.printf("Има заряд: %d!\n", currentBatteryPower);

			System.out.println("Мишката е ТЕРМИНИРАНА!");

			greetOwner();

			return (byte)(currentBatteryPower - 1);
		}

		System.out.println("Ups! Няма ток в батерята! Ще зареждаме.");

		findSocketWithPower(random);

		System.out.println("Батерията е заредена.");

		return 4;
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
	 * @param random Помощен обект за генериране на случайни числа
	 * @return {@code true} ако мишката е на прицел, иначе {@code false}.
	 */
	public static boolean isMouseDetected(Random random) {
		long pixels = random.nextLong();
		System.out.printf("Броя пиксели: %d \n", pixels);

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
	 * @param random Помощен обект за генериране на случайни числа
	 * @return командата
	 */
	public static String findNextCommand(Random random) {
		final String OBSTACLE_WALL  = "стена";
		final String OBSTACLE_CHAIR = "стол";
		final String NO_OBSTACLE    = "няма препятствие";

		do {
			System.out.print("Препятствие: ");

			int obstacleNumber = random.nextInt(3);

			switch (obstacleNumber) {
				case 2 :
					System.out.println(OBSTACLE_WALL);
					return "Go Sideway";
				case 1 :
					System.out.println(OBSTACLE_CHAIR);
					return "Jump";
				case 0 :
					System.out.println(NO_OBSTACLE);
					return "Forward";
			    default:
					System.out.println("Непознато препятствие. Upgrade the robot.");
			}
		} while (true);
	}
}
