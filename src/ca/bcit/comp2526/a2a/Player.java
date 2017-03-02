package ca.bcit.comp2526.a2a;

public abstract class Player {
    protected String color;
    
    public Player(String color) {
        this.color = color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
}
