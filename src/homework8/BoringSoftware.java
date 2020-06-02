package homework8;

import java.io.FileNotFoundException;

public class BoringSoftware {
	public static void main(String[] args) throws FileNotFoundException {
		if (args.length < 1) {
			System.err.println("Използване: BoringSoftware <име на файл>");
			System.exit(1);
		}

		String fileName = args[0];

		BoringDatabase.loadData(fileName);
	}
}
