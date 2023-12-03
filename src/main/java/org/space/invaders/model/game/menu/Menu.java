package org.space.invaders.model.game.menu;

import java.util.List;

public abstract class Menu {
    private List<String> menuOptions;
    private int currentOption = 0;

    public Menu(List<String> menuOptions) {
        this.menuOptions = menuOptions;
    }

    public void nextOption() {
        currentOption++;
        if (currentOption >= this.menuOptions.size()) {
            currentOption = 0;
        }
    }

    public void previousOption() {
        currentOption--;
        if (currentOption < 0) {
            currentOption = this.menuOptions.size() - 1;
        }
    }

    public String getCurrentOption() {
        return menuOptions.get(currentOption);
    }

    public boolean isSelected(String option) {
        return getCurrentOption().equals(option);
    }

    public int getNumberOptions() {
        return this.menuOptions.size();
    }

    public void setCurrentOption() {
        if(currentOption < this.menuOptions.size() - 1)
            this.currentOption++;
        else
            this.currentOption = 0;
    }

    public String getOption(int i){
        return menuOptions.get(i);
    }
    public void addMenuOptions(String string){
        this.menuOptions.add(string);
    }

}
