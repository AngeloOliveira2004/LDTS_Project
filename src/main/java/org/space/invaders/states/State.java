package org.space.invaders.states;

import org.space.invaders.Game;

import java.io.IOException;


public interface State {
    void run() throws IOException;
    void nextState();
}
