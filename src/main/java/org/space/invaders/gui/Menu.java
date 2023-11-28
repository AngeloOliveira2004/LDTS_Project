package org.space.invaders.gui;

import javax.swing.text.Position;
import java.io.IOException;

public class Menu implements MenuGUI {
    @Override
    public GUI.ACTION getNextAction() throws IOException {
        return null;
    }

    @Override
    public void drawText(Position position, String text, String color) {

    }
    @Override
    public void clear() {

    }

    @Override
    public void refresh() throws IOException {

    }

    @Override
    public void close() throws IOException {

    }
    /*public enum Option {START, INST, PREF, RANKING, EXIT};

    public String[] optString = {"NEW GAME", "INSTRUCTIONS", "SETTINGS", "RANKINGS", "EXIT"};

    Option selected;
    Option[] opt = Option.values();

    public Menu(boolean inGame) {
        this.selected = START;
        if (inGame) optString[0] = "CONTINUE";
    }

    public Option getSelected() {
        return selected;
    }

    public int getPosElem(Option target) {
        int i = 0;
        for (; opt[i] != target; i++) ;
        return i;
    }

    public String enumToString(Option menuOption) {
        int position = getPosElem(menuOption);
        return optString[position];
    }

    public void setSelected(Option selected) {
        this.selected = selected;
    }

    public void nextSelected() {
        if (selected == EXIT) selected = START;
        else {
            //find the position of this.selected in the opt array
            int i = getPosElem(selected);
            i++;
            selected = opt[i];
        }
    }

    public void previousSelected() {
        if (selected == START) selected = EXIT;
        else {
            //find the position of this.selected in the opt array
            int i = getPosElem(selected);
            i--;
            selected = opt[i];
        }
    }*/
}