package lecture8.optional.gameoflife;

public class Board {
	private int size;
	private int[][] matrix;
	public Board(int s) {
		this.setSize(s);
		this.generateMatrix();
	}
	
	private void setSize(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
	
	private void generateMatrix() {
		matrix = new int[size][size];
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				matrix[row][col] = (int)Math.floor(Math.random() + 0.5);
			}
		}
	}
	
	private int getNeighbors(int row, int col) {
		int neighbors = 0;
		
		for (int r = row - 1; r < (row + 2); r++) {
			for (int c = col - 1; c < (col + 2); c++) {
				if (r == row && c == col)
					continue;
				int point = getPoint(r, c);
				if (point == 2)
					continue;
				neighbors += point;
			}
		}
		
		return neighbors;
	}
	
	private int getPoint(int row, int col) {
		try {
			return matrix[row][col];
		} catch (ArrayIndexOutOfBoundsException e) {
			return 2;
		}
	}
	
	private int getUpdatedPoint(int row, int col) {
		int state = getPoint(row, col);
		int neighbors = getNeighbors(row, col);
		
		if (state == 0) { // dead
			return (neighbors == 3) ? 1 : 0;
		} else { // live
			return (neighbors == 1 || neighbors > 3) ? 0 : 1;
		}
	}
	
	public void update() {
		int[][] tempMatrix = new int[size][size];
		
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				tempMatrix[row][col] = getUpdatedPoint(row, col);
			}
		}
		
		matrix = tempMatrix;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder("");
		
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				s.append(getPoint(row, col));
				s.append(' ');
			}
			s.append('\n');
		}
		
		return s.toString();
	}
}
