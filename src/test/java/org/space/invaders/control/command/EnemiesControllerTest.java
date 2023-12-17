package org.space.invaders.control.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.space.invaders.control.command.EnemiesController;
import org.space.invaders.control.game.DefaultEnemyController;
import org.space.invaders.control.game.EnemyLogic;
import org.space.invaders.model.Arena;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.creator.EnemiesFactory;
import org.space.invaders.model.game.creator.ShotFactory;
import org.space.invaders.model.game.elements.DefaultEnemy;
import org.space.invaders.model.game.elements.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class EnemiesControllerTest {
    @Spy
    private Arena arena;
    @Mock
    private EnemiesFactory enemiesFactory;
    private EnemiesController enemiesController;

    @BeforeEach
    public void setUp() {
        arena = spy(Arena.class);
        enemiesFactory = Mockito.mock(EnemiesFactory.class);
        ShotFactory shotFactory = Mockito.mock(ShotFactory.class);

        DefaultEnemy defaultEnemyMock = Mockito.mock(DefaultEnemy.class);

        when(enemiesFactory.createDefaultEnemy()).thenReturn(defaultEnemyMock);

        enemiesController = new EnemiesController(arena, enemiesFactory, shotFactory);
    }

    @Test
    public void testDefaultEnemySpawner() {
        long currentTime = System.currentTimeMillis();
        ArrayList<Element> arenaObjects = arena.getObjects();
        ArrayList<EnemyLogic> logics = enemiesController.getLogics();

        enemiesController.setCycles(2);
        enemiesController.setlastSpawnCycleTimeDefault(0);

        enemiesController.DefaultEnemySpawner();

        assertTrue(arenaObjects.stream().anyMatch(obj -> obj instanceof DefaultEnemy));
        assertTrue(logics.stream().anyMatch(Objects::nonNull));

        verify(arena, times(1)).addObject(any(DefaultEnemy.class));
        verify(enemiesFactory, times(1)).createDefaultEnemy();

        assertTrue(enemiesController.getLastSpawnCycleTimeDefault() >= currentTime);
    }

    // Similar tests for KamizeSpawner and StrongEnemySpawner methods

    @Test
    public void testUpdate() {
        // Mock enemy logic
        EnemyLogic mockEnemyLogic = mock(DefaultEnemyController.class);
        EnemiesFactory EnemyFactoryMock = Mockito.mock(EnemiesFactory.class);
        when(EnemyFactoryMock.createDefaultEnemy()).thenReturn(new DefaultEnemy(0, 0, 0, 0, 0, 0, true, 0, 0));
        enemiesController.DefaultEnemySpawner();
        enemiesController.getLogics().add(mockEnemyLogic);

        // Test the update method
        enemiesController.update();

        verify(mockEnemyLogic, times(1)).update();
    }

    // Add more tests as needed for other methods and edge cases
}
