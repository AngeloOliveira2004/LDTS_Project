package org.space.invaders.view;

import org.space.invaders.gui.GUI;
import org.space.invaders.gui.MenuGUI;

import java.io.IOException;

public abstract class Viewer<T>{
    private final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void drawMenu(GUI gui) throws IOException {
        gui.clear();
        drawElements(gui);
        //gui.refresh();
    }

    protected abstract void drawElements(GUI gui);
}

