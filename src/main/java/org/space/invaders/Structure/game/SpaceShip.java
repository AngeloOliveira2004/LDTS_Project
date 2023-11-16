package org.space.invaders.Structure.game;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.Structure.Element;
import org.space.invaders.Structure.Position;

public class SpaceShip extends Position implements Element{
    private char orientation;
    private double Yvelocity ;
    private double Xvelocity ;
    private int Health ;
    private int SpawnRate;
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

    public void check()
    {
        int temp = getX();

        int temp1 = getY();
    }
    public SpaceShip(int x, int y, double Yvelocity, double Xvelocity, int Health, int SpawnRate) {
        super(x , y);
        this.Yvelocity = Yvelocity;
        this.Xvelocity = Xvelocity;
        this.Health = Health;
        this.SpawnRate = SpawnRate;
    }
    public void moveRight(char orientation)
    {
        if(getX()+ 1 + 11 <= 100)
        {
            setX(getX()+ 1);
            this.orientation = orientation;
        }
    }
    public void moveLeft(char orientation)
    {
        if(getX() - 1 >= 0)
        {
            setX(getX()- 1);
            this.orientation = orientation;
        }
    }
    public void moveDown(char orientation)
    {
        if(getY() -1 +7<= 50)
        {
            setY(getY()+ 1);
            this.orientation = orientation;
        }
    }
    public void moveUp(char orientation)
    {
        if(getY()-1>= 0)
        {
            setY(getY()- 1);
            this.orientation = orientation;
        }
    }
    public int getPositionX()
    {
        return getX();
    }

    public int getPositionY()
    {
        return getY();
    }
    @Override
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
                        screen.setCharacter(getX() + y, getY() + x, character);
                    }
                    else
                    {
                        TextCharacter character = new TextCharacter(spaceshipRight[x][y]);
                        character = character.withBackgroundColor(TextColor.ANSI.BLACK);
                        character = character.withForegroundColor(TextColor.ANSI.BLACK);
                        screen.setCharacter(getX() + y, getY() + x, character);
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
                        screen.setCharacter(getX() + y, getY() + x, character);
                    }
                    else
                    {
                        TextCharacter character = new TextCharacter(spaceshipRight[x][y]);
                        character = character.withBackgroundColor(TextColor.ANSI.BLACK);
                        character = character.withForegroundColor(TextColor.ANSI.BLACK);
                        screen.setCharacter(getX() + y, getY() + x, character);
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
                        screen.setCharacter(getX() + y, getY() + x, character);
                    }else
                    {
                        TextCharacter character = new TextCharacter(spaceshipRight[x][y]);
                        character = character.withBackgroundColor(TextColor.ANSI.BLACK);
                        character = character.withForegroundColor(TextColor.ANSI.BLACK);
                        screen.setCharacter(getX() + y, getY() + x, character);
                    }
                }
            }
            break;
        }
    }

    @Override
    public int getHealth() {
        return this.Health;
    }
    @Override
    public void setHealth(int health) {
        this.Health = health;
    }
    @Override
    public int getSpawnRate() {
        return 0;
    }
    @Override
    public void setSpawnRate(int spawnRate) {
        this.SpawnRate = 0;
    }
    @Override
    public double getYVelocity() {
        return this.Yvelocity;
    }
    @Override
    public void setYVelocity(double yVelocity) {
        this.Yvelocity = yVelocity;
    }
    @Override
    public double getXVelocity() {
        return this.Xvelocity;
    }
    @Override
    public void setXVelocity(double xVelocity) {
        this.Xvelocity = xVelocity;
    }
}
