package org.space.invaders.model;


import org.space.invaders.control.command.EnemiesController;
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
        ArrayList<Element> objectToRemove = new ArrayList<>();
        ArrayList<ShotElement> shotsToRemove = new ArrayList<>();

        for(Element element : objects)
        {
            for(ShotElement shotElement : shots)
            {
                if(checkColisionsWithShots(element.getOccupiedPositions() , shotElement.getPosition()))
                {
                    shotsToRemove.add(shotElement);
                    objectToRemove.add(element);
                }
            }
        }
        Iterator<Element> objectIterator = objects.iterator();
        Iterator<Element> objectToRemoveIterator = objectToRemove.iterator();
        Iterator<ShotElement> shotElementIterator = shots.iterator();
        Iterator<ShotElement> shotsToRemoveIterator = shotsToRemove.iterator();

        for (Element elementToRemove : objectToRemove) {
            objects.remove(elementToRemove);
        }

        // Remove elements from 'shots' list
        for (ShotElement shotToRemove : shotsToRemove) {
            shots.remove(shotToRemove);
        }
    }


}
