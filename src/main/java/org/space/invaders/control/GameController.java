package org.space.invaders.control;

import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.Menu;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.states.State;
import org.space.invaders.states.gamestates.GameState;
import org.space.invaders.states.menustates.InstructionsState;
import org.space.invaders.states.menustates.LeaderBoardState;
import org.space.invaders.states.menustates.MenuState;
import org.space.invaders.states.menustates.SettingsState;

import java.io.IOException;

public class GameController {

    private State state;
    private ApplicationState applicationState;
    MenuController menuController;
    private Menu menuModel;
    private MenuGUI gui;
    public GameController(MenuController menuController) throws IOException {
        this.menuController = menuController;
        this.applicationState = ApplicationState.Game;
        changeState(applicationState);
    }
    /*
        public void run(MenuGUI gui) throws IOException {
            if(state == null){
                state = new MenuState((MenuModel) model,gui);
                state.startScreen();
            }
            while (state != null) {
                menuViewer = state.getViewer();

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

     */
    public void changeState(ApplicationState state) throws IOException {
        switch (state)
        {
            case Game -> {
                this.applicationState = ApplicationState.Game;
                GameState gameState = new GameState(this);
            }
            case PauseMenu -> {
                this.applicationState = ApplicationState.MainMenu;
                menuController.changeState(this.applicationState);
            }
        }
    }

    public ApplicationState getApplicationState()
    {
        return applicationState;
    }

}
