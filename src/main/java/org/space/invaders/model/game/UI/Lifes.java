package org.space.invaders.model.game.UI;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.view.game.LifesView;
import org.space.invaders.view.game.TimeView;

import java.io.IOException;

public class Lifes {
    private int lifes;
    public Lifes()
    {
        this.lifes = 1;
    }
    public void decrementLifes(){this.lifes--;}
    public void incrementLifes(){this.lifes++;}
    public int getLifes() {
        return lifes;
    }
    public void draw(TextGraphics textGraphics) throws IOException {
        LifesView lifesView = new LifesView(this, textGraphics);
        lifesView.draw();
    }
}
