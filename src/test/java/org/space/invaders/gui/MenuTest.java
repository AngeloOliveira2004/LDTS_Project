package org.space.invaders.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
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
        screen = Mockito.mock(TerminalScreen.class);
        menu = new Menu(screen);
        textGraphics = Mockito.mock(TextGraphics.class);
        when(screen.newTextGraphics()).thenReturn(textGraphics);
        menu.setVisible(true);
    }

    /*
    @Test
    void testDrawText() {
        Position position = new Position(25, 25);
        String color = "#008000";
        String modifier = "BOLD";
        String name = "Hello World!";

        menu.drawText(position, name, color, modifier);

        verify(textGraphics).putString(position.x, position.y, name, SGR.valueOf(modifier));
    }
    */



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

