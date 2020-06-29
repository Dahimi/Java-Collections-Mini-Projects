package game;
import java.util.*;

/**
 * The Field class describes the Tetris game field
 */
public class Field {
    // Width and height
    private int width;
    private int height;

    // Matrix representing the field: 1 means that part of the field is occupied, 0 means it is available
    private int[][] matrix;

    public Field(int height, int width) {
        this.width = width;
        this.height = height;
        matrix = new int[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    /**
     * The method returns the value of the matrix at coordinates (x, y)
     * If the coordinates are outside the matrix, the method returns null.
     */
    public Integer getValue(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height)
            return matrix[y][x];

        return null;
    }

    /**
     * The method sets the matrix cell with coordinates (x, y) to the passed value
     */
    public void setValue(int x, int y, int value) {
        if (x >= 0 && x < width && y >= 0 && y < height)
            matrix[y][x] = value;
    }

    /**
     * The method displays the current contents of the matrix on the screen
     */
    public void print() {
        // Create an array where we will "draw" the current game state
        int[][] canvas = new int[height][width];

        // Copy the game field matrix into the array
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                canvas[i][j] = matrix[i][j];
            }
        }

        // Copy the game piece into the array, only the non-empty cells
        int left = Tetris.game.getGamePiece().getX();
        int top = Tetris.game.getGamePiece().getY();
        int[][] brickMatrix = Tetris.game.getGamePiece().getMatrix();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (top + i >= height || left + j >= width) continue;
                if (brickMatrix[i][j] == 1)
                    canvas[top + i][left + j] = 2;
            }
        }


        // Display what we've "drawn", but start from the edge of the frame.
        System.out.println("---------------------------------------------------------------------------\n");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int index = canvas[i][j];
                if (index == 0)
                    System.out.print(" . ");
                else if (index == 1)
                    System.out.print(" X ");
                else if (index == 2)
                    System.out.print(" X ");
                else
                    System.out.print("???");
            }
            System.out.println();
        }


        System.out.println();
        System.out.println();
    }

    /**
     * Remove the completed lines
     */
    public void removeFullLines() {
        // For example, like this:
        // Create a list to store the lines
        // Copy all the non-empty lines into a list.
        // Add incomplete lines to the beginning of the list.
        // Convert the list back into a matrix
        List<int[]> copyList = new ArrayList<int[]>();
        for (int i = 0; i < height; i++){
            if(!isFullLine(matrix[i])) copyList.add(matrix[i]);
        }
        // le nombre effectif des ligne supprime
        int numberRemovedLine = height - copyList.size();
       matrix = new int[height][width] ;
       for(int i = 0 ; i < numberRemovedLine ; i++) matrix[i] = new int[width];
       for(int i = 0 ; i <  copyList.size(); i++) matrix[numberRemovedLine + i] = copyList.get(i);
        
    }
    private boolean isFullLine(int[] row){
        for(int j = 0 ; j < row.length ; j++){
           if(row[j] == 0) return false ; 
        }
        return true;
    }
}