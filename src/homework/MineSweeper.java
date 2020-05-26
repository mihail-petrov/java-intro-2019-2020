package homework;

public class MineSweeper {
	private static EnemyTerritory enemyTerritory = new EnemyTerritory();
	private static Configurations configurations = new Configurations();

	public static void main(String[] args) {

		System.out.println("Невидима заплаха");
		System.out.println("===================");
		System.out.printf("Размери на полето: %dx%d %n", enemyTerritory.getWidth(), enemyTerritory.getHeight());
		System.out.printf("Брой на мините: %d %n", enemyTerritory.getMinesCount());
		System.out.printf("Брой на опитите: %d %n", configurations.getProbesCount());
		System.out.printf("Брой на обезврежданията: %d %n", configurations.getDisposalsCount());

		GameBoard gameBoard = new GameBoard(enemyTerritory.getHeight(),
				enemyTerritory.getWidth(), enemyTerritory.getMinesCount()
		);

		gameBoard.printBoard();
	}
}
