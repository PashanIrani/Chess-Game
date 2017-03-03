package ca.bcit.comp2526.a2a;

import java.io.File;

/**
 * Rook piece class.
 * @author Pashan Irani
 * @version 1.0
 */
public class Rook extends Piece {


    private String image;
    private boolean black;

    /**
     * Constructs Piece and sets Image based on color.
     * @param black true if piece is black.
     */
    public Rook(final boolean black) {
        this.black = black;
        if (black) {
            image = "images" + File.separator + "bR.png";
        } else {
            image = "images" + File.separator + "wR.png";
        }
    }

    /**
     * returns piece.
     * @return code word of piece
     */
    public String getPiece() {
        if (black) {
            return "bR";
        } else {
            return "wR";
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
        if (currentPos[0] == moveTo[0]  
                && checkIfPathClear(currentPos, moveTo, 1)) { //in testing atm
            System.out.println("left and right");
            return true;
        } else if (currentPos[1] == moveTo[1] 
                && checkIfPathClear(currentPos, moveTo, 0)) {
            System.out.println("up and down");
            return true;
        } else {
            return false;
        }
    }

    protected boolean checkIfPathClear(int[] currentPos, int[] moveTo, int xy) {  
        int stepCount;
        stepCount = moveTo[xy] - currentPos[xy];
        System.out.println(stepCount + " XY: " + xy);
        return checkInDirectionStraight(stepCount, getVector(stepCount), xy, currentPos, false);
    }

    

    
}
