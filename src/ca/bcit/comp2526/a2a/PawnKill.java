package ca.bcit.comp2526.a2a;

import java.io.File;

/**
 * Pawn piece class.
 * @author Pashan Irani
 * @version 1.0
 */
public abstract class PawnKill extends Piece {


    private String image;
    private static boolean black;
    private int charge = 1;

    /**
     * Constructs Piece and sets Image based on color.
     * @param black true if piece is black.
     */
    public PawnKill(final boolean black) {
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
    public static boolean isValidKill(String currentPosId, String moveToId, String black) {
        int[] currentPos = getX_Y(currentPosId);
        int[] moveTo = getX_Y(moveToId);

        if (moveTo[1] != currentPos[1] && Math.abs(moveTo[1] - currentPos[1]) == 1) {
            System.out.println("{PPAWWWN KILLL: " + (moveTo[0] - currentPos[0]));
            if (black.equalsIgnoreCase("black") && (moveTo[0] - currentPos[0]) == 1) {
                return true;
            } else if (black.equals("white") && moveTo[0] - currentPos[0] == -1 ) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
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

    protected boolean checkIfPathClear(int[] currentPos, int[] moveTo, int xy) {  
        int stepCount;
        stepCount = moveTo[xy] - currentPos[xy];
        System.out.println(stepCount + " XY: " + xy);
        return checkInDirectionStraight(stepCount, getVector(stepCount), xy, currentPos, false);
    }
}
