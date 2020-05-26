package homework.config;

import java.io.IOException;

/**
 * Клас за работа с конфигурационен файл за играта Невидима заплаха.
 */
public class EnemyTerritory extends ConfigFile {
	private final int width;
	private final int height;
	private final int minesCount;

	public EnemyTerritory() throws IOException {
		super("enemy_territory.txt");

		width = Integer.parseInt(properties.getProperty("width"));
		height = Integer.parseInt(properties.getProperty("height"));
		minesCount = Integer.parseInt(properties.getProperty("mines"));
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getMinesCount() {
		return minesCount;
	}
}
