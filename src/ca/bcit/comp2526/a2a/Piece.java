package ca.bcit.comp2526.a2a;

/**
 * Abstract class for each piece.
 * @author Pashan Irani
 * @version 1.0
 */
public abstract class Piece {

    public abstract String getPiece();
    
    public abstract String getImagePath();
    
    public abstract boolean isValidMove(String currentPos, String moveTo);
    
    public abstract String getColor();
    /**
     * Checks if two pieces are equal.
     * @return pieces are equal
     */
    public boolean is(final String object) {
        if (this.getPiece().equalsIgnoreCase(object)) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Gets X and Y from ID, so 16 will be X = 1, Y = 6.
     * @param id concatenated id
     * @return x and y in an array of length 2
     */
    protected int[] getX_Y(final String id) {
        int[] points = new int[2];
        points[0] = Integer.parseInt("" + id.charAt(0)) - 1;
        points[1] = Integer.parseInt("" + id.charAt(1)) - 1;
        return points;
    }
}
