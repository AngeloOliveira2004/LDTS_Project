package org.space.invaders.model.game;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.Terminal;

import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.Element;


public class SpaceShip extends Element {
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


    public SpaceShip(int x, int y, int Yvelocity, int Xvelocity, int Health, int SpawnRate , boolean alive) {
        super(x , y , Yvelocity , Xvelocity , Health , SpawnRate , alive);
    }
    public SpaceShip() {
        super(0 , 0 ,0 , 0 ,0 , 0 , true);
    }
    public void moveRight(char orientation)
    {
        if(getXposition()+ 1 + 11 <= 100)
        {
            Position tempPosition= new Position(getXposition() +1 , getYposition());
            setPosition(tempPosition);
            this.orientation = orientation;
        }
    }
    public void moveLeft(char orientation)
    {

        if(getXposition() - 1 >= 0)
        {
            Position tempPosition= new Position(getXposition() - 1 , getYposition());
            setPosition(tempPosition);
            this.orientation = orientation;
        }
    }
    public void moveDown(char orientation)
    {
        if(getYposition() -1 +7<= 50)
        {
            Position tempPosition= new Position(getXposition() , getYposition() + 1);
            setPosition(tempPosition);
            this.orientation = orientation;
        }
    }
    public void moveUp(char orientation)
    {
        Position tempPosition= new Position(getXposition() , getYposition() - 1);
        if(getYposition()-1>= 0)
        {
            setPosition(tempPosition);
            this.orientation = orientation;
        }
    }

    public void draw(TextGraphics screen){

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
                            screen.setCharacter(getXposition() + y, getYposition() + x, character);
                        }
                        else
                        {
                            TextCharacter character = new TextCharacter(spaceshipRight[x][y]);
                            character = character.withBackgroundColor(TextColor.ANSI.BLACK);
                            character = character.withForegroundColor(TextColor.ANSI.BLACK);
                            screen.setCharacter(getXposition() + y, getYposition() + x, character);
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
                            screen.setCharacter(getXposition() + y, getYposition() + x, character);
                        }
                        else
                        {
                            TextCharacter character = new TextCharacter(spaceshipRight[x][y]);
                            character = character.withBackgroundColor(TextColor.ANSI.BLACK);
                            character = character.withForegroundColor(TextColor.ANSI.BLACK);
                            screen.setCharacter(getXposition() + y, getYposition() + x, character);
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
                            screen.setCharacter(getXposition() + y, getYposition() + x, character);
                        }else
                        {
                            TextCharacter character = new TextCharacter(spaceshipRight[x][y]);
                            character = character.withBackgroundColor(TextColor.ANSI.BLACK);
                            character = character.withForegroundColor(TextColor.ANSI.BLACK);
                            screen.setCharacter(getXposition() + y, getYposition() + x, character);
                        }
                    }
                }
                break;
        }
    }

}

