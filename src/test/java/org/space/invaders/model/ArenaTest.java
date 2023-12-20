package org.space.invaders.model;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.space.invaders.model.game.SpaceShip;
import org.space.invaders.model.game.UI.Time;
import org.space.invaders.model.game.elements.*;
import org.space.invaders.view.game.DefaultEnemyView;
import org.space.invaders.view.game.KamikazeView;
import org.space.invaders.view.game.ShotView;
import org.space.invaders.view.game.SpaceshipView;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArenaTest {

    private Arena arena;

    @BeforeEach
    public void setUp() throws Exception {
        arena = new Arena();
    }

    @Test
    public void testgetStars(){
        assertEquals(arena.getStars().getStarPosition().size(),150);
    }

    @Test
    public void testgetScore(){
        assertEquals(arena.getScore().getScore(),0);
    }

    @Test
    public void testgetLifes(){
        assertEquals(arena.getLifes().getLifes(),5);
    }

    @Test
    public void testgetTime() {
        long elapsedTime = arena.getTime().getElapsedTime();

        long lowerBound = 0;
        long upperBound = 100;

        assertTrue(elapsedTime >= lowerBound && elapsedTime <= upperBound);
    }

    @Test
    public void testgetPlanet(){
        assertEquals(arena.getPlanet().getHealth(), 10000000);
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
        ShotElement shotOutsideBounds = new Shot(new Position(-1, -15), 1, 1);

        arena.addShot(shotInsideBounds);
        arena.addShot(shotOutsideBounds);

        assertEquals(2, arena.getShots().size());

        arena.removeOutofBoundsShots();

        assertEquals(1, arena.getShots().size());
        assertTrue(arena.getShots().contains(shotInsideBounds));
        assertFalse(arena.getShots().contains(shotOutsideBounds));
    }

    @Test
    public void testEnemiesShots_DefaultEnemy_AddShot() {
        SpaceShip spaceship = new SpaceShip(10,10,2,2,5,0,true,3,3);
        try {
            arena = new Arena();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DefaultEnemy defaultEnemy = new DefaultEnemy();
        arena.addObject(defaultEnemy);

        arena.update(spaceship);

        arena.enemiesShots();

        assertFalse(arena.getEnemiesShots().isEmpty());
    }

    @Test
    public void testUpdate_RemoveOutOfBoundsShots() throws IOException {
        Arena arena = new Arena();
        ShotElement shotInsideBounds = new Shot(new Position(5, 10), 1, 1);
        ShotElement shotOutsideBounds = new Shot(new Position(-1, -15), 1, 1);

        arena.addShot(shotInsideBounds);
        arena.addShot(shotOutsideBounds);

        assertEquals(2, arena.getShots().size());

        arena.update(new SpaceShip(10,10,2,2,5,0,true,3,3));

        assertEquals(1, arena.getShots().size());
        assertTrue(arena.getShots().contains(shotInsideBounds));
        assertFalse(arena.getShots().contains(shotOutsideBounds));
    }

    @Test
    public void testUpdate_SpaceShipHitByShot() throws IOException {
        Arena arena = new Arena();
        TextGraphics mockTextGraphics = Mockito.mock(TextGraphics.class);

        SpaceShip spaceShip = new SpaceShip(10, 20, 0, 0, 5, 1, true, 3, 3);
        SpaceshipView spaceshipView = new SpaceshipView(spaceShip,mockTextGraphics);
        spaceshipView.draw();

        assertNotNull(spaceShip.getOccupiedPositions());

        Shot shot = new Shot(new Position(20, 28), -1, 1);
        ShotView shotView = new ShotView(mockTextGraphics, shot);
        shotView.draw();

        assertNotNull(shot.getPosition());

        arena.addObject(spaceShip);
        arena.addShot(shot);

        assertEquals(5, spaceShip.getHealth());

        arena.update(spaceShip);

        assertEquals(4, spaceShip.getHealth());
        assertEquals(true, arena.getObjects().contains(spaceShip));
        assertEquals(false,arena.getShots().contains(shot));
    }

    @Test
    public void testUpdate_EnemyHitByShot() throws IOException {
        Arena arena = new Arena();

        TextGraphics mockTextGraphics = Mockito.mock(TextGraphics.class);
        DefaultEnemy enemy = new DefaultEnemy();
        DefaultEnemyView defaultEnemyView = new DefaultEnemyView(enemy,mockTextGraphics);
        defaultEnemyView.drawDefaultEnemy();

        ShotElement shot = new Shot(new Position(250, 6), 4, 1);
        arena.addObject(enemy);
        arena.addShot(shot);

        assertEquals(0, enemy.getHealth());

        arena.update(new SpaceShip(10,10,2,2,5,0,true,3,3));

        assertEquals(0, enemy.getHealth());
    }

    @Test
    public void testUpdate_KamikazeEnemyCollision() throws IOException {
        Arena arena = new Arena();

        TextGraphics mockTextGraphics = Mockito.mock(TextGraphics.class);
        SpaceShip spaceShip = new SpaceShip(2, 2, 0, 0, 5, 1, true, 3, 3);
        SpaceshipView spaceshipView = new SpaceshipView(spaceShip,mockTextGraphics);
        spaceshipView.draw();

        KamikazeEnemy kamikazeEnemy = new KamikazeEnemy();
        KamikazeView kamikazeView = new KamikazeView(kamikazeEnemy,mockTextGraphics);
        kamikazeView.drawKamikaze();

        assertNotNull(kamikazeEnemy.getOccupiedPositions());

        arena.addObject(spaceShip);
        arena.addObject(kamikazeEnemy);

        assertFalse(spaceShip.isInvincible());
        assertEquals(5, arena.getLifes().getLifes());

        arena.update(spaceShip);

        assertEquals(4, arena.getLifes().getLifes());
        assertFalse(arena.getObjects().contains(kamikazeEnemy));
    }

    @Test
    public void testUpdate_EnemyShotCollision() throws IOException {
        Arena arena = new Arena();

        TextGraphics mockTextGraphics = Mockito.mock(TextGraphics.class);
        SpaceShip spaceShip = new SpaceShip(10, 20, 0, 0, 5, 1, true, 3, 3);
        SpaceshipView spaceshipView = new SpaceshipView(spaceShip,mockTextGraphics);
        spaceshipView.draw();

        Shot enemyShot = new Shot(new Position(20, 28), 1, 1);
        ShotView shotView = new ShotView(mockTextGraphics, enemyShot);
        shotView.draw();

        arena.addObject(spaceShip);
        arena.addEnemyShot(enemyShot);

        assertFalse(spaceShip.isInvincible());
        assertEquals(5, arena.getLifes().getLifes());

        arena.update(spaceShip);

        assertTrue(spaceShip.isInvincible());
        assertEquals(4, arena.getLifes().getLifes());
    }
}
