package org.space.invaders.control.game;

import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.DefaultEnemy;

public class DefaultEnemyController implements EnemyLogic {
    private int iterations;
    private int directionX;

    private DefaultEnemy defaultEnemy;

    public DefaultEnemyController(DefaultEnemy defaultEnemy) {
        this.defaultEnemy = defaultEnemy;
        this.iterations = 0;
        this.directionX = 1;
    }

    public void move() {
        Position currentPosition = defaultEnemy.getPosition();

        int newX = currentPosition.getX() + directionX;
        int newY = currentPosition.getY();

        defaultEnemy.setPosition(new Position(newX, newY));
    }

    public void update() {
        if(defaultEnemy.getPosition().x - 1 == 0 || defaultEnemy.getPosition().x + 1 == 590 ){
            directionX *= -1;
            defaultEnemy.setPosition(new Position(defaultEnemy.getPosition().x, defaultEnemy.getPosition().y+5));
        }
        if (iterations < 5) {
            move();
        } else {
            iterations = -1;
        }

        iterations++;
    }
}
