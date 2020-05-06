package uni;

public class MonsterChessApplication {
	public static final String FIG_DWARF       = "Dw";
	public static final String FIG_DONKEY      = "D ";
	public static final String FIG_QUEEN       = "Q ";
	public static final String FIG_KING        = "K ";
	public static final String FIG_GUN         = "M ";
	public static final String EMPTY_POSITION  = " X ";
	public static final String WHITE           = "w";
	public static final String BLACK           = "b";
	public static final String COL_DIVIDER     = " + ";
	public static final String ROW_DIVIDER     = "=====================================";
	public static final String V_SIGN_DIVIDER  = " | ";
	public static final char   START_LABEL     = 'A';



	public static void main(String[] args) {

		String[][] board = {
				{getFigSign(WHITE, FIG_DWARF), getFigSign(WHITE, FIG_DONKEY), getFigSign(WHITE, FIG_QUEEN), getFigSign(WHITE, FIG_KING), getFigSign(WHITE, FIG_GUN), getFigSign(WHITE, FIG_DWARF)},
				{EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION},
				{EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION},
				{EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION},
				{EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION},
				{getFigSign(BLACK, FIG_DWARF), getFigSign(BLACK, FIG_DONKEY), getFigSign(BLACK, FIG_QUEEN), getFigSign(BLACK, FIG_KING), getFigSign(BLACK, FIG_GUN), getFigSign(BLACK, FIG_DWARF)}
		};
		println("  Домашна работа 4");
		println("#####################");
		print(board);
	}

	/**
	 * Извежда състоянието на дъската в конзолата
	 *
	 * @param board дъска
	 */
	public static void print(String[][] board) {
		println();
		println(ROW_DIVIDER);
		for (int i = 0; i < board.length; i++) {

			print(START_LABEL + i);
			print(V_SIGN_DIVIDER);

			for (int j = 0; j < board[i].length; j++) {
				print(board[i][j]);
				if (j < board[i].length - 1) {
					print(COL_DIVIDER);
				}
			}
			println();
			println(ROW_DIVIDER);
		}

		printHorizontalLabels(board[0].length);
	}

	/**
	 * Извеждане на хоризонталните етикети на дъската
	 *
	 * @param boardSize хоризонталния размер на дъската
	 */
	public static void printHorizontalLabels(int boardSize) {
		print("    ");
		for (int i = 0; i < boardSize; i++) {
			print(" ");
			print(START_LABEL + i);
			print("    ");
		}
		println();
	}

	/**
	 * Генерира пълното означение на фигура като залепва типа на фигурата към префикса
	 * @param colorPrefix префикса на цвета
	 * @param figType тип на фигурата
	 * @return пълното означение на фигурата
	 */
	public static String getFigSign(String colorPrefix, String figType) {
		return String.format("%s%s", colorPrefix, figType);
	}

	/**
	 * Извежда в конзолата форматиран низ без добавяне на нов ред
	 *
	 * @param message съобщението за извеждане
	 * @param params параметрите за форматиране на низа
	 */
	public static void print(String message, Object ... params) {
		System.out.printf(message, params);
	}

	/**
	 * Извежда в конзолата форматиран низ с добавяне на нов ред
	 *
	 * @param message съобщението за извеждане
	 * @param params параметрите за форматиране на низа
	 */
	public static void println(String message, Object ... params) {
		System.out.printf(message + "%n", params);
	}

	/**
	 * Извежда в конзолата неформатиран низ без добавяне на нов ред
	 *
	 * @param message съобщението за извеждане
	 */
	public static void print(String message) {
		System.out.print(message);
	}

	/**
	 * Извежда в конзолата неформатиран низ с добавяне на нов ред
	 *
	 * @param message съобщението за извеждане
	 */
	public static void println(String message) {
		System.out.println(message);
	}

	/**
	 * Извежда в конзолата единичен символ
	 *
	 * @param sign единичният символ
	 */
	public static void print(int sign) {
		System.out.print((char)sign);
	}

	/**
	 * Добавя в конзолата нов ред
	 */
	public static void println() {
		System.out.println();
	}
}
