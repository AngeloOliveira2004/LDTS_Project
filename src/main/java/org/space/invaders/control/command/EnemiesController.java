package org.space.invaders.control.command;

import org.space.invaders.control.game.DefaultEnemyController;
import org.space.invaders.control.game.EnemyLogic;
import org.space.invaders.control.game.KamikazeController;
import org.space.invaders.control.game.StrongEnemyController;
import org.space.invaders.model.Arena;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.SpaceShip;
import org.space.invaders.model.game.creator.EnemiesFactory;
import org.space.invaders.model.game.creator.ShotFactory;
import org.space.invaders.model.game.elements.DefaultEnemy;
import org.space.invaders.model.game.elements.Element;
import org.space.invaders.model.game.elements.KamikazeEnemy;
import org.space.invaders.model.game.elements.StrongEnemy;

import java.util.ArrayList;

public class EnemiesController {
    private Arena arena;
    private EnemiesFactory enemiesFactory;
    private ShotFactory shotFactory;
    private ArrayList<EnemyLogic> logics;
    private int kamikazeEnemyCount;

    private int defaultenemycount;

    private int strongEnemyCount;
    private long lastSpawnCycleTimeDefault;
    private long lastSpawnCycleTimeKamikaze;
    private long lastSpawnCycleTimeStrong;
    private int currentCycle;
    private int difficulty;

    public EnemiesController(Arena arena , EnemiesFactory enemiesFactory , ShotFactory shotFactory)
    {
        this.arena = arena;
        this.kamikazeEnemyCount = 0;
        this.defaultenemycount = 0;
        this.strongEnemyCount = 0;
        this.enemiesFactory = enemiesFactory;
        this.shotFactory = shotFactory;
        this.logics = new ArrayList<>();
        this.lastSpawnCycleTimeDefault = System.currentTimeMillis();
        this.lastSpawnCycleTimeStrong = System.currentTimeMillis();
        this.lastSpawnCycleTimeKamikaze = System.currentTimeMillis();
        this.currentCycle = 0;
        this.difficulty = 1;

    }
    public void DefaultEnemySpawner(Position position) {
        long currentTime = System.currentTimeMillis();

        if (currentCycle % 2 == 0 && (currentTime - lastSpawnCycleTimeDefault) >= 4000/difficulty) {
            DefaultEnemy tempDefaultEnemy = (DefaultEnemy) enemiesFactory.createDefaultEnemy();
            arena.addObject(tempDefaultEnemy);
            logics.add(new DefaultEnemyController(tempDefaultEnemy));
            defaultenemycount++;

            lastSpawnCycleTimeDefault = currentTime;

            updateCycle();
        }
    }

    public void KamizeSpawner(Position position) {
        long currentTime = System.currentTimeMillis();

        if (currentCycle == 4 && (currentTime - lastSpawnCycleTimeKamikaze) >= 16000/difficulty) {
            KamikazeEnemy tempKamikaze = (KamikazeEnemy) enemiesFactory.createKamikaze();
            arena.addObject(tempKamikaze);
            logics.add(new KamikazeController(position, tempKamikaze));
            kamikazeEnemyCount++;

            lastSpawnCycleTimeKamikaze = currentTime;

            updateCycle();
        }
    }

    public void StrongEnemySpawner(Position position) {
        long currentTime = System.currentTimeMillis();

        if ((currentCycle % 2 != 0) && (currentTime - lastSpawnCycleTimeStrong) >= 8000/difficulty) {
            StrongEnemy tempStrongEnemy = (StrongEnemy) enemiesFactory.createStrongerEnemy();
            arena.addObject(tempStrongEnemy);
            logics.add(new StrongEnemyController(tempStrongEnemy));
            strongEnemyCount++;

            lastSpawnCycleTimeStrong = currentTime;

            updateCycle();
        }
    }

    private void updateCycle() {
        currentCycle = (currentCycle + 1) % 5;
    }

    public void update()
    {
        for(EnemyLogic enemyLogic : logics)
        {
            enemyLogic.update();
        }
    }

}