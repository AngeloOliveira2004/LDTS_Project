package org.space.invaders.states.gamestates;

import com.googlecode.lanterna.screen.Screen;
import org.space.invaders.Game;

import org.space.invaders.control.GameController;
import org.space.invaders.model.game.SpaceShip;
import org.space.invaders.states.State;
import org.space.invaders.view.menu.MenuViewer;

import java.io.IOException;

public class GameState implements State {

private final GameController gameController;
 private Screen screen;
 private SpaceShip spaceShip;
 private static final long FRAME_TIME = 50;

 public GameState(GameController gameController) {
   this.gameController = gameController;
 }
 public MenuViewer getViewer() {
  return null;
 }

 public GameController getController() {
   return gameController;
 }

 public Game getModel() {
  return null;
 }

 @Override
 public void step() {

 }

 @Override
 public void startScreen() {

 }

 @Override
 public boolean isRunning() {
  return false;
 }

 @Override
 public void run() throws IOException {

 }
}
