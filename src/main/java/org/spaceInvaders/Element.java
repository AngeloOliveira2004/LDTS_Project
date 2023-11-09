package org.spaceInvaders;

import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    private Position position;

    private int Health , SpawnRate;
    private double Yvelocity , Xvelocity;

    public Element(int x, int y , double Yvelocity , double Xvelocity , int Health , int SpawnRate)
    {
        position = new Position(x,y);
        this.Yvelocity = Yvelocity;
        this.Xvelocity = Xvelocity;
        this.Health = Health;
        this.SpawnRate = SpawnRate;
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    public void draw(TextGraphics screen)
    {
       screen.fill(' ');
    }
}
