package game;


public class Field {
	private int width ; 
	private int height ;
	private int[][] matrix ;
	public Field(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.matrix = new int[height][width];
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int[][] getMatrix() {
		return matrix;
	}
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	public void print() {
		
	}
	public void removeFullLines() {
		
	}
	public Integer getValue(int x , int y ) {
		return new Integer(matrix[x][y]);
	}
	public void setValue(int x , int y , int value) {
		matrix[x][y] = value ;
	}
}
