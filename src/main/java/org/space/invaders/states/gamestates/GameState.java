package org.space.invaders.states.gamestates;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

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

import java.io.FileWriter;
import java.io.IOException;

public class GameState implements State {
  private GameController gameController;
  private GameViewer gameViewer;
  private SpaceShip spaceShip;
  private PlayerController playerController;
  private static final int FRAME_RATE = 30; // Frames per second
  private static final long FRAME_TIME = 1000000000 / FRAME_RATE; // Time per frame in nanoseconds
  private long lastFrameTime;
  private boolean running;
  private Arena arena;
  private EnemiesController enemiesController;
  private boolean isPaused;
  public GameState(GameController gameController) throws IOException {
         spaceShip = new SpaceShip(275, 200, 3, 1, 1, 0 , true , 3 , 3);
         this.arena = new Arena();
         this.running = true;
         this.gameController = gameController;
         this.gameViewer = new GameViewer(this.gameController);
         this.playerController = new PlayerController(spaceShip);
         arena.addObject(spaceShip);
         this.enemiesController = new EnemiesController(this.arena , new EnemiesFactory() , new ShotFactory());
         this.isPaused = false;
  }
  public GameController getController() {
    return gameController;
  }

  public void step() {

  }
  public void startScreen()
  {

  }
  public void setRunning(boolean running){this.running = running;}
  public boolean getRunning(){return this.running;}
  public boolean isRunning()
  {
      return running;
  }

public void run() throws IOException{
    lastFrameTime = System.nanoTime();
    while (running) {
        long now = System.nanoTime();
        long elapsedTime = now - lastFrameTime;
        arena.update(spaceShip);

        enemiesController.KamizeSpawner(spaceShip.getPosition());
        enemiesController.DefaultEnemySpawner();
        enemiesController.StrongEnemySpawner();

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

    @Override
    public void close() throws IOException {

    }

    private void handleInput(KeyStroke keyStroke) throws IOException {
        if(arena.getLifes().getLifes() == 0)
        {
            gameViewer.close();
            String path = String.format("%s/%s", System.getProperty("user.dir"), "/src/main/Resources/Leaderboard.txt");
            writeFinalScoreToFile(arena.getScore().getScore(),path);
            gameController.changeState(ApplicationState.GameOverMenu);
        }
        if (keyStroke != null) {
            if (keyStroke.getKeyType() == KeyType.Escape || keyStroke.getKeyType() == KeyType.EOF) {
                running = false;
                gameController.changeState(ApplicationState.PauseMenu);
            }else
            {
                playerController.keyPressed(keyStroke , arena);
            }
        }
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public static void writeFinalScoreToFile(long finalScore, String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            int writeValue = (int) finalScore;
            writer.write(String.valueOf(finalScore) + ",");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }
    public void setGameViewer(GameViewer gameViewer) throws IOException {
        this.gameViewer = new GameViewer(gameController);
    }

    public void setPlayerController(PlayerController mock) {
      this.playerController = mock;
    }

    public void setArena(Arena arena) {
      this.arena = arena;
    }
}


