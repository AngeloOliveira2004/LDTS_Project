package org.space.invaders.states;


import org.space.invaders.control.Controller;
import org.space.invaders.model.game.menu.MenuModel;
import org.space.invaders.view.Viewer;

public abstract class State<T> {
    private final T model;
    private final Controller<T> controller;

    private final Viewer<T> viewer;


    public State(T model){
        this.model = model;
        this.controller = getController();
        this.viewer = getViewer();
    }
    //Getters for that state MVC's

    public abstract Viewer<T> getViewer();
    public abstract Controller<T> getController();
    public abstract MenuModel getModel();

    //Controls all the variables that have to be sent from menu to menu
    public abstract void step();
    public abstract void startScreen();
    public abstract boolean isRunning();
    public abstract State<T> nextState();

}
