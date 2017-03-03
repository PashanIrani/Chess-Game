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


    Square[][] squares = Board.getSqaure();
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

    protected int not(int num) {
        if (num == 1) {
            return 0;
        } else {
            return 1;
        }
    }

    protected boolean checkInDirectionStraight(int numOfSquares, int vector, 
            int direction, int[] currentPos, boolean diagnal) {
        numOfSquares = Math.abs(numOfSquares);
        int xaxis;
        int yaxis;
        if (diagnal) {
            if (direction != 0) {
                for (int i = 1; i <= numOfSquares; i++) {
                    xaxis = currentPos[0] + (i * vector);
                    yaxis = currentPos[1] + (i * vector);
                    System.out.println(i + "||||| checking square; " 
                            + (xaxis) + ", " 
                            + (yaxis) 
                            + ", VECTROE: " + vector);
                    if (squares[xaxis][yaxis].getPiece() != null) {
                        System.out.println("is NOT NULL");
                        return false;
                    }
                }
            } else {
                for (int i = 1; i <= numOfSquares; i++) {
                    xaxis = currentPos[0] + (i * vector);
                    yaxis = currentPos[1] - (i * vector);
                    System.out.println(i + "||||| checking square; " 
                            + (xaxis) + ", " 
                            + (yaxis) 
                            + ", VECTROE: " + vector);
                    if (squares[xaxis][yaxis].getPiece() != null) {
                        System.out.println("is NOT NULL");
                        return false;
                    }
                }
            }
        } else if (direction == 0 && !diagnal) {
            for (int i = 1; i <= numOfSquares; i++) {
                xaxis = currentPos[0] + (i * vector);
                yaxis = currentPos[1];
                System.out.println(i + "||||| checking square; " 
                        + (xaxis) + ", " 
                        + (yaxis) 
                        + ", VECTROE: " + vector);
                if (squares[xaxis][yaxis].getPiece() != null) {
                    System.out.println("is NOT NULL");
                    return false;
                }
            }
        } else if (direction == 1 && !diagnal) {
            for (int i = 1; i <= numOfSquares; i++) {
                xaxis = currentPos[0];
                yaxis = currentPos[1] + (i * vector);
                System.out.println(i + "||||| checking square; " 
                        + (xaxis) + ", " 
                        + (yaxis) 
                        + ", VECTROE: " + vector);
                if (squares[xaxis][yaxis].getPiece() != null) {
                    System.out.println("is NOT NULL");
                    return false;
                }
            }
        }
        return true;
    }

    protected int getVector(int num) {
        if (num < 0) {
            return -1;
        } else {
            return 1;
        }
    }
}
