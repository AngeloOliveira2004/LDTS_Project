package org.space.invaders.control.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.DefaultEnemy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DefaultEnemyControllerTest {

    private DefaultEnemyController defaultEnemyController;
    private DefaultEnemy defaultEnemy;

    @BeforeEach
    void setUp() {
        defaultEnemy = mock(DefaultEnemy.class);
        defaultEnemyController = new DefaultEnemyController(defaultEnemy);
    }

    @Test
    void testMove() {
        Position currentPosition = new Position(10, 20);
        when(defaultEnemy.getPosition()).thenReturn(currentPosition);
        when(defaultEnemy.getXVelocity()).thenReturn(2);

        defaultEnemyController.move();

        verify(defaultEnemy).setPosition(new Position(12, 20));
    }

    @Test
    void testUpdate() {
        Position currentPosition = new Position(10, 20);
        when(defaultEnemy.getPosition()).thenReturn(currentPosition);
        when(defaultEnemy.getXVelocity()).thenReturn(2);

        // Call update multiple times to cover different scenarios
        for (int i = 0; i < 10; i++) {
            defaultEnemyController.update();
        }

        verify(defaultEnemy, times(9)).setPosition(any());

        verify(defaultEnemy, times(29)).getPosition();
        verify(defaultEnemy, times(9)).setPosition(any());
    }

    @Test
    void testSetDirectionX() {
        defaultEnemyController.setDirectionX(-1);

        // Verify that the directionX field is set to -1
        int directionX = defaultEnemyController.getDirectionX();
        assertEquals(-1, directionX);
    }
}
