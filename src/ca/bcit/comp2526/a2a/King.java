package ca.bcit.comp2526.a2a;

import java.io.File;

/**
 * King piece class.
 * @author Pashan Irani
 * @version 1.0
 */
public class King extends Piece {


    private String image;
    private boolean black;
    
    /**
     * Constructs Piece and sets Image based on color.
     * @param black true if piece is black.
     */
    public King(final boolean black) {
        this.black = black;
        if (black) {
            image = "images" + File.separator + "bK.png";
        } else {
            image = "images" + File.separator + "wK.png";
        }
    }

    /**
     * returns piece.
     * @return code word of piece
     */
    public String getPiece() {
        if (black) {
            return "bK";
        } else {
            return "wK";
        }
    }
    
    /**
     * Return image path of this piece.
     * @return the image path
     */
    public String getImagePath() {
        return image;
    }
    
    /**
     * Returns color of the piece.
     * @return color of the piece
     */
    public String getColor() {
        if (black) {
            return "black";
        } else {
            return "white";
        }
    }

    /**
     * Checks if move is valid.
     * @param currentPosId current position
     * @param moveToId move to position
     */
    public boolean isValidMove(String currentPosId, String moveToId) {
        int[] currentPos = getX_Y(currentPosId);
        int[] moveTo = getX_Y(moveToId);
        System.out.println(Math.abs(moveTo[0] - currentPos[0]) + ", " + Math.abs(moveTo[1] - currentPos[1]));
        if ((Math.abs(moveTo[0] - currentPos[0]) <= 1)
                && (Math.abs(moveTo[1] - currentPos[1]) <= 1)) {
            return true;
        } else {
            return false;
        }
    }
}
