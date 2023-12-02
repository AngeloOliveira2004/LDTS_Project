package org.space.invaders.states;


import org.space.invaders.control.Controller;
import org.space.invaders.model.Model;
import org.space.invaders.view.Viewer;
import org.space.invaders.view.menu.MenuView;

public abstract class State {

    //Getters for that state MVC's

    public abstract Viewer getViewer();
    public abstract Controller getController();
    public abstract Model getModel();
    //Controls all the variables that have to be sent from menu to menu
    public abstract void step();
    public abstract void startScreen();
    public abstract boolean isRunning();
    public abstract State nextState();



}
