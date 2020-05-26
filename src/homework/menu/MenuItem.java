package homework.menu;

import homework.GameBoard;
import homework.Tile;

public class MenuItem {
	private String title;

	public MenuItem(String title) {
		this.title = title;
	}

	public void action(GameBoard gameBoard, Tile targetTile) {
		System.out.println("Невалидно действие");
	}

	public String getTitle() {
		return title;
	}
}
