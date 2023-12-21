package org.space.invaders.view.game;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.UI.Lifes;
import org.space.invaders.model.game.UI.NumberEnum;

import java.io.IOException;
import java.util.ArrayList;

public class LifesView extends View{

    private static final int CHAR_HEIGHT = 1;
    private static final int CHAR_WIDTH = 1;
    private Lifes lifes;
    private boolean first_time;
    public static final String[] timeString = new String[]{
            "gg     gg  gg gg  ggggg  ggggg     ",
            "gg     gg  gg gg  gg     gg      gg",
            "gg     gg  gg gg  ggggg  ggggg     ",
            "gg     gg  gg gg  gg        gg   gg",
            "ggggg  gg    g    ggggg  ggggg     ",
    };

    private static final String[] heart = new String[]{
            "     g g     ",
            "    ggggg    ",
            "    ggggg    ",
            "     ggg     ",
            "      g      ",
    };

    public LifesView(Lifes lifes,TextGraphics textGraphics) {
        super(CHAR_WIDTH, CHAR_HEIGHT, textGraphics);
        this.lifes = lifes;
        this.first_time = true;
    }

    @Override
    public void draw() throws IOException {
        Position position = new Position(500, 295);
        actualDraw(position , timeString,lifes.getLifes());
    }

    public void actualDraw(Position position, String[] model, int lifeStringValue)
    {
        ArrayList<Position> positions = new ArrayList<>();
        int x = (int) position.getX();
        int y = (int) position.getY();
        if(first_time) {
            drawImage(model, x, y, positions);
            x += 30;
            first_time = false;
        }
        int i = lifeStringValue;
        while (i != 0){
            drawImage(heart,x + i * 8, y, positions);
            i--;
        }
    }

    public boolean getFirstTime() {
        return first_time;
    }

    public String[] getHeart()
    {
        return heart;
    }

    public String[] getTimeString()
    {
        return timeString;
    }
}
