package org.space.invaders.states;


import org.space.invaders.view.menu.MenuView;

public abstract class State {

    //Getters for that state MVC's

    // public abstract Viewer getViewer();
    // public abstract Controller getController();
    // public abstract Model getModel();

    //Controls all the variables that have to be sent from menu to menu
    public abstract void step();
    public abstract void changeScreen();
    public abstract boolean isRunning();
    public abstract State nextState();



}
