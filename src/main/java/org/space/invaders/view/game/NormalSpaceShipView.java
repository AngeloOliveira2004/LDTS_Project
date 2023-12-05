package org.space.invaders.view.game;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.control.game.PlayerController;
import org.space.invaders.model.game.elements.NormalSpaceShip;

import java.io.IOException;

public class NormalSpaceShipView extends View{
    private NormalSpaceShip normalSpaceShip;
    private PlayerController playerController;
    private static final int CHAR_WIDTH = 5;
    private static final int CHAR_HEIGHT = 5;
    boolean isInvincible = false;

    //TODO implement spaceship model and then paint it
    private static final String[] SpaceShipModel = {" " , " "};
    private static final String[] SpaceShipModelWithFlames = {" " , " "};
    public NormalSpaceShipView(NormalSpaceShip normalSpaceShip , TextGraphics textGraphics) {
        super(CHAR_WIDTH , CHAR_HEIGHT , textGraphics);
        this.normalSpaceShip = normalSpaceShip;
    }
    @Override
    public void draw()
    {
        int x = normalSpaceShip.getPosition().getX();
        int y = normalSpaceShip.getPosition().getY();

        if(isInvincible == false)
        {
            getGraphics().putString(5, 5, "Lambe me os colhoes");
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
