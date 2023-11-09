package org.spaceInvaders;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.MouseAction;
import com.googlecode.lanterna.input.MouseActionType;

import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JPanel;

public class SpaceShip extends Element{
    org.spaceInvaders.Position position;
    private char orientation;

    private static final char[][] spaceship =
    {
       {'0' ,'0' ,'0' , '0', '0', '_' ,'0' , '0' ,'0','0' ,'0'},
       {'0' , '0' , '0' ,'_' , '|' ,'0', '|' , '_' , '0' , '0' ,'0'} ,
       {'0' ,'_' , '|' , '0' ,'0' ,'0','0','0' ,'|' ,'_' ,'0'},
       {'|','_','_','_','0','0','0','_','_','_','|'} ,
       {'|','_','_','|','_','_','_','|','_','_','|'}
    };

    private static final char[][] spaceshipLeft =
            {
                {'0', '0', '0', '0', '0', '_', '0', '0', '0', '0', '0', '0','0','0'},
                {'0', '0', '0', '_', '\\', '0', '0', '\\', '_', '0', '0', '0','0','0'},
                {'0', '_', '\\', '0', '0', '0', '0', '0', '0', '\\', '_', '_','0','0'},
                {'\\', '_', '_', '_', '0', '0', '0', '0', '_', '_', '_', '_','\\','0'},
                {'\\', '_', '_', '\\', '_', '_', '_', '_', '\\', '_', '_', '_','_', '\\'},
            };

    private static final char[][] spaceshipRight =
            {
                {'0', '0', '0', '0', '0', '0', '0', '0', '_', '0', '0', '0','0', '0'},
                {'0','0','0', '0', '0', '_', '/', '0', '0', '/', '_', '0', '0', '0'},
                {'0', '0', '_', '_', '/', '0', '0', '0', '0', '0', '0', '/','_','0'},
                {'0', '/', '_', '_', '_', '_', '0', '0', '0', '0', '_', '_','_','/'},
                {'/', '_', '_', '_', '/', '_', '_', '_', '_', '/', '_', '_','/','0'},
            };

    SpaceShip(int x, int y , double Yvelocity , double Xvelocity , int Health , int SpawnRate) {
        super(x , y , Yvelocity , Xvelocity , Health , SpawnRate);
        this.position = new Position(x , y);
    }
    public void moveRight(char orientation)
    {
        if(position.getX()+ 1 + 11 <= 100)
        {
            position.setX(position.getX()+ 1);
            this.orientation = orientation;
        }

    }

    public void moveLeft(char orientation)
    {
        if(position.getX() -1 >= 0)
        {
            position.setX(position.getX()- 1);
            this.orientation = orientation;
        }
    }
    public void moveDown(char orientation)
    {
        if(position.getY() -1 +7<= 50)
        {
            position.setY(position.getY()+ 1);
            this.orientation = orientation;
        }
    }
    public void moveUp(char orientation)
    {
        if(position.getY()-1>= 0)
        {
            position.setY(position.getY()- 1);
            this.orientation = orientation;
        }
    }

    @Override
    public Position getPosition() {
            return position;
    }

    @Override
    public void draw(TextGraphics screen){
        // Calculate the character index based on the orientation
        //int characterIndex = (orientation / (360 / characterCount)) % characterCount;
        screen.setForegroundColor(TextColor.ANSI.YELLOW);

        switch (orientation)
        {
        case 'R':
            for(int x = 0 ; x < spaceshipRight.length ; x++)
            {
                for(int y = 0; y < spaceshipRight[0].length ; y++)
                {
                    if(spaceshipRight[x][y] != '0')
                    {
                        TextCharacter character = new TextCharacter(spaceshipRight[x][y]);
                        character = character.withBackgroundColor(TextColor.ANSI.BLACK);
                        character = character.withForegroundColor(TextColor.ANSI.YELLOW);
                        screen.setCharacter(position.getX() + y, position.getY() + x, character);
                    }
                }
            }
            this.orientation = 'N';
            break;
        case 'L':
            for(int x = 0 ; x < spaceshipLeft.length ; x++)
            {
                for(int y = 0; y < spaceshipLeft[0].length ; y++)
                {
                    if(spaceshipLeft[x][y] != '0')
                    {
                        TextCharacter character = new TextCharacter(spaceshipLeft[x][y]);
                        character = character.withBackgroundColor(TextColor.ANSI.BLACK);
                        character = character.withForegroundColor(TextColor.ANSI.YELLOW);
                        screen.setCharacter(position.getX() + y, position.getY() + x, character);
                    }
                }
            }
            this.orientation = 'N';
            break;
        default:
            for(int x = 0 ; x < spaceship.length ; x++) {
                for (int y = 0; y < spaceship[0].length; y++) {
                    if (spaceship[x][y] != '0') {
                        TextCharacter character = new TextCharacter(spaceship[x][y]);
                        character = character.withBackgroundColor(TextColor.ANSI.BLACK);
                        character = character.withForegroundColor(TextColor.ANSI.YELLOW);
                        screen.setCharacter(position.getX() + y, position.getY() + x, character);
                    }
                }
            }
            break;
        }
    }
}
