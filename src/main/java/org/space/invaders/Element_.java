package org.space.invaders;

import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element_ extends Position {
    private int health;
    private int spawnRate;
    private double yVelocity;
    private double xVelocity;
    public Element_(int x, int y, double yVelocity, double xVelocity, int health, int spawnRate) {
        super(x, y);
        this.yVelocity = yVelocity;
        this.xVelocity = xVelocity;
        this.health = health;
        this.spawnRate = spawnRate;
    }

    public void draw(TextGraphics screen) {
        screen.fill(' ');
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getSpawnRate() {
        return spawnRate;
    }

    public void setSpawnRate(int spawnRate) {
        this.spawnRate = spawnRate;
    }

    public double getYVelocity() {
        return yVelocity;
    }

    public void setYVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    public double getXVelocity() {
        return xVelocity;
    }

    public void setXVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

}
