package org.space.invaders.view.menu;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.view.Viewer;

import java.io.IOException;

public abstract class MenuViewer<T> extends Viewer {
    private T model;

    protected final Screen screen;
    protected TextGraphics textGraphics;

    public MenuViewer(T model, Screen screen){
        this.model = model;
        this.screen = screen;
        this.textGraphics = this.screen.newTextGraphics();
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public Screen getScreen(){
        return screen;
    }

    public TextGraphics getTextGraphics(){
        return textGraphics;
    }

    public void draw(MenuGUI gui) throws IOException {
        gui.clear();
        drawElements(gui);
        gui.refresh();
    }

    protected abstract void drawElements(MenuGUI gui);

}
