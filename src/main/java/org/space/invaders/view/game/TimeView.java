package org.space.invaders.view.game;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.UI.Time;

import java.io.IOException;
import java.util.ArrayList;

public class TimeView extends View{

    private static final int CHAR_HEIGHT = 30;
    private static final int CHAR_WIDTH = 25;
    private Time time;
    private static final String[] numberZero = new String[]{"0"
    };
    public TimeView(Time time , TextGraphics textGraphics)
    {
        super(CHAR_WIDTH , CHAR_HEIGHT , textGraphics);
        this.time = time;
    }
    @Override
    public void draw() throws IOException {
        long elapsedTimeInMillis = this.time.getElapsedTime();
        long elapsedTimeInSeconds = elapsedTimeInMillis / 1000;
        String timeString = String.valueOf(elapsedTimeInSeconds);

        Position position = new Position(100, 275);
        for (int i = 0; i < timeString.length(); i++) {
            int digit = Character.getNumericValue(timeString.charAt(i));
            position.x += i*5;
            actualDraw(position , numberZero);
        }

    }

    private void actualDraw(Position position , String[] model)
    {
        ArrayList<Position> positions = new ArrayList<>();
        int x = (int)position.getX();
        int y = (int)position.getY();
        drawNumbers('0' , position.x , position.y);
    }
}
