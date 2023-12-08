package org.space.invaders.model.game.creator;

import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.*;

public class EnemiesFactory {
    private ShotFactory shotFactory;
    public EnemiesFactory()
    {
        this.shotFactory = new ShotFactory();
    }
    public Element createDefaultEnemy() {
        return new DefaultEnemy(250,10 , 1 , 1, 10 , 1 , true , 3 , 3);
    }
    public Element createStrongerEnemy() {
        return new StrongEnemy(100,10 , 1 , 1, 20 , 1 , true , 3 , 3);
    }
    public Element createBoss() {
        return null;
    }
    public Element createAsteroid(){return null;}
    public Element createKamikaze(){return new KamikazeEnemy(10,10 , 1 , 1, 5 , 1 , true , 3 , 3);}
    public ShotFactory getShotFactory() {
        return shotFactory;
    }

}
