package org.space.invaders.model.game.menu;

import org.space.invaders.states.ApplicationState;

import java.util.ArrayList;
import java.util.List;

public class GameOverModel extends Menu{

    private int currentIndex = 0;

    private static final String[] alphabetLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private int[] acronym = {1,1,1};

    public GameOverModel()
    {
        super(new ArrayList<>());
        addMenuOptions("Back to Menu");
    }
    public GameOverModel(List<String> menuOptions) {
        super(menuOptions);
    }
    @Override
    public ApplicationState validateApplicationState() {
        return ApplicationState.MainMenu;
    }

    public void nextOptionIndex() {
        currentIndex++;
        if (currentIndex > 2) {
            currentIndex = 0;
        }
    }

    public void previousOptionIndex() {
        currentIndex--;
        if (currentIndex < 0) {
            currentIndex = 2;
        }
    }

    public int[] getAcronym(){
        return acronym;
    }

    public String getAcronymValue(int letter) {
        return alphabetLetters[letter];
    }
    public int getCurrentIndex(){
        return currentIndex;
    }

    public String[] getNamedAcronym(){
        String[] acronym = {getAcronymValue(getAcronym()[0]),getAcronymValue(getAcronym()[1]),getAcronymValue(getAcronym()[2])};
        return acronym;
    }


    public void setAcronymletterUP() {
        if (currentIndex >= 0 && currentIndex < acronym.length) {
            if (acronym[currentIndex] < 25) {
                acronym[currentIndex]++;
            } else {
                acronym[currentIndex] = 0;
            }
        }
    }

    public void setAcronymletterDOWN() {
        if (currentIndex >= 0 && currentIndex < acronym.length) {
            if (acronym[currentIndex] > 0) {
                acronym[currentIndex]--;
            } else {
                acronym[currentIndex] = 25;
            }
        }
    }

}
