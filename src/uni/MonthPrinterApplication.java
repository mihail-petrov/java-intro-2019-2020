package uni;

import java.util.Scanner;

public class MonthPrinterApplication {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Домашна работа 2 / Част 2");
		System.out.println("=========================");

		System.out.print("Име на месец: ");
		String monthName = scanner.next();

		System.out.println(
				String.format("Месец %s има %d дни", monthName, getDaysOfMonth(monthName))
		);
	}

	public static byte getDaysOfMonth(String monthName) {
		if ("Януари".equalsIgnoreCase(monthName)
				|| "Март".equalsIgnoreCase(monthName)
				|| "Май".equalsIgnoreCase(monthName)
				|| "Юли".equalsIgnoreCase(monthName)
				|| "Август".equalsIgnoreCase(monthName)
				|| "Октомви".equalsIgnoreCase(monthName)
				|| "Декември".equalsIgnoreCase(monthName)) {
			return 31;
		}

		if ("Февруари".equalsIgnoreCase(monthName)) {
			return 28;
		}

		if ("Април".equalsIgnoreCase(monthName)
				|| "Юни".equalsIgnoreCase(monthName)
				|| "Септември".equalsIgnoreCase(monthName)
				|| "Ноември".equalsIgnoreCase(monthName)) {
			return 30;
		}

		return -1;
	}
}
