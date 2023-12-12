package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.view.game.DefaultEnemyView;
import org.space.invaders.view.game.PlanetView;

import java.io.IOException;

public class Planet extends Element{

    public Planet(int x, int y, int Yvelocity, int Xvelocity, int Health, int SpawnRate, boolean alive, int height, int width) {
        super(x, y, 0, 0, 10000000, 0, true, 3, 3);
    }

    @Override
    public void draw(TextGraphics textGraphics) throws IOException {
        PlanetView planetView = new PlanetView(this, textGraphics);
        planetView.draw();

    }

    @Override
    public String[] getDesign() {
        return new String[0];
    }
}
