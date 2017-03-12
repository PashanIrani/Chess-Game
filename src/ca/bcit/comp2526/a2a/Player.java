package ca.bcit.comp2526.a2a;

public class Player {
    protected String color;
    
    /**
     * Constructs player.
     * @param color the color
     */
    public Player(String color) {
        this.color = color;
    }
    
    /**
     * set's player color.
     * @param color the color to set to
     */
    public void setColor(String color) {
        this.color = color;
    }
}
