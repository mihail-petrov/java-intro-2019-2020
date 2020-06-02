package homework8;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class BoringSoftware {
	private static final String END_COMMAND = "!q";

	public static void main(String[] args) throws FileNotFoundException {
		if (args.length < 1) {
			System.err.println("Използване: BoringSoftware <име на файл>");
			System.exit(1);
		}

		String fileName = args[0];

		BoringDatabase.loadData(fileName);

		askUser();

		System.out.println("Довиждане!");
	}

	private static void askUser() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("Заявка: ");
			String query = scanner.nextLine();

			if (END_COMMAND.equalsIgnoreCase(query)) {
				break;
			}

			BoringDatabase.doQuery(query);
		}

		scanner.close();
	}
}