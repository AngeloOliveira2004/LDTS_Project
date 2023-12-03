package org.space.invaders.states;


import org.space.invaders.control.Controller;
import org.space.invaders.view.menu.MenuViewer;

public abstract class State<T> {
    private final T model;
    private final Controller<T> Controller;

    private final MenuViewer<T> menuViewer;


    public State(T model){
        this.model = model;
        this.Controller = getController();
        this.menuViewer = getViewer();
    }
    //Getters for that state MVC's

    public abstract MenuViewer<T> getViewer();
    public abstract Controller<T> getController();
    public abstract T getModel();

    //Controls all the variables that have to be sent from menu to menu
    public abstract void step();
    public abstract void startScreen();
    public abstract boolean isRunning();
    public abstract State<T> nextState();

}
