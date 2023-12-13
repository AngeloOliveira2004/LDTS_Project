package org.space.invaders.states;

import java.io.IOException;

public interface State {
    public abstract void step();
    public abstract void startScreen();
    public abstract boolean isRunning();
    public abstract void run() throws IOException;

    void close() throws IOException;
}