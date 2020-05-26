package homework;

import homework.config.Configurations;
import homework.config.EnemyTerritory;

import java.io.IOException;
import java.util.Random;

/**
 * Игралното поле
 */
public class GameBoard {
	private final Tile[][] board;
	private final Random random = new Random();
	private final int width;
	private final int height;
	private int disposals;
	private int probes;
	private int mines;
	private boolean boom;
	private Tile startTile;
	private Tile finishTile;
	private Tile currentTile;

	public GameBoard() throws IOException {
		EnemyTerritory enemyTerritory = new EnemyTerritory();
		Configurations configurations = new Configurations();

		this.width = enemyTerritory.getWidth();
		this.height = enemyTerritory.getHeight();
		this.mines = enemyTerritory.getMinesCount();
		this.disposals = configurations.getDisposalsCount();
		this.probes = configurations.getProbesCount();
		this.board = new Tile[height][width];

		populateBoard();
		setStartTile();
		setFinishTile();
		minelaying(mines);
	}

	public void printBoardInfo() {
		System.out.printf("Размери на полето      : %dx%d %n", height, width);
		System.out.printf("Брой на мините         : %d %n", mines);
		System.out.printf("Брой на опитите        : %d %n", probes);
		System.out.printf("Брой на обезврежданията: %d %n", disposals);
	}

	private void populateBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = new Tile(i, j);
			}
		}

		wireTiles();
	}

	private void wireTiles() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j].setTopNeighbor(getTile(i - 1, j));
				board[i][j].setDownNeighbor(getTile(i + 1, j));
				board[i][j].setRightNeighbor(getTile(i, j + 1));
				board[i][j].setLeftNeighbor(getTile(i, j - 1));
			}
		}
	}

	private void setStartTile() {
		this.startTile = getSpecialTile();
		startTile.setStart();
		startTile.reveal();

		currentTile = startTile;

		System.out.printf("Стартова позиция: %s %n", startTile.toString());
	}

	/**
	 * Определя крайната позиция която не трябва да лежи на една и съща страна
	 * със стартовата позиция.
	 */
	private void setFinishTile() {
		do {
			this.finishTile = getSpecialTile();
			System.out.printf("Опитвам крайна позиция %dx%d...%n", finishTile.getRow(), finishTile.getCol());
		} while (
				this.startTile.getRow() == this.finishTile.getRow() ||
				this.startTile.getCol() == this.finishTile.getCol()
		);

		this.finishTile.setFinish();
		this.finishTile.reveal();

		System.out.printf("Крайна позиция: %s %n", finishTile.toString());
	}

	/**
	 * Определя една от специалните плочки - старт или край
	 *
	 * @return специална плочка
	 */
	private Tile getSpecialTile() {
		int side = random.nextInt(3);
		int maxIndex = isVerticalSide(side) ? this.height : this.width;
		int sidePosition = random.nextInt(maxIndex);

		Tile tile;

		switch (side) {
			case 0: tile = board[sidePosition][0]; break;
		    case 1: tile = board[0][sidePosition]; break;
			case 2: tile = board[sidePosition][this.width - 1]; break;
			default: tile = board[this.height - 1][sidePosition];
		}

		return tile;
	}

	private boolean isVerticalSide(int side) {
		return side == 0 || side == 2;
	}

	private void minelaying(int minesCount) {
		int placedMines = 0;

		System.out.printf("Минирам с %d мини... ", minesCount);

		for (Tile[] tiles : board) {
			for (Tile tile : tiles) {
				if (placedMines == minesCount) {
					System.out.println();
					return;
				}

				if (random.nextBoolean() && (!tile.isSpecial() && !tile.hasMine())) {
					tile.setMine();
					placedMines++;
				}
			}
		}

		System.out.printf("%d поставени. %n", placedMines);

		if (placedMines < minesCount) {
			minelaying(minesCount - placedMines);
		}
	}

	public void printBoard() {
		int horizontalOffset = 4;
		if (height > 9) horizontalOffset = 5;

		System.out.print(getRepeatingChar(" ", horizontalOffset));
		for (int j = 0; j < width; j++) {
			System.out.printf("%02d ", j);
		}
		System.out.println();
		System.out.print(getRepeatingChar("-", horizontalOffset));
		for (int j = 0; j < width; j++) {
			System.out.print("---");
		}
		System.out.println();

		for (int i = 0; i < height; i++) {
			System.out.printf("%d | ", i);

			for (int j = 0; j < width; j++) {
				System.out.printf("%s  ", board[i][j].getSymbol());
			}

			System.out.println();
		}
	}

	private String getRepeatingChar(String repeatingChar, int repeats) {
		String result = "";
		for (int i = 0; i < repeats; i++) {
			result += repeatingChar;
		}

		return result;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Tile getTile(int row, int col) {
		if (row >= height || row < 0 || col >= width || col < 0) {
			return null;
		}

		return board[row][col];
	}

	public Tile getCurrentTile() {
		return currentTile;
	}

	public void setCurrentTile(Tile currentTile) {
		this.currentTile.visit();
		this.currentTile.clearCurrent();
		this.currentTile = currentTile;
		this.currentTile.setCurrent();
	}

	public Tile getFinishTile() {
		return finishTile;
	}

	public int getDisposals() {
		return disposals;
	}

	public int getProbes() {
		return probes;
	}

	public void decDisposals() {
		this.disposals--;
	}

	public void decProbes() {
		this.probes--;
	}

	public boolean isBoom() {
		return boom;
	}

	public void boom() {
		this.boom = true;
	}
}
