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

        int newX = currentPosition.getX() + directionX * defaultEnemy.getXVelocity();
        int newY = currentPosition.getY();

        defaultEnemy.setPosition(new Position(newX, newY));
    }

    public void update() {
        if(defaultEnemy.getPosition().x - 1 <= 0 || defaultEnemy.getPosition().x + 1 > 585 ){
            directionX *= -1;
            defaultEnemy.setPosition(new Position(defaultEnemy.getPosition().x+directionX, defaultEnemy.getPosition().y+16));
        }
        if (iterations < 5) {
            move();
        } else {
            iterations = -1;
        }

        iterations++;
    }

    public void setDirectionX(int x){
        this.directionX = x;
    }
}
