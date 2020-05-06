package uni;

import java.util.Scanner;

public class MonsterChessApplication {
	public static final String FIG_DWARF       = "Dw";
	public static final String FIG_DONKEY      = "D ";
	public static final String FIG_QUEEN       = "Q ";
	public static final String FIG_KING        = "K ";
	public static final String FIG_GUN         = "M ";
	public static final String EMPTY_POSITION  = " X ";
	public static final char   WHITE           = 'w';
	public static final char   BLACK           = 'b';
	public static final String COL_DIVIDER     = " + ";
	public static final String ROW_DIVIDER     = "=====================================";
	public static final String V_SIGN_DIVIDER  = " | ";
	public static final char   START_LABEL     = 'A';

	public static final Scanner scanner = new Scanner(System.in);
	public static final boolean[] isWhiteDwarfInStraightDirection = { true, true };
	public static final boolean[] isBlackDwarfInStraightDirection = { true, true };

	public static int movesCounter = 0;

	public static void main(String[] args) {

		String[][] board = {
				{getFigSign(WHITE, FIG_DWARF), getFigSign(WHITE, FIG_DONKEY), getFigSign(WHITE, FIG_QUEEN), getFigSign(WHITE, FIG_KING), getFigSign(WHITE, FIG_GUN), getFigSign(WHITE, FIG_DWARF)},
				{EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION},
				{EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION},
				{EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION},
				{EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION, EMPTY_POSITION},
				{getFigSign(BLACK, FIG_DWARF), getFigSign(BLACK, FIG_DONKEY), getFigSign(BLACK, FIG_QUEEN), getFigSign(BLACK, FIG_KING), getFigSign(BLACK, FIG_GUN), getFigSign(BLACK, FIG_DWARF)}
		};
		boolean isWhiteTurn = true;

		println("  Домашна работа 4");
		println("#####################");

		do {
			print(board);

			if (isWhiteTurn) {
				movesCounter++;
			}

			println("На ход са %s фигури.", isWhiteTurn?"белите":"черните");

			int[] moveCoordinates = readValidCoordinates(board, isWhiteTurn);

			println("Ход: от позиция [%d, %d] в позиция [%d, %d]",
					moveCoordinates[0], moveCoordinates[1], moveCoordinates[2], moveCoordinates[3]);

			moveFigure(board, moveCoordinates);

			isWhiteTurn = !isWhiteTurn;
		} while(true);

		// scanner.close();
	}

	/**
	 * Премества фигурата с указаните координати на указаната позиция
	 *
	 * @param board дъската
	 * @param coords координатите на фигурата (0, 1) и целевата позиция (2, 3)
	 */
	public static void moveFigure(String[][] board, int[] coords) {
		String figure = board[coords[1]][coords[0]];
		String target = board[coords[3]][coords[2]];

		board[coords[3]][coords[2]] = figure;
		board[coords[1]][coords[0]] = EMPTY_POSITION;

		if (!target.equals(EMPTY_POSITION)) {
			println("Взехме противникова фигура: %s", target);
		}

		setDwarfDirection(figure, coords[2], coords[3], board.length);
	}

	/**
	 * Задава стойност на флага за посоката на джудже. Ако фигурата не е джудже - не извършва никакви действия.
	 *
	 * @param figure фигурата, която трябва да е джудже
	 * @param hCoord хоризонталната координата на фигурата
	 * @param vCoord вертикалната координата на фигурата
	 * @param boardVSize вертикалния размер на дъската
	 */
	public static void setDwarfDirection(String figure, int hCoord, int vCoord, int boardVSize) {
		char colorPrefix = figure.charAt(0);
		String figureType = figure.substring(1);

		if (!figureType.equals(FIG_DWARF)) {
			return;
		}

		int dwarfIndex = hCoord == 0 ? 0 : 1;

		if (colorPrefix == WHITE) {
		  	if (vCoord == boardVSize-1) {
				isWhiteDwarfInStraightDirection[dwarfIndex] = false;
			}

		  	if (vCoord == 0) {
				isWhiteDwarfInStraightDirection[dwarfIndex] = true;
			}
		} else {
			if (vCoord == boardVSize-1) {
				isBlackDwarfInStraightDirection[dwarfIndex] = true;
			}

			if (vCoord == 0) {
				isBlackDwarfInStraightDirection[dwarfIndex] = false;
			}
		}
	}

