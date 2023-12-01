package org.space.invaders.states;

import java.io.IOException;


public interface StateController {
    void run() throws IOException;
    void nextState();
}
