package org.space.invaders.model.game.creator;

import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.Element;
import org.space.invaders.model.game.elements.KamikazeEnemy;
import org.space.invaders.model.game.elements.ShotElement;

public class EnemiesFactory {
    private ShotFactory shotFactory;
    public EnemiesFactory()
    {
        this.shotFactory = new ShotFactory();
    }
    public Element createDefaultEnemy() {
        return null;
    }
    public Element createStrongerEnemy() {
        return null;
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
