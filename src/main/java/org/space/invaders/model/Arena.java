package org.space.invaders.model;


import org.space.invaders.control.command.EnemiesController;
import org.space.invaders.model.game.Collider;
import org.space.invaders.model.game.SpaceShip;
import org.space.invaders.model.game.UI.Lifes;
import org.space.invaders.model.game.UI.Score;
import org.space.invaders.model.game.UI.Time;
import org.space.invaders.model.game.elements.*;
import org.space.invaders.view.GameViewer;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Arena implements Collider {
    private ArrayList<Element> objects;
    private ArrayList<ShotElement> shots;
    private final ArrayList<Position> starPositions;
    private Score score;
    private Lifes lifes;
    private Time time;

    private Planet planet;
    public Arena() throws IOException {
        this.starPositions = new ArrayList<>();
        this.objects = new ArrayList<>();
        this.shots = new ArrayList<>();
        this.score = new Score();
        //TODO MUDAR CONSOANTE O SCORE E DIFICULDADE
        this.lifes = new Lifes();
        this.time = new Time();
        this.planet = new Planet(15,250,0,0,0,0,true,3,3);
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
    public void update(SpaceShip spaceShip) {
        // Remove elements from 'objects' list
        removeOutofBoundsShots();
        ArrayList<Element> objectToRemove = new ArrayList<>();
        ArrayList<ShotElement> shotsToRemove = new ArrayList<>();
        System.out.println(lifes.getLifes());
        for(Element element : objects)
        {
            for(ShotElement shotElement : shots)
            {
                if(element.getClass() == SpaceShip.class && shotElement.getYVelocity() == -1){
                    if(checkColisionsWithShots(element.getOccupiedPositions() , shotElement.getPosition()))
                    {
                        int newHealth = element.getHealth() - shotElement.getDamage();
                        element.setHealth(newHealth);

                        if(element.getHealth() <= 0)
                        {
                            objectToRemove.add(element);
                        }
                        shotsToRemove.add(shotElement);
                    }
                }else if(element.getClass() != SpaceShip.class && shotElement.getYVelocity() == 1)
                {
                    if(checkColisionsWithShots(element.getOccupiedPositions() , shotElement.getPosition()))
                    {
                        int newHealth = element.getHealth() - shotElement.getDamage();
                        element.setHealth(newHealth);

                        if(element.getHealth() <= 0)
                        {
                            objectToRemove.add(element);
                        }
                        shotsToRemove.add(shotElement);
                    }
                }
            }
        }

        if(!spaceShip.isInvincible()) {
            for (Element element : objects) {
                if (element.getClass() != SpaceShip.class) {
                    if (checkColisions(spaceShip.getOccupiedPositions(), element.getOccupiedPositions()))
                    {
                        lifes.decrementLifes();
                        spaceShip.setInvincible(true);
                        break;
                    }
                }
            }
        }

        for (Element elementToRemove : objectToRemove) {
            objects.remove(elementToRemove);
        }

        // Remove elements from 'shots' list
        for (ShotElement shotToRemove : shotsToRemove) {
            shots.remove(shotToRemove);
        }
        if(spaceShip.isInvincible())
            spaceShip.calculateInvincibility();
        //TODO CHECK IF LIVES ARE <0 AND ENDGAME
    }

    public Score getScore() {
        return score;
    }

    public Lifes getLifes() {
        return lifes;
    }

    public Time getTime() {
        return time;
    }

    public Planet getPlanet() { return planet;}
}
