package org.spaceInvaders;



import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class Arena {
    private int height;
    private int width;
    private boolean running = true;
    public Arena(int height , int width)
    {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public void draw(TextGraphics screen)
    {

    }
}
