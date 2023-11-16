package org.space.invaders.controller;

public abstract class Controller {
    protected final static int screenHeight = 50;
    protected final static int screenWidth = 100;
    public void processKey(boolean menu , com.googlecode.lanterna.input.KeyStroke key) {
        if(menu)
        {
        }
    }

}
