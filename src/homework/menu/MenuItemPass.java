package homework.menu;

import homework.GameBoard;
import homework.Tile;

public class MenuItemPass extends MenuItem {
	public MenuItemPass(String title) {
		super(title);
	}

	public void action(GameBoard gameBoard, Tile targetTile) {
		targetTile.reveal();

		if (!targetTile.hasMine()) {
			gameBoard.setCurrentTile(targetTile);
		} else {
			gameBoard.boom();
		}
	}
}
