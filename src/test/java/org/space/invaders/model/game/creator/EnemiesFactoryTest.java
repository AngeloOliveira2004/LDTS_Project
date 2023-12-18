package org.space.invaders.model.game.creator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.space.invaders.model.game.elements.*;

import static org.junit.jupiter.api.Assertions.*;

public class EnemiesFactoryTest {

    private EnemiesFactory factory;

    @BeforeEach
    public void setUp() {
        factory = new EnemiesFactory();
    }

    @Test
    public void testCreateDefaultEnemy() {
        Element defaultEnemy = factory.createDefaultEnemy();
        assertEquals(DefaultEnemy.class, defaultEnemy.getClass());
        assertEquals(250, defaultEnemy.getXposition());
        assertEquals(10, defaultEnemy.getYposition());
    }

    @Test
    public void testCreateStrongerEnemy() {
        Element strongerEnemy = factory.createStrongerEnemy();
        assertEquals(StrongEnemy.class, strongerEnemy.getClass());
        assertEquals(150, strongerEnemy.getXposition());
        assertEquals(10, strongerEnemy.getYposition());
    }

    @Test
    public void testCreateKamikaze() {
        Element kamikazeEnemy = factory.createKamikaze();
        assertEquals(KamikazeEnemy.class, kamikazeEnemy.getClass());
        assertEquals(150, kamikazeEnemy.getXposition());
        assertEquals(10, kamikazeEnemy.getYposition());
    }

    @Test
    public void testGetShotFactory() {
        assertNotNull(factory.getShotFactory());
    }
}
