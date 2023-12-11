package org.space.invaders.states.gamestates;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import org.space.invaders.control.GameController;
import org.space.invaders.control.command.EnemiesController;
import org.space.invaders.control.game.PlayerController;
import org.space.invaders.model.Arena;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.SpaceShip;
import org.space.invaders.model.game.creator.EnemiesFactory;
import org.space.invaders.model.game.creator.ShotFactory;
import org.space.invaders.states.ApplicationState;
import org.space.invaders.states.State;
import org.space.invaders.view.GameViewer;

import java.io.IOException;
import java.sql.SQLOutput;

public class GameState implements State {
  private final GameController gameController;
  private GameViewer gameViewer;
  private SpaceShip spaceShip;
  private PlayerController playerController;
  private static final int FRAME_RATE = 30; // Frames per second
  private static final long FRAME_TIME = 1000000000 / FRAME_RATE; // Time per frame in nanoseconds
  private long lastFrameTime;
  private boolean running;
  private Arena arena;
  private EnemiesController enemiesController;
  public GameState(GameController gameController) throws IOException {
         spaceShip = new SpaceShip(50, 50, 3, 1, 1, 0 , true , 3 , 3);
         this.arena = new Arena();
         this.running = true;
         this.gameController = gameController;
         this.gameViewer = new GameViewer(this.gameController);
         this.playerController = new PlayerController(spaceShip);
         arena.addObject(spaceShip);
         this.enemiesController = new EnemiesController(this.arena , new EnemiesFactory() , new ShotFactory());
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
public void run() throws IOException{
    lastFrameTime = System.nanoTime();

    while (running) {
        long now = System.nanoTime();
        long elapsedTime = now - lastFrameTime;
        arena.update(spaceShip);

        enemiesController.KamizeSpawner(spaceShip.getPosition());
        enemiesController.DefaultEnemySpawner(new Position(50,50));
        enemiesController.StrongEnemySpawner(new Position(20,20));
        //update(elapsedTime);
        handleInput(gameViewer.handleInput());

        gameViewer.drawElements(arena);
        gameViewer.refresh();
        enemiesController.update();
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
    private void handleInput(KeyStroke keyStroke) throws IOException {
        if (keyStroke != null) {
            if (keyStroke.getKeyType() == KeyType.Escape || keyStroke.getKeyType() == KeyType.EOF) {
                gameViewer.close();
                // Exit the game
                gameController.changeState(ApplicationState.MainMenu);
            }else
            {
                playerController.keyPressed(keyStroke , arena);
            }
        }
    }

}


