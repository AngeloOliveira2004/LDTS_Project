package org.space.invaders.control.game;

import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.DefaultEnemy;
import org.space.invaders.model.game.elements.StrongEnemy;

public class StrongEnemyController implements EnemyLogic {
    private int iterations;
    private int directionX;

    private StrongEnemy strongEnemy;

    public StrongEnemyController(StrongEnemy strongEnemy) {
        this.strongEnemy = strongEnemy;
        this.iterations = 0;
        this.directionX = 1;
    }

    public void move() {
        Position currentPosition = strongEnemy.getPosition();

        int newX = currentPosition.getX() + directionX;
        int newY = currentPosition.getY();

        strongEnemy.setPosition(new Position(newX, newY));
    }

    public void update() {
        if(strongEnemy.getPosition().x - 1 == 0 || strongEnemy.getPosition().x + 1 == 590 ){
            directionX *= -1;
            strongEnemy.setPosition(new Position(strongEnemy.getPosition().x, strongEnemy.getPosition().y+5));
        }
        if (iterations < 5) {
            move();
        } else {
            iterations = -1;
        }

        iterations++;
    }
}
