package org.space.invaders.model.game.UI;

public class Lifes {
    private int lifes;
    public Lifes()
    {
        this.lifes = 3;
    }
    public void decrementLifes(){this.lifes--;}
    public void incrementLifes(){this.lifes++;}
    public int getLifes() {
        return lifes;
    }
}
