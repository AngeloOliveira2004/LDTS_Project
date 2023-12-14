package org.space.invaders.control.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.space.invaders.control.command.EnemiesController;
import org.space.invaders.control.game.DefaultEnemyController;
import org.space.invaders.control.game.EnemyLogic;
import org.space.invaders.model.Arena;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.creator.EnemiesFactory;
import org.space.invaders.model.game.creator.ShotFactory;
import org.space.invaders.model.game.elements.DefaultEnemy;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class EnemiesControllerTest {
    @Mock
    private Arena arena;
    @Mock
    private EnemiesFactory enemiesFactory;
    @Mock
    private ShotFactory shotFactory;
    private EnemiesController enemiesController;

    @BeforeEach
    public void setUp() throws IOException {
        Arena arena = mock(Arena.class);
        ShotFactory shotFactory = Mockito.mock(ShotFactory.class);
        this.enemiesFactory = new EnemiesFactory(/* initialize parameters if needed */);

        // Use the mocked version instead of creating a new instance
        DefaultEnemy mock = Mockito.mock(DefaultEnemy.class);
        EnemiesFactory EnemyFactoryMock = Mockito.mock(EnemiesFactory.class);
        when(EnemyFactoryMock.createDefaultEnemy()).thenReturn(new DefaultEnemy(0, 0, 0, 0, 0, 0, true, 0, 0));

        // Use the mocked version instead of creating a new instance
        enemiesController = new EnemiesController(arena, enemiesFactory, shotFactory);
    }


    @Test
    public void testDefaultEnemySpawner() {
        Position position = new Position(1, 1);

        long currentTime = System.currentTimeMillis();
        EnemiesFactory EnemyFactoryMock = Mockito.mock(EnemiesFactory.class);
        when(EnemyFactoryMock.createDefaultEnemy()).thenReturn(new DefaultEnemy(0, 0, 0, 0, 0, 0, true, 0, 0));

        enemiesController.DefaultEnemySpawner(position);

        verify(arena, times(1)).addObject(any(DefaultEnemy.class));
        verify(enemiesFactory, times(1)).createDefaultEnemy();
        verify(arena, times(1)).addObject(any(DefaultEnemy.class));
        verify(arena, times(1)).addObject(any(DefaultEnemy.class));

        // Verify that the last spawn cycle time is updated
        assertTrue(enemiesController.getLastSpawnCycleTimeDefault() >= currentTime);
    }

    // Similar tests for KamizeSpawner and StrongEnemySpawner methods

    @Test
    public void testUpdate() {
        // Mock enemy logic
        EnemyLogic mockEnemyLogic = mock(DefaultEnemyController.class);
        EnemiesFactory EnemyFactoryMock = Mockito.mock(EnemiesFactory.class);
        when(EnemyFactoryMock.createDefaultEnemy()).thenReturn(new DefaultEnemy(0, 0, 0, 0, 0, 0, true, 0, 0));
        enemiesController.DefaultEnemySpawner(new Position(1, 1));
        enemiesController.getLogics().add(mockEnemyLogic);

        // Test the update method
        enemiesController.update();

        verify(mockEnemyLogic, times(1)).update();
    }

    // Add more tests as needed for other methods and edge cases
}
