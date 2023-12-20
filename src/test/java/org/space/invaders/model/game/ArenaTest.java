package org.space.invaders.model.game;

import org.junit.Before;
import org.junit.Test;
import org.space.invaders.model.*;
import org.space.invaders.model.game.elements.Element;
import org.space.invaders.model.game.elements.Shot;
import org.space.invaders.model.game.elements.ShotElement;

import static org.junit.Assert.*;

public class ArenaTest {

    private Arena arena;

    @Before
    public void setUp() throws Exception {
        arena = new Arena();
    }

    @Test
    public void testAddObject() {
        Element element = new SpaceShip(10, 20, 0, 0, 5, 1, true, 3, 3);
        arena.addObject(element);

        assertTrue(arena.getObjects().contains(element));
    }

    @Test
    public void testRemoveObject() {
        Element element = new SpaceShip(10, 20, 0, 0, 5, 1, true, 3, 3);
        arena.addObject(element);
        arena.removeObject(element);

        assertFalse(arena.getObjects().contains(element));
    }

    @Test
    public void testAddShot() {
        ShotElement shotElement = new Shot(new Position(5, 10), 1, 1);
        arena.addShot(shotElement);

        assertTrue(arena.getShots().contains(shotElement));
    }

    @Test
    public void testUpdate() {
        SpaceShip spaceShip = new SpaceShip(10,20,0,0,5,1,true,3,3);
        arena.addObject(spaceShip);

        arena.update(spaceShip);

    }

    @Test
    public void testAddEnemyShot() {
        ShotElement enemyShot = new Shot(new Position(5, 10), 1, 1);
        arena.addEnemyShot(enemyShot);

        assertTrue(arena.getEnemiesShots().contains(enemyShot));
    }

    @Test
    public void testRemoveOutOfBoundsShots() {
        ShotElement shotInsideBounds = new Shot(new Position(5, 10), 1, 1);
        ShotElement shotOutsideBounds = new Shot(new Position(5, 10), 1, 1);

        arena.addShot(shotInsideBounds);
        arena.addShot(shotOutsideBounds);

        assertEquals(2, arena.getShots().size());

        arena.removeOutofBoundsShots();

        assertEquals(1, arena.getShots().size());
        assertTrue(arena.getShots().contains(shotInsideBounds));
        assertFalse(arena.getShots().contains(shotOutsideBounds));
    }

}
