package org.space.invaders.model;


import org.space.invaders.model.game.elements.*;
import org.space.invaders.view.GameViewer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Arena {
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
    public void addObject(Element object)
    {
        objects.add(object);
    }
    public void removeObject(Element object)
    {
        objects.remove(object);
    }
    public ArrayList<Element> getObjects()
    {
        return objects;
    }
    public ArrayList<ShotElement> getShots(){return shots;}
    public ArrayList<Position> getStarPositions(){return starPositions;}

    public void addShot(ShotElement shotElement)
    {
        shots.add(shotElement);
    }
    public void update() {
        // Remove elements from 'objects' list
        Iterator<Element> objectIterator = objects.iterator();
        while (objectIterator.hasNext()) {
            Element element = objectIterator.next();
            if (!element.isInsideBorders()) {
                objectIterator.remove();
            }
        }

        // Remove elements from 'shots' list
        Iterator<ShotElement> shotIterator = shots.iterator();
        while (shotIterator.hasNext()) {
            ShotElement shotElement = shotIterator.next();
            if (!shotElement.isInsideBorders()) {
                shotIterator.remove();
            }
        }
    }

}
