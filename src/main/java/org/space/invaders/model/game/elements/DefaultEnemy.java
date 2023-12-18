package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.view.game.DefaultEnemyView;

public class DefaultEnemy extends Element {
    private DefaultEnemyView defaultEnemyView;
    public DefaultEnemy(int x, int y, int Yvelocity, int Xvelocity, int Health, int SpawnRate, boolean alive, int height, int width) {
        super(x, y, Yvelocity, Xvelocity, Health, SpawnRate, alive, height, width , 150);
    }

    public DefaultEnemy() {
        super(0, 0, 0, 0, 0, 0, true, 0, 0 , 150);
    }

    public void draw(TextGraphics textGraphics) {
        defaultEnemyView = new DefaultEnemyView(this, textGraphics);
        defaultEnemyView.drawDefaultEnemy();
    }

    @Override
    public String[] getDesign() {
        return defaultEnemyView.getDesign();
    }

    public DefaultEnemyView getDefaultEnemyView(){
        return this.defaultEnemyView;
    }

    public void setDefaultEnemyView(DefaultEnemyView defaultEnemyView){
       this.defaultEnemyView = defaultEnemyView;
    }
}
