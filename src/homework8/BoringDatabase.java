package homework8;

import homework8.om.Citizen;
import homework8.om.Mother;
import homework8.om.Pensioner;
import homework8.om.Worker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoringDatabase {
	private static List<Citizen> data = new ArrayList<>();

	public static void loadData(String fileName) throws FileNotFoundException {
		System.out.printf("Зареждане на данни от файл: %s ... %n", fileName);

		InputStream inputStream = new FileInputStream(fileName);

		Scanner scanner = new Scanner(inputStream);
		int row = 0;
		while (scanner.hasNextLine()) {
			row++;
			String line = scanner.nextLine();

			Citizen citizen;

			switch (getType(line)) {
				case Citizen.TYPE_PENSIONER:
					citizen = new Pensioner();
					break;
				case Citizen.TYPE_WORKER:
					citizen = new Worker();
					break;
				case Citizen.TYPE_MOTHER:
					citizen = new Mother();
					break;
				default:
					System.err.printf("Невалиден формат на данни на ред %d. Не може да бъде определен типа на записа.%n", row);
					continue;
			}

			if (citizen.load(line)) {
				data.add(citizen);
				System.out.printf("Ред %d: %s %n", row, citizen);
			} else {
				System.err.printf("Невалиден формат на данни на ред %d. Записа не може да бъде обработен.%n", row);
			}
		}

		System.out.printf("Заредени са %d записи.%n", data.size());
	}

	private static char getType(String line) {
		String[] parts = line.split("@");

		switch (parts[0]) {
			case "{TYPE}=[R]": return Citizen.TYPE_PENSIONER;
			case "{TYPE}=[W]": return Citizen.TYPE_WORKER;
			case "{TYPE}=[M]": return Citizen.TYPE_MOTHER;
			default: return 'U';
		}
	}
}
