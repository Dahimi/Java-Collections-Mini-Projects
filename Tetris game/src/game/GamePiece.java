package game;

public class GamePiece {
	private int x ;
	private int y ;
	private int[][] matrix ;
	public GamePiece(int x, int y, int[][] matrix) {
		super();
		this.x = x;
		this.y = y;
		this.matrix = matrix;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int[][] getMatrix() {
		return matrix;
	}
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	public void left(){
	    
	}
	public void right(){
	    
	}
	public void down(){
	    
	}
	public void up(){
	    
	}
	public void rotate(){
	    
	}
	public void downMaximum(){
	    
	}
	public boolean isCurrentPositionAvailable(){
	    return true; 
	}
	public void land(){
	    
	}
}
