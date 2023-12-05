package org.space.invaders.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import org.space.invaders.control.game.PlayerController;
import org.space.invaders.model.game.elements.MiniSpaceShip;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class MiniSpaceShipView extends View{
    private MiniSpaceShip miniSpaceShip;
    private PlayerController playerController;
    private static final int CHAR_WIDTH = 3;
    private static final int CHAR_HEIGHT = 3;
    boolean isInvincible = false;

    //TODO implement spaceship model and then paint it
    private static final String[] SpaceShipModel = {" " , " "};
    private static final String[] SpaceShipModelWithFlames = {" " , " "};
    public MiniSpaceShipView(MiniSpaceShip miniSpaceShip) {
        super(CHAR_WIDTH , CHAR_HEIGHT);
        this.miniSpaceShip = miniSpaceShip;
    }
    @Override
    public void draw() throws IOException {
        int x = miniSpaceShip.getPosition().getX();
        int y = miniSpaceShip.getPosition().getY();

        if(isInvincible == false)
        {
            // TODO select model and call draw String[] spaceship =
            drawSpaceShip(SpaceShipModel , x , y);
        }
    }

    public void drawSpaceShip(String[] spaceship , int spaceshipX, int spaceshipY) throws IOException
    {
        for(int y = 0 ; y < spaceship.length ; y++)
        {
            for(int x = 0 ; x < spaceship[0].length() ; x++)
            {
                char character = spaceship[y].charAt(x);
                if (character != ' ') {
                    setColor(character);
                    graphics.fillRectangle(new TerminalPosition(spaceshipX * CHAR_WIDTH
                                    , spaceshipY * charHeight)
                                    , new TerminalSize(CHAR_WIDTH, CHAR_HEIGHT), ' ');
                }
            }
        }
    }

}
