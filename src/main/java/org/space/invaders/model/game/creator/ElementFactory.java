package org.space.invaders.model.game.creator;

import org.space.invaders.model.game.elements.Element;
import org.space.invaders.model.game.elements.ShotElement;

public abstract class ElementFactory {
    public abstract Element createEnemy();  // Factory method for creating enemies
    public abstract ShotElement createShot();   // Factory method for creating shots
}
