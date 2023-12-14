package org.space.invaders.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;
import java.io.IOException;
import static org.mockito.Mockito.*;

class MenuTest {

    @Mock
    private Screen screen;

    @Mock
    private TextGraphics textGraphics;

    private Menu menu;

    @BeforeEach
    void setUp() throws IOException {
        screen = Mockito.mock(Screen.class);
        menu = new Menu(screen);
        textGraphics = Mockito.mock(TextGraphics.class);
        when(screen.newTextGraphics()).thenReturn(textGraphics);
        menu.setVisible(true);
    }

    @Test
    void testDrawText() {
        Position position = new Position(0, 0);
        String text = "TextColor.ANSI.GREEN_BRIGHT";
        String color = "BOLD";

        menu.drawText(position, text, color);

        verify(textGraphics).putString(position.x, position.y, text, SGR.valueOf(color));
    }



    @Test
    void testRefresh() throws IOException {
        menu.refresh();
        verify(screen).refresh();
    }

    @Test
    void testClear() {
        menu.clear();
        verify(screen).clear();
    }

    @Test
    void testClose() throws IOException {
        menu.close();
        verify(screen).close();
    }

}

