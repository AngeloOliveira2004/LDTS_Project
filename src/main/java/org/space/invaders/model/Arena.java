package org.space.invaders.model;


import org.space.invaders.control.command.EnemiesController;
import org.space.invaders.control.music.MusicController;
import org.space.invaders.control.music.Musics;
import org.space.invaders.model.game.Collider;
import org.space.invaders.model.game.SpaceShip;
import org.space.invaders.model.game.UI.Lifes;
import org.space.invaders.model.game.UI.Score;
import org.space.invaders.model.game.UI.Time;
import org.space.invaders.model.game.creator.ShotFactory;
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
    private ArrayList<ShotElement> enemiesShots;
    private final ArrayList<Position> starPositions;
    private Score score;
    private Lifes lifes;
    private Time time;
    private ShotFactory shotFactory;
    private Planet planet;
    private int currentCycle;
    public Arena() throws IOException {
        this.starPositions = new ArrayList<>();
        this.objects = new ArrayList<>();
        this.shots = new ArrayList<>();
        this.score = new Score();
        //TODO MUDAR CONSOANTE O SCORE E DIFICULDADE
        this.lifes = new Lifes();
        this.time = new Time();
        this.planet = new Planet(15,250,0,0,0,0,true,3,3 , 0);
        this.enemiesShots = new ArrayList<>();
        this.shotFactory = new ShotFactory();
        this.currentCycle = 0;
    }
    public void addObject(Element object)
    {
        objects.add(object);
    }

    public void addEnemyShot(ShotElement shotElement){
        enemiesShots.add(shotElement);
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
    private void updateCycle() {
        currentCycle = (currentCycle + 1) % 100;
    }
    public ArrayList<ShotElement> getEnemiesShots(){return enemiesShots;}
    public void enemiesShots()
    {
        System.out.println(currentCycle);
        for(Element enemy : objects){
            if(enemy.getClass() != SpaceShip.class)
            {
                if(enemy.getClass() == DefaultEnemy.class)
                {
                    if(currentCycle % 729 == 1)
                    {
                        Position position_ = new Position( enemy.getPosition().x , enemy.getPosition().y + 12);
                        addEnemyShot(shotFactory.createEnemyShot(position_));
                    }
                }
                if(enemy.getClass() == StrongEnemy.class)
                {
                    if(currentCycle % 997 == 1)
                    {
                       Position position_ = new Position( enemy.getPosition().x , enemy.getPosition().y + 12);
                       addEnemyShot(shotFactory.createEnemyShot(position_));
                    }
                }
            }
        }
    }

    public void update(SpaceShip spaceShip) {
        // Remove elements from 'objects' list
        removeOutofBoundsShots();
        ArrayList<Element> objectToRemove = new ArrayList<>();
        ArrayList<ShotElement> shotsToRemove = new ArrayList<>();

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
            if (element.getPosition().getX() >= 0 && element.getPosition().getX() <= 20 && element.getPosition().getY() >= 240 && element.getPosition().getY() <= 280) {
                lifes.killAllLifes();
                break;
            }
        }

        if(!spaceShip.isInvincible()) {
            for (Element element : objects) {
                if (element.getClass() != SpaceShip.class) {
                    if (checkColisions(spaceShip.getOccupiedPositions(), element.getOccupiedPositions()))
                    {
                        if(element.getClass() == KamikazeEnemy.class){objectToRemove.add(element);}
                        lifes.decrementLifes();
                        spaceShip.setInvincible(true);
                        break;
                    }
                }
            }
        }

        if(!spaceShip.isInvincible()) {
            for (ShotElement shotElement : enemiesShots) {
                if (checkColisionsWithShots(spaceShip.getOccupiedPositions(), shotElement.getPosition()))
                {
                    lifes.decrementLifes();
                    spaceShip.setInvincible(true);
                    shotsToRemove.add(shotElement);
                    break;
                }
            }
        }
        for (Element elementToRemove : objectToRemove) {
            objects.remove(elementToRemove);
            score.incrementScore(elementToRemove.getScore());
        }

        // Remove elements from 'shots' list
        for (ShotElement shotToRemove : shotsToRemove) {
            shots.remove(shotToRemove);
        }
        if(spaceShip.isInvincible())
            spaceShip.calculateInvincibility();


        enemiesShots();
        updateCycle();
    }


}
