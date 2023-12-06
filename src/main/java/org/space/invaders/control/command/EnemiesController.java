package org.space.invaders.control.command;

import org.space.invaders.model.Arena;
import org.space.invaders.model.game.creator.EnemiesFactory;
import org.space.invaders.model.game.creator.ShotFactory;
import org.space.invaders.model.game.elements.Element;
import org.space.invaders.model.game.elements.KamikazeEnemy;
import java.util.Random;

import java.util.ArrayList;

public class EnemiesController {
    private Arena arena;
    private EnemiesFactory enemiesFactory;
    private ShotFactory shotFactory;

    public EnemiesController(Arena arena , EnemiesFactory enemiesFactory , ShotFactory shotFactory)
    {
        this.arena = arena;
        this.enemiesFactory = enemiesFactory;
        this.shotFactory = shotFactory;
    }

    public void KamizeSpawner()
    {
        //todo change to set maybe
        ArrayList<Integer> list = new ArrayList<>();
        KamikazeEnemy tempKamikaze = (KamikazeEnemy) enemiesFactory.createKamikaze();

        for(int i = 0 ; i <= tempKamikaze.getSpawnRate() ; i++)
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
    }
}
