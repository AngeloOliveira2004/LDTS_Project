package org.space.invaders.model;


import org.space.invaders.model.game.Collider;
import org.space.invaders.model.game.SpaceShip;
import org.space.invaders.model.game.elements.*;
import org.space.invaders.view.GameViewer;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Arena implements Collider {
    private ArrayList<Element> objects;
    private ArrayList<ShotElement> shots;
    private final ArrayList<Position> starPositions;

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
    private void removeOutofBoundsShots()
    {
        shots.removeIf(shotElement -> !shotElement.isInsideBorders());
    }
    public void update() {
        // Remove elements from 'objects' list
        removeOutofBoundsShots();
        Iterator<Element> objectIterator = objects.iterator();
        Iterator<ShotElement> shotElementIterator = shots.iterator();

        while (objectIterator.hasNext())
        {
            Element object = objectIterator.next();
            int iterations = 0;
            if(object.getClass() != SpaceShip.class)
            {
                while (shotElementIterator.hasNext()) {
                    ShotElement shotElement = shotElementIterator.next();
                    if(checkColisionsWithShots(object.getOccupiedPositions() , shotElement.getPosition()))
                    {
                        objectIterator.remove();
                        shotElementIterator.remove();
                    }
                }
            }
        }
        // Remove elements from 'shots' list
    }

}
