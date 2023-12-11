package org.space.invaders.model.game.UI;

import com.googlecode.lanterna.graphics.TextGraphics;
import org.space.invaders.view.game.SpaceshipView;
import org.space.invaders.view.game.TimeView;

import javax.swing.*;
import java.io.IOException;

public class Time {
    private final long startTime;
    private TimeView timeView;
    public Time()
    {
        this.startTime = System.currentTimeMillis();
    }
    public long getElapsedTime() {
        return System.currentTimeMillis() - startTime;
    }

    public void draw(TextGraphics textGraphics) throws IOException {
        timeView = new TimeView(this , textGraphics);
        timeView.draw();
    }
}
