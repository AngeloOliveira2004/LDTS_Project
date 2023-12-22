package org.space.invaders.view.game;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.UI.Lifes;
import org.space.invaders.model.game.UI.Time;
import org.space.invaders.view.game.LifesView;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LifesViewTest {
    LifesView lifesView;
    @Mock
    Lifes lifes;
    @Mock
    TextGraphics textGraphics;
    @BeforeEach
    void setup()
    {
        this.lifes = mock(Lifes.class);
        this.textGraphics = mock(TextGraphics.class);
        this.lifesView = new LifesView(lifes , textGraphics);
    }

    @Test
    void ActualDraw() throws IOException {
        assertTrue(lifesView.getFirstTime());
        lifesView.draw();
        lifesView.actualDraw(new Position(0,0) , new String[]{"a", "a"}, 5);
        assertFalse(lifesView.getFirstTime());
    }

    @Test
    void testGetters()
    {
         final String[] design = new String[]{
                "gg     gg  gg gg  ggggg  ggggg     ",
                "gg     gg  gg gg  gg     gg      gg",
                "gg     gg  gg gg  ggggg  ggggg     ",
                "gg     gg  gg gg  gg        gg   gg",
                "ggggg  gg    g    ggggg  ggggg     ",
        };

         final String[] design1 = new String[]{
                "     g g     ",
                "    ggggg    ",
                "    ggggg    ",
                "     ggg     ",
                "      g      ",
        };

        assertEquals(design1.length , lifesView.getHeart().length);
        assertEquals(design.length , lifesView.getTimeString().length);
    }
}

