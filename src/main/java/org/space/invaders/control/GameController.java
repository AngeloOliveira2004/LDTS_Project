package org.space.invaders.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.creator.EnemiesFactory;
import org.space.invaders.model.game.menu.Menu;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.states.State;
import org.space.invaders.states.gamestates.GameState;

import java.io.IOException;

public class GameController {
    private State state;
    private ApplicationState applicationState;
    MenuController menuController;
    private Menu menuModel;
    private MenuGUI gui;
    private EnemiesFactory enemiesFactory;
    private GameState gameState;

    public GameController(MenuController menuController) throws IOException {
        this.menuController = menuController;
        this.applicationState = ApplicationState.Game;
        this.enemiesFactory = new EnemiesFactory();
    }
    public void changeState(ApplicationState state) throws IOException {
        switch (state)
        {
            case Game -> {
                this.applicationState = ApplicationState.Game;
                if(this.gameState == null)
                {
                    GameState gameState = new GameState(this);
                    this.gameState = gameState;
                    this.state = gameState;
                    this.gameState.run();
                }else
                {
                    gameState.setRunning(true);
                    gameState.setPaused(false);
                    gameState.run();
                }
            }
            case PauseMenu -> {
                this.applicationState = ApplicationState.PauseMenu;
                menuController.changeState(this.applicationState);
                break;
            }
            case MainMenu ->
            {
                this.applicationState = ApplicationState.MainMenu;
                menuController.changeState(this.applicationState);
            }
            case GameOverMenu -> {
                this.applicationState = ApplicationState.GameOverMenu;
                menuController.changeState(this.applicationState);
            }
        }
    }

    public ApplicationState getApplicationState()
    {
        return applicationState;
    }

    public GameState getGameState(){return gameState;}

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
    public void setState(State state){this.state = state;}
    public State getState(){return this.state;}
}
