package homework;

/**
 * Клас представящ единична плочка от игралното поле
 */
public class Tile {
	private static final char SYM_START    = 'S';
	private static final char SYM_FINISH   = 'F';
	private static final char SYM_VISITED  = '#';
	private static final char SYM_HAS_MINE = 'M';
	private static final char SYM_NO_MINE  = 'O';
	private static final char SYM_CURRENT  = '*';
	private static final char SYM_UNKNOWN  = 'x';

	private boolean start;
	private boolean finish;
	private boolean mine;
	private boolean revealed;
	private boolean visited;
	private boolean current;
	private final int row;
	private final int col;
	private Tile topNeighbor;
	private Tile downNeighbor;
	private Tile rightNeighbor;
	private Tile leftNeighbor;

	public Tile(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart() {
		this.start = true;
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish() {
		this.finish = true;
	}

	public boolean hasMine() {
		return mine;
	}

	public void setMine() {
		this.mine = true;
	}

	public void disposalMine() {
		this.mine = false;
	}

	public boolean isRevealed() {
		return revealed;
	}

	public void reveal() {
		this.revealed = true;
	}

	public boolean isCurrent() {
		return current;
	}

	public void setCurrent() {
		this.current = true;
	}

	public void clearCurrent() {
		this.current = false;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public boolean isVisited() {
		return visited;
	}

	public void visit() {
		this.visited = true;
	}

	public boolean isSpecial() {
		return start || finish;
	}

	public String toString() {
		return String.format("Position: %dx%d [isStart: %s, isFinish: %s, hasMine: %s, isRevealed: %s]",
				row, col, start, finish, mine, revealed);
	}

	public char getSymbol() {
		if (visited) return SYM_VISITED;
		if (start)   return SYM_START;
		if (finish)	 return SYM_FINISH;
		if (current) return SYM_CURRENT;
		if (revealed && mine) return SYM_HAS_MINE;
		if (revealed && !mine) return SYM_NO_MINE;

		return SYM_UNKNOWN;
	}

	public Tile getTopNeighbor() {
		return topNeighbor;
	}

	public void setTopNeighbor(Tile topNeighbor) {
		this.topNeighbor = topNeighbor;
	}

	public Tile getDownNeighbor() {
		return downNeighbor;
	}

	public void setDownNeighbor(Tile downNeighbor) {
		this.downNeighbor = downNeighbor;
	}

	public Tile getRightNeighbor() {
		return rightNeighbor;
	}

	public void setRightNeighbor(Tile rightNeighbor) {
		this.rightNeighbor = rightNeighbor;
	}

	public Tile getLeftNeighbor() {
		return leftNeighbor;
	}

	public void setLeftNeighbor(Tile leftNeighbor) {
		this.leftNeighbor = leftNeighbor;
	}

	public boolean isNeighbor(Tile targetTile) {
		return  this.topNeighbor == targetTile ||
			    this.downNeighbor == targetTile ||
				this.rightNeighbor == targetTile ||
				this.leftNeighbor == targetTile;
	}
}
