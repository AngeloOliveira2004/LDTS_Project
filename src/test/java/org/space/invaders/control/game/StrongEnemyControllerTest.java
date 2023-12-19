package org.space.invaders.control.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.DefaultEnemy;
import org.space.invaders.model.game.elements.StrongEnemy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class StrongEnemyControllerTest {
    private StrongEnemyController strongEnemyController;
    private StrongEnemy strongEnemy;

    @BeforeEach
    void setUp() {
        strongEnemy = mock(StrongEnemy.class);
        strongEnemyController = new StrongEnemyController(strongEnemy);
    }

    @Test
    void testUpdate() {
        Position currentPosition = new Position(10, 20);
        when(strongEnemy.getPosition()).thenReturn(currentPosition);
        when(strongEnemy.getXVelocity()).thenReturn(2);

        // Call update multiple times to cover different scenarios
        for (int i = 0; i < 10; i++) {
            strongEnemyController.update();
        }

        verify(strongEnemy, times(9)).setPosition(any());

        verify(strongEnemy, times(29)).getPosition();
        verify(strongEnemy, times(9)).setPosition(any());
    }

    @Test
    void testSetDirectionX() {
        strongEnemyController.setDirectionX(-1);

        // Verify that the directionX field is set to -1
        int directionX = strongEnemyController.getDirectionX();
        assertEquals(-1, directionX);
    }

    @Test
    void testChangeDirections()
    {
        strongEnemy = new StrongEnemy(50,50,1,1,1,0,true,1,1);
        strongEnemyController = new StrongEnemyController(strongEnemy);
        int ExpectedX = strongEnemy.getPosition().x;
        int ExpectedY = strongEnemy.getPosition().y;
        int increment = 1;
        for(int i = 0 ; i < 2000 ; i++)
        {
            strongEnemyController.setIterations(3);
            strongEnemyController.update();
            ExpectedX += increment;

            if(ExpectedX > 585)
            {
                increment = increment*-1;
                ExpectedY += 16;
                ExpectedX -= 1;
                ExpectedX -= 1;
                ExpectedX += increment;
            }
            if(ExpectedX <= 0)
            {
                increment = increment*-1;
                ExpectedY += 16;
                ExpectedX += 1;
                ExpectedX += 1;
                ExpectedX += 1;
            }
            assertEquals(ExpectedX , strongEnemy.getPosition().x);
            assertEquals(ExpectedY , strongEnemy.getPosition().y);
        }
    }
}
