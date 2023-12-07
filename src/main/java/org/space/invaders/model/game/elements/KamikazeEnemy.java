package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.view.game.KamikazeView;

import java.io.IOException;

public class KamikazeEnemy extends Element{
    private KamikazeView kamikazeView;
    public KamikazeEnemy(int x, int y, int Yvelocity, int Xvelocity, int Health, int SpawnRate, boolean alive, int height, int width) {
        super(x, y, Yvelocity, Xvelocity, Health, SpawnRate, alive, height, width);
    }
    public void draw(TextGraphics textGraphics) {
        kamikazeView = new KamikazeView(this , textGraphics);
        kamikazeView.drawKamikaze();
    }

    @Override
    public String[] getDesign() {
        return kamikazeView.getDesign();
    }
}