	/**
	 * Прочита координати на фигурата и на целевата позиция и ако не съответстват на валиден ход за фигурата - изисква
	 * ново въвеждане.
	 *
	 * @param board диската
	 * @param isWhiteTurn определя дали белите фигури са на ход
	 * @return масив от 4 координати - на фигурата (0, 1) и на целевата позиция (2, 3)
	 */
	public static int[] readValidCoordinates(String[][] board, boolean isWhiteTurn) {
		int[] coords = {};
		boolean validMove = false;

		while (!validMove){
			coords = readCoordinates();
			validMove = isValidMove(board, isWhiteTurn, coords[0], coords[1], coords[2], coords[3]);

			if (!validMove) {
				println("Ходът не е валиден. Опитайте отново.");
			}
		}

		return coords;
	}

	/**
	 * Определя дали хода е валиден, като намира сътвените начална и крайна позиция, съобразява типа на фигурата и т.н.
	 *
	 * @param board дъската
	 * @param isWhiteTurn задава дали белите фигури са на ход
	 * @param startHCoord хоризонталната координата на фигурата
	 * @param startVCoord вертикалната координата на фигурата
	 * @param targetHCoord хоризонталната координата на целевата позиция
	 * @param targetVCoord вертикалната координата на целевата позиция
	 * @return true ако хода е валиден и може да бъде изпълнен, иначе - false
	 */
	public static boolean isValidMove(String[][] board, boolean isWhiteTurn, int startHCoord, int startVCoord, int targetHCoord, int targetVCoord) {
		return isValidStartPosition(board, isWhiteTurn, startHCoord, startVCoord) &&
			   isValidTargetPosition(board, isWhiteTurn, startHCoord, startVCoord, targetHCoord, targetVCoord);

	}

	/**
	 * Определя дали целевата позиция е валидна за фигурата.
	 *
	 * @param board дъската
	 * @param isWhiteTurn задава дали белите фигури са на ход
	 * @param startHCoord хоризонталната координата на фигурата
	 * @param startVCoord вертикалната координата на фигурата
	 * @param targetHCoord хоризонталната координата на целевата позиция
	 * @param targetVCoord вертикалната координата на целевата позиция
	 * @return true ако хода е валиден и може да бъде изпълнен, иначе - false
	 */
	public static boolean isValidTargetPosition(String[][] board, boolean isWhiteTurn, int startHCoord, int startVCoord, int targetHCoord, int targetVCoord) {
		if (!isPositionWithinBoard(board, targetHCoord, targetVCoord)) {
			return false;
		}

		if (isPositionColored(board, isWhiteTurn, targetHCoord, targetVCoord)) {
			return false;
		}

		String figure = board[startVCoord][startHCoord].substring(1);

		switch (figure) {
			case FIG_DWARF: return isValidDwarfMove(board, isWhiteTurn, startHCoord, startVCoord, targetHCoord, targetVCoord);
		    case FIG_DONKEY: return isValidDonkeyMove(startHCoord, startVCoord, targetHCoord, targetVCoord);
			default: return false;
		}
	}

	/**
	 * Определя дали в позицията, зададена с координатите {@code hCoord} и {@code vCoord} има фигура от цвета
	 * определен с флага {@code isWhiteTurn}.
	 *
	 * @param board дъската
	 * @param isWhiteTurn определя дали белите фигури са на ход
	 * @param hCoord хоризонталната позиция на фигурата
	 * @param vCoord вертикалната позиция на фигурата
	 * @return true ако в указаната позиция има фигура съответстваща на флага {@code isWhiteTurn}
	 */
	public static boolean isPositionColored(String[][] board, boolean isWhiteTurn, int hCoord, int vCoord) {
		String figure = board[vCoord][hCoord];
		char colorPrefix = figure.charAt(0);

		if (figure.equals(EMPTY_POSITION)) {
			return false;
		}

		if (isWhiteTurn && (colorPrefix == WHITE)) {
			return true;
		}

		if (!isWhiteTurn && (colorPrefix == BLACK)) {
			return true;
		}

		return false;
	}

