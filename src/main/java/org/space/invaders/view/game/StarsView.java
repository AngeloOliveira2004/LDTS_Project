package org.space.invaders.view.game;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.Constants;
import org.space.invaders.model.game.map.Stars;

import java.io.IOException;
import java.util.List;

import static org.space.invaders.model.game.map.Stars.STAR_SPEED;

public class StarsView extends View{
    private final List<Stars.StarPosition> starPositions;
    public StarsView(TextGraphics textGraphics, Stars stars){
        super(0, 0, textGraphics);
        starPositions = stars.getStarPosition();
    }
    @Override
    public void draw() {
        TextCharacter character = new TextCharacter('*');
        character = character.withBackgroundColor(TextColor.ANSI.BLACK);
        character = character.withForegroundColor(TextColor.ANSI.WHITE);
        for (Stars.StarPosition starPosition : starPositions) {
            int x = starPosition.getX();
            int y = starPosition.getY();
            this.graphics.setCharacter(x, y, character);
        }
    }
    public void moveStars(){
        for(Stars.StarPosition starPosition: starPositions){
            int y = starPosition.getY();
        }
    }
}