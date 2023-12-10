package org.space.invaders.control.game;

import com.googlecode.lanterna.input.KeyStroke;
import org.space.invaders.model.Arena;
import org.space.invaders.model.game.SpaceShip;
import org.space.invaders.model.game.elements.Shot;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController  {
    private SpaceShip spaceShip;

    //getState of the spaceship ig to determine
    private boolean canTransform()
    {
        /*
        if(isMiniSpaceship){
             check if theres space to transform
        }
         */
        return true;
    }
    public PlayerController(SpaceShip spaceShip)
    {
        this.spaceShip = spaceShip;
    }
    public SpaceShip getSpaceShip() {
        return spaceShip;
    }

    public void switchSpaceShips()
    {
        if(!spaceShip.isMini())
        {
            spaceShip.toggleMini(true);
        }
    }

    public void keyPressed(KeyStroke key , Arena arena) {

        switch (key.getKeyType()) {
            case ArrowLeft:
                spaceShip.moveLeft();
                break;
            case ArrowRight:
                spaceShip.moveRight();
                break;
            case ArrowUp:
                spaceShip.moveFoward();
                break;
            case ArrowDown:
                spaceShip.moveBackwards();
                break;
            case Enter:
                spaceShip.toggleMini(!spaceShip.isMini());
            case Character:
                if (key.getCharacter() == ' ') {
                    if (spaceShip.isMini()) {
                        spaceShip.miniShot();
                        shot(arena);
                    } else if(key.getCharacter() == 'm') {
                        spaceShip.toggleMini(!spaceShip.isMini());
                    }else
                    {
                        shot(arena);
                    }
                }
                break;
            // Handle other cases if needed
            default:
                break;
        }
    }

    private void shot(Arena arena)
    {
        arena.addShot(new Shot(spaceShip.getPosition(), 1));
    }
}
