package org.space.invaders.model.game.elements;

import com.googlecode.lanterna.graphics.TextGraphics;

public interface Element {
    void draw(TextGraphics screen);
    int getHealth();
    void setHealth(int health);
    int getSpawnRate();
    void setSpawnRate(int spawnRate);
    double getYVelocity();
    void setYVelocity(double yVelocity);
    double getXVelocity();
    void setXVelocity(double xVelocity);

}

