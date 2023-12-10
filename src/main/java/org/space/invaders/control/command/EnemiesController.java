package org.space.invaders.control.command;

import org.space.invaders.control.game.DefaultEnemyController;
import org.space.invaders.control.game.EnemyLogic;
import org.space.invaders.control.game.KamikazeLogic;
import org.space.invaders.control.game.StrongEnemyController;
import org.space.invaders.model.Arena;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.creator.EnemiesFactory;
import org.space.invaders.model.game.creator.ShotFactory;
import org.space.invaders.model.game.elements.DefaultEnemy;
import org.space.invaders.model.game.elements.KamikazeEnemy;
import org.space.invaders.model.game.elements.StrongEnemy;

import java.util.Random;

import java.util.ArrayList;

public class EnemiesController {
    private Arena arena;
    private EnemiesFactory enemiesFactory;
    private ShotFactory shotFactory;
    private KamikazeLogic kamikazeLogic;

    private DefaultEnemyController defaultEnemyController;
    private ArrayList<EnemyLogic> logics;
    private int kamikazeEnemyCount;

    private int defaultenemycount;

    private int strongEnemyCount;
    public EnemiesController(Arena arena , EnemiesFactory enemiesFactory , ShotFactory shotFactory)
    {
        this.arena = arena;
        this.kamikazeEnemyCount = 0;
        this.defaultenemycount = 0;
        this.strongEnemyCount = 0;
        this.enemiesFactory = enemiesFactory;
        this.shotFactory = shotFactory;
        this.logics = new ArrayList<>();
    }

    public void KamizeSpawner(Position position) {
        KamikazeEnemy tempKamikaze = (KamikazeEnemy) enemiesFactory.createKamikaze();

        if (ShouldSpawn(1000)) {
            if(kamikazeEnemyCount < 10){
                arena.addObject(tempKamikaze);
            }
        }
        logics.add(new KamikazeLogic(position , tempKamikaze));
        kamikazeEnemyCount++;

    }

    public void DefaultEnemySpawner(Position position) {
        DefaultEnemy tempDefaultEnemy = (DefaultEnemy) enemiesFactory.createDefaultEnemy();

        if (ShouldSpawn(100) && defaultenemycount < 10) {
            arena.addObject(tempDefaultEnemy);
            logics.add(new DefaultEnemyController(tempDefaultEnemy));
            defaultenemycount++;
        } //Retirar a este valor quando matar
    }

    public void StrongEnemySpawner(Position position) {
        StrongEnemy tempStrongEnemy = (StrongEnemy) enemiesFactory.createStrongerEnemy();
        if (ShouldSpawn(100) && strongEnemyCount < 10) {
            arena.addObject(tempStrongEnemy);
            logics.add(new StrongEnemyController(tempStrongEnemy));
            kamikazeEnemyCount++;
        } //Retirar a este valor quando matar

    }

    public void update()
    {
        for(EnemyLogic enemyLogic : logics)
        {
            enemyLogic.update();
        }
    }

    private boolean ShouldSpawn(int probability) {
        int randomInt = new Random().nextInt(10000) + 1;
        return randomInt <= probability;
    }


}


