package org.space.invaders.states.gamestates;

import com.googlecode.lanterna.screen.Screen;
import org.space.invaders.control.Controller;
import org.space.invaders.model.game.SpaceShip;
import org.space.invaders.states.State;

import javax.swing.plaf.PanelUI;
import java.io.IOException;

public class GameControllerState implements State {

   // private final Controller controller;
    private Screen screen;
    private SpaceShip spaceShip;
    private static final int FRAME_RATE = 30; // Frames per second
    private static final long FRAME_TIME = 1000000000 / FRAME_RATE;
    @Override
    public void run() throws IOException {

    }

    @Override
    public void nextState()
    {

    }
}
