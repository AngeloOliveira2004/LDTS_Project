package org.space.invaders.states.gamestates;

import com.googlecode.lanterna.screen.Screen;
import org.space.invaders.model.game.SpaceShip;
import org.space.invaders.states.State;

import java.io.IOException;

public class GameState extends State {

 // private final Controller controller;
 private Screen screen;
 private SpaceShip spaceShip;
 private static final long FRAME_TIME = 50;

 //TODO
 public GameState() {
 }

 ;

 @Override
 public void step() {

 }

 @Override
 public void changeScreen() {

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
