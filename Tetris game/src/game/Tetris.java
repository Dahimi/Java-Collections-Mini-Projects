package game;

public class Tetris {
	private GamePiece gamePiece ;
	private Field field ;
	public static Tetris game ;
	public GamePiece getGamePiece() {
		return gamePiece;
	}
	public void setGamePiece(GamePiece gamePiece) {
		this.gamePiece = gamePiece;
	}
	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	public void run(){
	    
	}
	public void step(){
	    
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tetris.game = new Tetris();
		Tetris.game.run();
	}

}
