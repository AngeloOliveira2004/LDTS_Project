package org.space.invaders.states.gamestates;

import com.googlecode.lanterna.screen.Screen;
import org.space.invaders.Game;

import org.space.invaders.control.GameController;
import org.space.invaders.model.game.SpaceShip;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.states.State;
import org.space.invaders.view.GameViewer;

import java.io.IOException;

public class GameState implements State {
  private final GameController gameController;
  private GameViewer gameViewer;
  private SpaceShip spaceShip;
  private static final int FRAME_RATE = 15; // Frames per second
  private static final long FRAME_TIME = 1000000000 / FRAME_RATE; // Time per frame in nanoseconds
  private long lastFrameTime;
  private boolean running;
  public GameState(GameController gameController) throws IOException {
     this.running = true;
     this.gameController = gameController;
     this.gameViewer = new GameViewer(this.gameController);
  }

  public GameController getController() {
    return gameController;
  }

  public void step() {

  }
  public void startScreen()
  {

  }
  public boolean isRunning()
  {
      return running;
  }
  public void run()
  {
      while (gameController.getApplicationState() == ApplicationState.Game)
      {
        /*
        gameViewer.drawElements(gui);
        gui.refresh();
        step();

         */
      }
  }
}

