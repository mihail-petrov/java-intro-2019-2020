package homework;

import homework.menu.MenuItem;
import homework.menu.MenuItemDisposal;
import homework.menu.MenuItemPass;
import homework.menu.MenuItemProbe;

import java.util.Scanner;

public class MineSweeper {
	private static EnemyTerritory enemyTerritory = new EnemyTerritory();
	private static Configurations configurations = new Configurations();
	private static GameBoard gameBoard = new GameBoard(enemyTerritory.getHeight(),
			enemyTerritory.getWidth(), enemyTerritory.getMinesCount(), configurations.getDisposalsCount(),
			configurations.getProbesCount());

	private static Scanner scanner = new Scanner(System.in);

	private static MenuItem[] actionOptions = {
			new MenuItemProbe("Проба"),
			new MenuItemDisposal("Обезвреждане"),
			new MenuItemPass("Премини")
	};

	public static void main(String[] args) {

		System.out.println("Невидима заплаха");
		System.out.println("===================");
		System.out.printf("Размери на полето: %dx%d %n", enemyTerritory.getWidth(), enemyTerritory.getHeight());
		System.out.printf("Брой на мините: %d %n", enemyTerritory.getMinesCount());
		System.out.printf("Брой на опитите: %d %n", configurations.getProbesCount());
		System.out.printf("Брой на обезврежданията: %d %n", configurations.getDisposalsCount());

		play();
	}

	private static MenuItem readMenuChoice() {
		System.out.println("Изберете действие");
		System.out.println("-----------------");
		for (int i = 0; i < actionOptions.length; i++) {
			MenuItem menuItem = actionOptions[i];
			System.out.printf("[%d] %s %n", i+1, menuItem.getTitle());
		}

		int option = readInt("Въведете опция: ", 1, actionOptions.length);

		return actionOptions[option - 1];
	}

	private static void play() {
		do {
			gameBoard.printBoard();

			Tile targetTile = readTargetTile();
			MenuItem menuItem = readMenuChoice();

			menuItem.action(gameBoard, targetTile);
		} while (gameBoard.getCurrentTile() != gameBoard.getFinishTile() && !gameBoard.isBoom());

		gameBoard.printBoard();

		System.out.println("G A M E  O V E R");

		if (gameBoard.isBoom()) {
			System.out.println("@@@@ You lost @@@@");
		} else {
			System.out.println("~~~~ You won ~~~~");
		}
	}

	private static Tile readTargetTile() {
		int row;
		int col;
		Tile targetTile;

		do {
			row = readInt("Целева позиция [ред]: ", 0, gameBoard.getHeight() - 1);
			col = readInt("Целева позиция [колона]: ", 0, gameBoard.getWidth() - 1);
			targetTile = gameBoard.getTile(row, col);

			if (!gameBoard.getCurrentTile().isNeighbor(targetTile)) {
				System.out.println("Невалидна позиция. Опитайте отново.");
			}

		} while (!gameBoard.getCurrentTile().isNeighbor(targetTile));

		return targetTile;
	}

	private static int readInt(String prompt, int minValue, int maxValue) {
		int value;

		do {
			System.out.print(prompt);
			value = scanner.nextInt();
			scanner.nextLine();
		} while (value < minValue || value > maxValue);

		return value;
	}
}