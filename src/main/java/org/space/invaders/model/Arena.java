package org.space.invaders.model;


import org.space.invaders.model.game.elements.*;
import org.space.invaders.view.GameViewer;

import java.io.IOException;
import java.util.ArrayList;

public class Arena {
    private MiniSpaceShip miniSpaceShip;
    private NormalSpaceShip normalSpaceShip;
    private ArrayList<Element> objects;
    private ArrayList<ShotElement> shots;
    private final ArrayList<Position> starPositions;
    GameViewer tempScreen;

    public Arena() throws IOException {
        this.starPositions = new ArrayList<>();
        this.objects = new ArrayList<>();
        this.shots = new ArrayList<>();
        //this.tempScreen = new GameViewer();
    }
    private void addObject(Element object)
    {
        objects.add(object);
    }
    private void removeObject(Element object)
    {
        objects.remove(object);
    }
}
