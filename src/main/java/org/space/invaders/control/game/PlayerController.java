package org.space.invaders.control.game;

import org.space.invaders.model.game.elements.NormalSpaceShip;
import org.space.invaders.model.game.elements.MiniSpaceShip;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener {
    private MiniSpaceShip miniSpaceShip;
    private NormalSpaceShip normalSpaceShip;

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
    public PlayerController(MiniSpaceShip miniSpaceShip , NormalSpaceShip normalSpaceShip)
    {
        this.miniSpaceShip = miniSpaceShip;
        this.normalSpaceShip = normalSpaceShip;
    }
    public MiniSpaceShip getMiniSpaceShip() {
        return miniSpaceShip;
    }
    public NormalSpaceShip getNormalSpaceShip() {
        return normalSpaceShip;
    }

    public boolean NormalSpaceShip_on_the_field()
    {
        if(normalSpaceShip.getVisible())
        {
            return true;
        }
        return false;
    }

    public void switchSpaceShips()
    {
        if(NormalSpaceShip_on_the_field())
        {
            normalSpaceShip.setVisible(false);
            miniSpaceShip.setVisible(true);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                miniSpaceShip.moveLeft();
                normalSpaceShip.moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                miniSpaceShip.moveRight();
                normalSpaceShip.moveRight();
                break;
            case KeyEvent.VK_UP:
                miniSpaceShip.moveFoward();
                normalSpaceShip.moveFoward();
                break;
            case KeyEvent.VK_DOWN:
                miniSpaceShip.moveBackwards();
                normalSpaceShip.moveBackwards();
                break;
            case KeyEvent.VK_SPACE:
                if(NormalSpaceShip_on_the_field())
                {
                    //TODO actually shot
                    //normalSpaceShip.shoot();
                }
                else
                {
                    //TODO same thing
                    miniSpaceShip.shot();
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
