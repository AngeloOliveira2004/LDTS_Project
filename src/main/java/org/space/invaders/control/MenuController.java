package org.space.invaders.control;

import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.Menu;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.states.State;
import org.space.invaders.states.menustates.*;

import java.io.IOException;

public class MenuController {
    private State state;
    private ApplicationState applicationState;
    private Menu menuModel;
    private MenuGUI gui;
    public MenuController() throws IOException {
        try {
            this.gui = new org.space.invaders.gui.Menu(50,25);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.applicationState = ApplicationState.MainMenu;
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
                this.gui.close();
                GameController gameController = new GameController(this);
            }
            case MenuInstructions -> {
                this.applicationState = ApplicationState.MenuInstructions;
                InstructionsState instructionsState = new InstructionsState(this,gui);
                instructionsState.run();
            }
            case MenuLeaderboard -> {
                this.applicationState = ApplicationState.MenuLeaderboard;
                LeaderBoardState leaderBoardState = new LeaderBoardState(this,gui);
                leaderBoardState.run();
            }
            case MenuSettings -> {
                this.applicationState = ApplicationState.MenuSettings;
                SettingsState settingsState = new SettingsState(this,gui);
                settingsState.run();
            }
            case ExitMenu -> {
                this.applicationState = ApplicationState.ExitMenu;
                System.exit(0);
            }
            case MainMenu -> {
                this.applicationState = ApplicationState.MainMenu;
                MenuState menuState = new MenuState(this,gui);
                menuState.run();
            }
            case PauseMenu ->
            {
                this.applicationState = ApplicationState.PauseMenu;
                //PauseMenuState pauseMenuState = new PauseMenuState(this);
            }
            case GameOverMenu ->
            {
                this.applicationState = ApplicationState.GameOverMenu;
                this.gui = new org.space.invaders.gui.Menu(50,25);
                GameOverState gameOverState = new GameOverState(this , gui);
                gameOverState.run();
            }
        }
    }

    public ApplicationState getApplicationState()
    {
        return applicationState;
    }

    public void setApplicationState(ApplicationState applicationState)
    {
        this.applicationState = applicationState;
    }

    }
