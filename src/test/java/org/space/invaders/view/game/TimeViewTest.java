package org.space.invaders.view.game;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.elements.StrongEnemy;
import org.space.invaders.model.game.elements.StrongEnemy;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.space.invaders.model.game.UI.Time;

import java.io.IOException;

public class TimeViewTest {
    TimeView timeView;
    @Mock
    Time time;
    @Mock
    TextGraphics textGraphics;
    @BeforeEach
    void setup()
    {
        this.time = mock(Time.class);
        this.textGraphics = mock(TextGraphics.class);
        this.timeView = new TimeView(time , textGraphics);
    }

    @Test
    void ActualDraw() throws IOException {
        long a = 0;
        assertTrue(timeView.getFirstTime());
        when(time.getElapsedTime()).thenReturn(a);
        timeView.draw();
        timeView.actualDraw(new Position(0,0) , new String[]{"a", "a"}, 0);
        assertFalse(timeView.getFirstTime());
    }
}
