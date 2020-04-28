package uni;

import java.util.Scanner;

/**
 * Имплементация на Домашна работа 3
 * @author Emil Doychev
 * @author Konstantin Rusev
 */
public class MouseTerminator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean active = true;

		do {
			System.out.println(
					String.format("Следващата команда е: %s", findNextCommand(scanner))
			);
		} while (active);

		scanner.close();
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
