package org.space.invaders.view.game;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.UI.NumberEnum;
import org.space.invaders.model.game.UI.Time;

import java.io.IOException;
import java.util.ArrayList;

public class TimeView extends View{

    private static final int CHAR_HEIGHT = 1;
    private static final int CHAR_WIDTH = 1;
    private Time time;
    private boolean first_time;
    private static final String[] timeString = new String[]{
            "gggggg  gg  ggggggg  ggggg    ",
            "  gg    gg  gg g gg  gg      gg",
            "  gg    gg  gg g gg  ggggg     ",
            "  gg    gg  gg g gg  gg      gg",
            "  gg    gg  gg g gg  ggggg     ",
    };
    public TimeView(Time time , TextGraphics textGraphics)
    {
        super(CHAR_WIDTH , CHAR_HEIGHT , textGraphics);
        this.time = time;
        this.first_time = true;
    }
    @Override
    public void draw() throws IOException {
        long elapsedTimeInMillis = this.time.getElapsedTime();
        long elapsedTimeInSeconds = elapsedTimeInMillis / 1000;

        Position position = new Position(10, 295);
        actualDraw(position , timeString,elapsedTimeInSeconds);

    }
    private void actualDraw(Position position , String[] model, long elapsedTimeInSeconds)
    {
        String time_Value = String.valueOf(elapsedTimeInSeconds);
        ArrayList<Position> positions = new ArrayList<>();
        int x = (int) position.getX();
        int y = (int) position.getY();
        if(first_time) {
            drawImage(timeString, x, y, positions);
            x += 40;
            first_time = false;
        }
        for (int i = 0; i < time_Value.length(); i++) {
            int digit = Character.getNumericValue(time_Value.charAt(i));
            drawImage(NumberEnum.values()[digit].getDesign(), x + i * 8, y, positions);
        }

    }
}
