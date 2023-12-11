package org.space.invaders.states.menustates;

import org.space.invaders.control.MenuController;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.GameOverModel;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.states.State;
import org.space.invaders.view.menu.GameOverVIew;

import java.io.IOException;

public class GameOverState implements State {
    private final GameOverVIew gameOverVIew;
    MenuGUI gui;
    private MenuController menuController;

    private final GameOverModel gameOverModel;
    public GameOverState(MenuController menuController, MenuGUI gui)
    {
        this.menuController = menuController;
        this.gui = gui;
        this.gameOverModel = new GameOverModel();
        this.gameOverVIew = new GameOverVIew(gameOverModel , gui.getScreen());
    }
    @Override
    public void step() {
        MenuGUI.ACTION action;
        try {
            action = gui.getNextAction();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(action != MenuGUI.ACTION.NONE){
            gui.clear();
            Action(action);
            gameOverVIew.drawElements(gui);
        }
    }
    public void Action(MenuGUI.ACTION action) {
        if(action != null) {
            switch (action) {
                case ENTER -> {
                    try {
                        menuController.setApplicationState(ApplicationState.MainMenu);
                        menuController.changeState(ApplicationState.MainMenu);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
    @Override
    public void startScreen() {
        gameOverVIew.drawElements(gui);
        gui.refresh();
    }

    @Override
    public boolean isRunning() {
        return true;
    }

    @Override
    public void run() throws IOException {
        while (menuController.getApplicationState() == ApplicationState.GameOverMenu)
        {
            gameOverVIew.drawElements(gui);
            gui.refresh();
            step();
        }
    }

    @Override
    public void close() throws IOException {
        gui.close();
    }
}
