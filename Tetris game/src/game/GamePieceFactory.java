package game;

public class GamePieceFactory {
	  public static GamePiece createRandomGamePiece(int x, int y){
	        return new GamePiece(x ,y , new int[3][3]) ;
	    }
}
