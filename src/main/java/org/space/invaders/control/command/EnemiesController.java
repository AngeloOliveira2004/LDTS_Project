package org.space.invaders.control.command;

import org.space.invaders.control.game.DefaultEnemyController;
import org.space.invaders.control.game.EnemyLogic;
import org.space.invaders.control.game.KamikazeLogic;
import org.space.invaders.model.Arena;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.creator.EnemiesFactory;
import org.space.invaders.model.game.creator.ShotFactory;
import org.space.invaders.model.game.elements.DefaultEnemy;
import org.space.invaders.model.game.elements.Element;
import org.space.invaders.model.game.elements.KamikazeEnemy;
import org.space.invaders.view.game.NormalEnemyView;

import java.util.Random;

import java.util.ArrayList;

public class EnemiesController {
    private Arena arena;
    private EnemiesFactory enemiesFactory;
    private ShotFactory shotFactory;
    private KamikazeLogic kamikazeLogic;

    private DefaultEnemyController defaultEnemyController;
    private ArrayList<EnemyLogic> logics;
    private int instance;

    private int normalEnemyCount;
    public EnemiesController(Arena arena , EnemiesFactory enemiesFactory , ShotFactory shotFactory)
    {
        this.arena = arena;
        this.enemiesFactory = enemiesFactory;
        this.shotFactory = shotFactory;
        this.logics = new ArrayList<>();
    }

    public void KamizeSpawner(Position position)
    {
        if(instance == 0)
        {
            //todo change to set maybe
            ArrayList<Integer> list = new ArrayList<>();
            KamikazeEnemy tempKamikaze = (KamikazeEnemy) enemiesFactory.createKamikaze();

            for(int i = 0 ; i <= 10000 ; i++)
            {
                list.add(i);
            }
            Random random = new Random();

            // Generate a random integer within the specified range
            int randomInt = random.nextInt((10000) + 1);
            if(list.contains(randomInt))
            {
                arena.addObject(tempKamikaze);
            }
            logics.add(new KamikazeLogic(position , tempKamikaze));
            instance++;
        }
    }

    public void DefaultEnemySpawner(Position position) {
        if (normalEnemyCount == 0) {

            ArrayList<Integer> list = new ArrayList<>();
            DefaultEnemy tempDefaultEnemy = (DefaultEnemy) enemiesFactory.createDefaultEnemy();

            for (int i = 0; i <= 10000; i++) {
                list.add(i);
            }

            Random random = new Random();

            int randomInt = random.nextInt((10000) + 1);
            if (list.contains(randomInt)) {
                arena.addObject(tempDefaultEnemy);
            }

            logics.add(new DefaultEnemyController(tempDefaultEnemy));
            normalEnemyCount++;
        }
    }

    public void update()
    {
        for(EnemyLogic enemyLogic : logics)
        {
            enemyLogic.update();
        }
    }
}
