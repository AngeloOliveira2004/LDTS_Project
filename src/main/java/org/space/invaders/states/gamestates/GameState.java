package org.space.invaders.states.gamestates;

import com.googlecode.lanterna.screen.Screen;
import org.space.invaders.Game;
import org.space.invaders.control.MenuController;
import org.space.invaders.model.game.SpaceShip;
import org.space.invaders.model.game.menu.MenuModel;
import org.space.invaders.states.State;
import org.space.invaders.view.Viewer;

public class GameState extends State<Game> {

 // private final Controller controller;
 private Screen screen;
 private SpaceShip spaceShip;
 private static final long FRAME_TIME = 50;

 public GameState(Game model) {
  super(model);
 }

 //TODO

 ;

 @Override
 public Viewer getViewer() {
  return null;
 }

 @Override
 public MenuController getController() {
  return null;
 }

 @Override
 public MenuModel getModel() {
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
 public State nextState() {

  return null;
 }
}