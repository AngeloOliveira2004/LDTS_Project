package org.space.invaders.control;

import org.space.invaders.control.music.MusicController;
import org.space.invaders.control.music.Musics;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.Menu;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.states.State;
import org.space.invaders.states.gamestates.GameState;
import org.space.invaders.states.menustates.*;

import java.io.IOException;


public class MenuController {
    private State state;
    private ApplicationState applicationState;
    private Menu menuModel;
    private MenuGUI gui;
    private GameController gameController;
    private MusicController musicController;
    public MenuController() throws IOException {
        try {
            this.gui = new org.space.invaders.gui.Menu(50,25);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.applicationState = ApplicationState.MainMenu;
        changeState(applicationState);
    }
    public void changeState(ApplicationState state) throws IOException {
        switch (state)
        {
            case Game -> {
                this.musicController.changeMusic(Musics.BACKGROUND);
                this.applicationState = ApplicationState.Game;
                this.gui.close();
                if(this.gameController == null)
                {
                    this.gameController = new GameController(this);
                    this.gameController.changeState(this.applicationState);
                }
                else
                {
                    if(gameController.getGameState().isPaused())
                    {
                        gameController.getGameState().setPaused(false);
                        this.applicationState = ApplicationState.Game;
                        this.gameController.changeState(this.applicationState);
                    }
                    this.applicationState = ApplicationState.Game;
                    this.gameController = new GameController(this);
                    gameController.changeState(this.applicationState);
                }
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
                SettingsState settingsState = new SettingsState(this,gui , musicController);
                settingsState.run();
            }
            case ExitMenu -> {
                this.applicationState = ApplicationState.ExitMenu;
                System.exit(0);
            }
            case MainMenu -> {
                if(this.musicController == null || musicController.getMusics() == Musics.BACKGROUND)
                {
                    this.musicController = new MusicController();
                    musicController.changeMusic(Musics.MENUSOUND);
                }
                musicController.adjustVolume();
                this.applicationState = state;
                if(this.gameController != null)
                {
                    GameState gameState = gameController.getGameState();
                    if(gameState != null)
                    {
                        gameState.close();
                    }
                }
                gameController = null;
                this.applicationState = ApplicationState.MainMenu;
                MenuState menuState = new MenuState(this,gui);
                menuState.run();
            }
            case PauseMenu ->
            {
                gameController.getGameState().setPaused(true);
                this.applicationState = ApplicationState.PauseMenu;
                this.gui = new org.space.invaders.gui.Menu(50,25);
                PauseMenuState pauseMenuState = new PauseMenuState(this , gui);
                pauseMenuState.run();
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

