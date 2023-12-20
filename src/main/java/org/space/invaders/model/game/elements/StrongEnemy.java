package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.view.game.DefaultEnemyView;
import org.space.invaders.view.game.StrongEnemyView;

public class StrongEnemy extends Element {
    private StrongEnemyView strongEnemyView;

    public StrongEnemy(int x, int y, int Yvelocity, int Xvelocity, int Health, int SpawnRate, boolean alive, int height, int width) {
        super(x, y, Yvelocity, Xvelocity, Health, SpawnRate, alive, height, width , 250);
    }

    public StrongEnemy() {
        super(0, 0, 0, 0, 0, 0, true, 0, 0 , 150);
    }

    public void draw(TextGraphics textGraphics) {
        strongEnemyView = new StrongEnemyView(this, textGraphics);
        strongEnemyView.drawStrongEnemy();
    }

    @Override
    public String[] getDesign() {
        return strongEnemyView.getDesign();
    }

    public StrongEnemyView getStrongEnemyView(){
        return this.strongEnemyView;
    }

    public void setStrongEnemyView(StrongEnemyView strongEnemyView){
        this.strongEnemyView = strongEnemyView;
    }
}

