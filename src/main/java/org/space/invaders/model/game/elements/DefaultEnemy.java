package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.view.game.DefaultEnemyView;

public class DefaultEnemy extends Element {
    private DefaultEnemyView defaultEnemyView;

    public DefaultEnemy(int x, int y, int Yvelocity, int Xvelocity, int Health, int SpawnRate, boolean alive, int height, int width) {
        super(x, y, Yvelocity, Xvelocity, Health, SpawnRate, alive, height, width);
    }

    public void draw(TextGraphics textGraphics) {
        defaultEnemyView = new DefaultEnemyView(this, textGraphics);
        defaultEnemyView.drawDefaultEnemy();
    }

    @Override
    public String[] getDesign() {
        return defaultEnemyView.getDesign();
    }
}
