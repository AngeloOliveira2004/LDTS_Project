package org.space.invaders.control;

import org.space.invaders.model.game.menu.MenuModel;
import org.space.invaders.states.State;
import org.space.invaders.states.menustates.MenuState; // Assuming MainMenuState is the initial state
import org.space.invaders.view.Viewer;
import org.space.invaders.gui.GUI;
import org.space.invaders.Game;

import java.io.IOException;

public class Controller<T> {
    private State state;
    private T model;
    private Viewer viewer;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void run(GUI gui) throws IOException {
        if(state == null){
            state = new MenuState((MenuModel) model,gui);
            state.startScreen();
        }
        while (state != null) {
            viewer = state.getViewer();

            // Updates all the variables sent to the menu, like time, score, super shot charge, etc...
            while (state.isRunning()) {
                state.step();
            }

            gui.close();

            // Logic for going to the next state
            setState(state.nextState());

            if (state != null) {
                state.startScreen();
            }
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public void step(Game game, GUI.ACTION action){

    }
}
