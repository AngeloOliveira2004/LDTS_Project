package org.space.invaders.control.game;

import com.googlecode.lanterna.input.KeyStroke;
import org.space.invaders.model.game.SpaceShip;
import org.space.invaders.model.game.elements.NormalSpaceShip;
import org.space.invaders.model.game.elements.MiniSpaceShip;

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

    public void keyPressed(KeyStroke key) {
        if (key.isShiftDown()) {
            // If Shift key is pressed, toggle mini status
            if(spaceShip.isMini())
            {
                //todo add the if theres space
                spaceShip.toggleMini(false);
            }else{
                spaceShip.toggleMini(true);
            }
        } else {
            // If Shift key is not pressed, handle other keys
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
                case Character:
                    if (key.getCharacter() == ' ') {
                        if (spaceShip.isMini()) {
                            spaceShip.miniShot();
                        } else {
                            // TODO same thing
                            spaceShip.shot();
                        }
                    }
                    break;
                // Handle other cases if needed
                default:
                    break;
            }
        }
    }

}
