package ca.bcit.comp2526.a2a;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Controls the visual and interactive aspect of the game.
 * @author Pashan Irani
 * @version 1.0
 */
public class Gui extends JFrame {

    /**
     * serialVersion of GUI.
     */
    private static final long serialVersionUID = -1154461466047177754L;
    private int screenWidth; //screen width in pixels
    private int screenHeight; //screen height in pixels
    private Board gameBoard; 
    private Square[][] squares; //squares on board
    private JPanel board = new JPanel(); //panel to display chess board on
    private JButton[][] gridButtons; //used for squares to take input
    
    /* the colors */
    private Color color1 = Color.decode("#8f0300"); //black
    private Color color2 = Color.decode("#fad481"); //white

    /**
     * Constructor for GUI.
     * @param string window title
     */
    public Gui(final String string, int width, int height, final Board board) {
        super(string);
        gameBoard = board;
        screenWidth = width;
        screenHeight = height;
        setSize(screenWidth, screenHeight); 
        setVisible(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //centers on relative to screen
        setLayout(new BorderLayout());
        this.board.setLayout(new GridLayout(8,8));
        add(this.board, BorderLayout.CENTER);
        squares = board.getSqaure();
        gridButtons = new JButton[squares.length][squares.length];
    }

    /**
     * refreshes window.
     */
    public void refreshWindow() {
        invalidate();
        validate();
        repaint();
    }

    /**
     * Draws Squares.
     */
    public void drawSquares() {
        Boolean setWhite = false;
        board.removeAll();
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) { //Draws grid
                setWhite = squares[i][j].getColor();
                gridButtons[i][j] = new JButton();
                giveButtonAttributes(gridButtons[i][j], setWhite, (i + 1) + "" + (j + 1));
                updateSquarePiece(squares[i][j], gridButtons[i][j]);
                board.add(gridButtons[i][j]);
            }
        }
    }

    /**
     * Sets up buttons visual appearance.
     * @param button the button to update
     * @param black true if square is black; white if false
     * @param id gives square an address
     */
    private void giveButtonAttributes(final JButton button, boolean black, final String id) {
        button.setFocusable(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        //button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.addActionListener(new ButtonClicked(id));
        button.setName(id);

        if (black) {
            button.setBackground(color1);
        } else {
            button.setBackground(color2);
        }
    }

    /**
     * Change button's (square) color.
     * @param color the color to change to
     * @param xaxis location on x axis
     * @param yaxis location on y axis
     */
    public void buttonColorChange(final String color, int xaxis, int yaxis) {
        JButton button = gridButtons[xaxis][yaxis];
        button.setBackground(Color.decode(color));
        refreshWindow();
    }

    /**
     * updates the current square.
     * @param square the square to update
     * @param button the square's visible representation.
     */
    public void updateSquarePiece(final Square square, final JButton button) {
        Piece currentPiece = square.getPiece();
        try {
            button.setIcon(new ImageIcon(currentPiece.getImagePath()));
        } catch (Exception exp) {
            return; //do nothing
        }
    }
    
    public void updateTitle(String string){
        setTitle(string);
    }
    /**
     * Gets location and trigger board to perform logic operation.
     * @author Pashan Irani
     * @version 1.0
     */
    class ButtonClicked implements ActionListener {

        private String id; //Location of clicked square

        /**
         * Sets id to the location of the square clicked.
         * @param id the location of the clicked square
         */
        public ButtonClicked(final String id) {
            this.id = id;
        }

        /**
         * Runs at every click, and sends clicked square id to doGameLogic method in board
         * which deals with logic.
         */
        public void actionPerformed(final ActionEvent event) {      
            gameBoard.doGameLogic(id);
        }
    }
}