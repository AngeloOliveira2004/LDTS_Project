package org.space.invaders.control.game;

import com.googlecode.lanterna.input.KeyStroke;
import org.space.invaders.control.music.MusicController;
import org.space.invaders.control.music.Musics;
import org.space.invaders.model.Arena;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.SpaceShip;
import org.space.invaders.model.game.creator.ShotFactory;
import org.space.invaders.model.game.elements.MiniShot;
import org.space.invaders.model.game.elements.Shot;
import static org.space.invaders.Constants.HEIGHT;
import static org.space.invaders.Constants.WIDTH;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.PrimitiveIterator;

public class PlayerController {
    private SpaceShip spaceShip;
    private ShotFactory shotFactory;

    public PlayerController(SpaceShip spaceShip)
    {
        this.spaceShip = spaceShip;
        this.shotFactory = new ShotFactory();
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
                if(!isInsideBorders(spaceShip.getPosition()))
                {
                    spaceShip.moveRight();
                }
                break;
            case ArrowRight:
                spaceShip.moveRight();
                Position position = new Position(spaceShip.getXposition() , spaceShip.getYposition());
                if(spaceShip.isMini())
                {
                    position = new Position(spaceShip.getXposition() + 13 , spaceShip.getYposition());
                }
                else
                {
                    position = new Position(spaceShip.getXposition() + 26 , spaceShip.getYposition());
                }
                if(!isInsideBorders(position))
                {
                    spaceShip.moveLeft();
                }
                break;
            case ArrowUp:
                spaceShip.moveFoward();
                if(!isInsideBorders(spaceShip.getPosition()))
                {
                    spaceShip.moveBackwards();
                }
                break;
            case ArrowDown:
                spaceShip.moveBackwards();
                if(!isInsideBorders(spaceShip.getPosition()))
                {
                    spaceShip.moveFoward();
                }
                break;
            case Enter:
                spaceShip.toggleMini(!spaceShip.isMini());
            case Character:
                if (key.getCharacter() == ' ') {
                    if (spaceShip.isMini()) {
                        arena.addShot(shotFactory.createMiniShot(spaceShip.getPosition()));
                    } else if(key.getCharacter() == 'm') {
                        spaceShip.toggleMini(!spaceShip.isMini());
                    }else
                    {
                        arena.addShot(shotFactory.createShot(spaceShip.getPosition()));
                    }
                }
                break;
            // Handle other cases if needed
            default:
                break;
        }
    }
    private boolean isInsideBorders(Position position)
    {
        return position.x > -1 && position.y > -1 && position.x < WIDTH && position.y < HEIGHT - 25;
    }
}
