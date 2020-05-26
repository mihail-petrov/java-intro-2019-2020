package homework.menu;

import homework.GameBoard;
import homework.Tile;

public class MenuItemProbe extends MenuItem {
	public MenuItemProbe(String title) {
		super(title);
	}

	public void action(GameBoard gameBoard, Tile targetTile) {
		if (gameBoard.getProbes() <= 0) {
			System.out.println("Свършиха пробите.");
			return;
		}

		targetTile.reveal();
		if (targetTile.getTopNeighbor() != null) targetTile.getTopNeighbor().reveal();
		if (targetTile.getDownNeighbor() != null) targetTile.getDownNeighbor().reveal();
		if (targetTile.getRightNeighbor() != null) targetTile.getRightNeighbor().reveal();
		if (targetTile.getLeftNeighbor() != null) targetTile.getLeftNeighbor().reveal();
	}
}
