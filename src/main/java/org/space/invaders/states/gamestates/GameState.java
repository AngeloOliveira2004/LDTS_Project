package org.space.invaders.states.gamestates;

import com.googlecode.lanterna.screen.Screen;
import org.space.invaders.Game;

import org.space.invaders.control.GameController;
import org.space.invaders.model.Arena;
import org.space.invaders.model.game.SpaceShip;
import org.space.invaders.model.game.elements.NormalSpaceShip;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.states.State;
import org.space.invaders.view.GameViewer;

import java.io.IOException;
import java.sql.SQLOutput;

public class GameState implements State , Runnable{
  private final GameController gameController;
  private GameViewer gameViewer;
  private SpaceShip spaceShip;
  private static final int FRAME_RATE = 15; // Frames per second
  private static final long FRAME_TIME = 1000000000 / FRAME_RATE; // Time per frame in nanoseconds
  private long lastFrameTime;
  private boolean running;
  private Arena arena;
  public GameState(GameController gameController) throws IOException {
         this.arena = new Arena();
         this.running = true;
         this.gameController = gameController;
         this.gameViewer = new GameViewer(this.gameController);
         arena.addObject(new NormalSpaceShip(10, 10, 1, 1, 1, 0 , true , 3 , 3));
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
  //todo passar para aqui as cenas do game viewer praticamente e a cada ciclo desenhar as cenas
    @Override
    public void run() {
        lastFrameTime = System.nanoTime();

        while (running) {
            long now = System.nanoTime();
            long elapsedTime = now - lastFrameTime;

            // Update game logic based on elapsed time
            update(elapsedTime);
            gameViewer.runGameLoop(arena);
            // Draw game elements
            gameViewer.drawElements(arena);
            System.out.println("also here");
            // Refresh the screen
            gameViewer.refresh();
            // Control frame rate
            try {
                Thread.sleep(Math.max(0, (FRAME_TIME - elapsedTime) / 1_000_000)); // Convert nanoseconds to milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lastFrameTime = now;
        }
    }

    private void update(long elapsedTime) {
        // TODO: Implement game state update logic based on elapsed time
    }
    public void close() throws IOException {
        gameViewer.close();
    }
}


