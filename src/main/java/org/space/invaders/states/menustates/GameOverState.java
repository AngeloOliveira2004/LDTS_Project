package org.space.invaders.states.menustates;

import org.space.invaders.control.MenuController;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.GameOverModel;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.states.State;
import org.space.invaders.view.menu.GameOverView;

import java.io.FileWriter;
import java.io.IOException;

public class GameOverState implements State {
    private final GameOverView gameOverVIew;
    MenuGUI gui;
    private MenuController menuController;

    private final GameOverModel gameOverModel;
    public GameOverState(MenuController menuController, MenuGUI gui)
    {
        this.menuController = menuController;
        this.gui = gui;
        this.gameOverModel = new GameOverModel();
        this.gameOverVIew = new GameOverView(gameOverModel , gui.getScreen());
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
                        String path = String.format("%s/%s", System.getProperty("user.dir"), "/src/main/Resources/Leaderboard.txt");
                        writeFinalAcronymToFile(gameOverModel.getNamedAcronym(), path);
                        menuController.setApplicationState(ApplicationState.MainMenu);
                        menuController.changeState(ApplicationState.MainMenu);

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case UP -> {
                        gameOverModel.setAcronymletterUP();
                }
                case DOWN -> {
                    gameOverModel.setAcronymletterDOWN();
                }
                case LEFT -> {
                        gameOverModel.previousOptionIndex();
                }
                case RIGHT -> {
                        gameOverModel.nextOptionIndex();
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

    public static void writeFinalAcronymToFile(String[] acronym, String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            String finalString = acronym[0] + acronym[1] + acronym[2];
            writer.write(finalString + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
