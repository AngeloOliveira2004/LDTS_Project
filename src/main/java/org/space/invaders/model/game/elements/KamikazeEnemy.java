package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;

public class KamikazeEnemy extends Element{
    public KamikazeEnemy(int x, int y, int Yvelocity, int Xvelocity, int Health, int SpawnRate, boolean alive, int height, int width) {
        super(x, y, Yvelocity, Xvelocity, Health, SpawnRate, alive, height, width);
    }
    public void draw(TextGraphics textGraphics)
    {

    }
}
