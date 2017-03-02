package ca.bcit.comp2526.a2a;

import java.io.File;

/**
 * Pawn piece class.
 * @author Pashan Irani
 * @version 1.0
 */
public class Pawn extends Piece {


    private String image;
    private boolean black;
    private int charge = 1;
    /**
     * Constructs Piece and sets Image based on color.
     * @param black true if piece is black.
     */
    public Pawn(final boolean black) {
        this.black = black;
        if (black) {
            image = "images" + File.separator + "bP.png";
        } else {
            image = "images" + File.separator + "wP.png";
        }
    }

    /**
     * returns piece.
     * @return code word of piece
     */
    public String getPiece() {
        if (black) {
            return "bP";
        } else {
            return "wP";
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
        if (canCharge(currentPos)) {
            if (moveTo[1] == currentPos[1]) {
                if (moveTo[0] - currentPos[0] >= -2 
                        && moveTo[0] - currentPos[0] < 0 
                        && !black) {
                    return true;
                } else if (moveTo[0] - currentPos[0] <= 2 
                        && moveTo[0] - currentPos[0] > 0 
                        && black) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            if (moveTo[1] == currentPos[1]) {
                if (moveTo[0] - currentPos[0] == -1 && !black) {
                    return true;
                } else if (moveTo[0] - currentPos[0] == 1 && black) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
    
    /**
     * Checks if piece can charge.
     * @param currentPos current position of piece
     * @return if piece can change
     */
    private boolean canCharge(int[] currentPos) {
        if (currentPos[0] == 6 && !black) {
            return true; 
        } else if (currentPos[0] == 1 && black) {
            return true;
        } else {
            return false;
        }
    }
}