	/**
	 * Определя дали ходът е валиден за джудже.
	 *
	 * @param board дъската
	 * @param isWhiteTurn задава дали белите фигури са на ход
	 * @param startHCoord хоризонталната координата на джуджето
	 * @param startVCoord вертикалната координата на джуджето
	 * @param targetHCoord хоризонталната координата на целевата позиция
	 * @param targetVCoord вертикалната координата на целевата позиция
	 * @return true ако хода е валиден и може да бъде изпълнен, иначе - false
	 */
	public static boolean isValidDwarfMove(String[][] board, boolean isWhiteTurn, int startHCoord, int startVCoord, int targetHCoord, int targetVCoord) {
		if (startHCoord != targetHCoord) {
			return false;
		}

		if (startHCoord != 0 && startHCoord != board[0].length - 1) {
			return false;
		}

		int dwarfIndex = startHCoord == 0 ? 0 : 1;

		if (isWhiteTurn) {
			if (isWhiteDwarfInStraightDirection[dwarfIndex]) {
				return targetVCoord - startVCoord == 1;
			} else {
				return startVCoord - targetVCoord == 1;
			}
		} else  {
			if (isBlackDwarfInStraightDirection[dwarfIndex]) {
				return startVCoord - targetVCoord == 1;
			} else {
				return targetVCoord - startVCoord == 1;
			}
		}
	}

	public static boolean isValidDonkeyMove(int startHCoord, int startVCoord, int targetHCoord, int targetVCoord) {
		if (movesCounter % 3 != 0) {
			return false;
		}

		int vHops = Math.abs(startVCoord - targetVCoord);
		int hHops = Math.abs(startHCoord - targetHCoord);

		if (vHops == 2 || vHops == 0 || hHops == 2 || hHops == 0) {
			return true;
		}

		return false;
	}

	/**
	 * <p>Определя дали позицията с коориднати {@code hCoord} и {@code vCoord} е валидна начална позиция на ход:</p>
	 * <ul>
	 *     <li>дали позицията е в рамките на игралното поле</li>
	 *     <li>дали върху позицията има фигура от правилния цвят, зададен с параметъра {@code isWhiteTurn}</li>
	 * </ul>
	 *
	 * @param board дъската
	 * @param isWhiteTurn true ако белите фигури са на ход, иначе - false
	 * @param hCoord хоризонталната координата на позицията
	 * @param vCoord вертикалната координата на позицията
	 * @return true ако е валидна начална позиция на ход
	 */
	public static boolean isValidStartPosition(String[][] board, boolean isWhiteTurn, int hCoord, int vCoord) {
		if (!isPositionWithinBoard(board, hCoord, vCoord)) {
			return false;
		}

		return isPositionColored(board, isWhiteTurn, hCoord, vCoord);
	}

	/**
	 * Определя дали координатите са в рамките на игралното поле.
	 *
	 * @param board игралното поле (дъската)
	 * @param hCoord хоризонтален координат
	 * @param vCoord вериткален координат
	 * @return true ако координатите са валидни в рамките на игралното поле
	 */
	public static boolean isPositionWithinBoard(String[][] board, int hCoord, int vCoord) {
		if (hCoord < 0 || hCoord >= board[0].length || vCoord < 0 || vCoord >= board.length) {
			return false;
		}

		return true;
	}

	/**
	 * Прочита координати на ход във формат XY, където X са координатите на началната позиция на фигурата
	 * във двубуквен формат, а Y са координатите на целевата позиция, отново в двубуквен формат.
	 *
	 * @return масив от 4 елемента - първите два елемента са хоризонталната и вертикална координати на началната позиция,
	 * а следващите два елемента са съответните координати на целевата позиция
	 */
	public static int[] readCoordinates() {
		String stringCoordinates;
		int[] coordinates = new int[4];

		do {
			print("Въведете координати на хода: ");
			stringCoordinates = scanner.nextLine();
		} while (stringCoordinates.length() != 4);

		int[] fromCoordinates = transformCoordinates(stringCoordinates.substring(0, 2));
		int[] toCoordinates   = transformCoordinates(stringCoordinates.substring(2, 4));

		coordinates[0] = fromCoordinates[0];
		coordinates[1] = fromCoordinates[1];
		coordinates[2] = toCoordinates[0];
		coordinates[3] = toCoordinates[1];

		return coordinates;
	}

	/**
	 * Преобразува символни координати в цифрови
	 *
	 * @param stringCoordinates символните координати
	 * @return масив от цифрови координати
	 */
	public static int[] transformCoordinates(String stringCoordinates) {
		int[] coordinates = new int[2];

		coordinates[0] = stringCoordinates.charAt(0) - START_LABEL;
		coordinates[1] = stringCoordinates.charAt(1) - START_LABEL;

		return coordinates;
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
	public static String getFigSign(char colorPrefix, String figType) {
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
