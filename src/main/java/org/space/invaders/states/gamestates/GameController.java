package org.space.invaders.states.gamestates;

import com.googlecode.lanterna.screen.Screen;
import org.space.invaders.model.game.SpaceShip;
import org.space.invaders.states.StateController;

import java.io.IOException;

public class GameController implements StateController {

   // private final Controller controller;
    private Screen screen;
    private SpaceShip spaceShip;
    private static final long FRAME_TIME = 50;
    @Override
    public void run() throws IOException {

    }

    @Override
    public void nextState()
    {

    }
}
