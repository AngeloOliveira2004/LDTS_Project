package org.space.invaders.controller;

import org.space.invaders.Dimensions;

public interface Controller{
    public abstract void processKey(boolean menu , com.googlecode.lanterna.input.KeyStroke key);

}
