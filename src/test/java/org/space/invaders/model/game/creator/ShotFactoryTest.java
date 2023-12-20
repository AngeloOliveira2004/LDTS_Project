package org.space.invaders.model.game.creator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.MiniShot;
import org.space.invaders.model.game.elements.Shot;
import org.space.invaders.model.game.elements.ShotElement;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ShotFactoryTest {

    private ShotFactory shotFactory;

    @BeforeEach
    public void setUp() {
        shotFactory = new ShotFactory();
    }

    @Test
    public void testCreateShot() {
        Position position = new Position(10, 20);
        ShotElement shot = shotFactory.createShot(position);

        assertNotNull(shot);
        assertEquals(Shot.class, shot.getClass());
        assertEquals(new Position(18, 16), shot.getPosition());
        assertEquals(5, shot.getDamage());
        assertEquals(4, shot.getYVelocity());
    }

    @Test
    public void testCreateMiniShot() {
        Position position = new Position(15, 25);
        ShotElement miniShot = shotFactory.createMiniShot(position);

        assertNotNull(miniShot);
        assertEquals(MiniShot.class, miniShot.getClass());
        assertEquals(new Position(18, 21), miniShot.getPosition());
        assertEquals(1, miniShot.getYVelocity());
    }

    @Test
    public void testCreateEnemyShot() {
        Position position = new Position(30, 40);
        ShotElement enemyShot = shotFactory.createEnemyShot(position);

        assertNotNull(enemyShot);
        assertEquals(Shot.class, enemyShot.getClass());
        assertEquals(new Position(38, 36), enemyShot.getPosition());
        assertEquals(-1, enemyShot.getYVelocity());
        assertEquals(5, enemyShot.getDamage());
    }
}
