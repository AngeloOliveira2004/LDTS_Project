package org.space.invaders.states;

import java.io.IOException;

public interface State {
    //Getters for that state MVC's
    //Controls all the variables that have to be sent from menu to menu
    public abstract void step();
    public abstract void startScreen();
    public abstract boolean isRunning();
    public abstract void run() throws IOException;
}