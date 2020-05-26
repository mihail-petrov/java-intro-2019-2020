package homework.menu;

import homework.GameBoard;
import homework.Tile;

public class MenuItemDisposal extends MenuItem {
	public MenuItemDisposal(String title) {
		super(title);
	}

	public void action(GameBoard gameBoard, Tile targetTile) {
		if (gameBoard.getDisposals() <= 0) {
			System.out.println("Свършиха обезврежданията.");
			return;
		}

		targetTile.disposalMine();
	}

}
