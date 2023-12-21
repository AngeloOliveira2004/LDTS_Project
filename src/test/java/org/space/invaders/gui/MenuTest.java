package org.space.invaders.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.space.invaders.model.Position;

import javax.swing.*;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

class MenuTest {

    @Mock
    private Terminal terminal;

    @Mock
    private TerminalScreen terminalScreen;

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

    @Test
    void testGetNextActionArrowUp() throws IOException {
        KeyType keyType = KeyType.ArrowUp;
        KeyStroke key = new KeyStroke(keyType);

        when(screen.pollInput()).thenReturn(key);

        assertEquals(Menu.ACTION.UP, menu.getNextAction());
    }

    @Test
    void testGetNextActionEnter() throws IOException {
        KeyType keyType = KeyType.Enter;
        KeyStroke key = new KeyStroke(keyType);

        when(screen.pollInput()).thenReturn(key);

        assertEquals(Menu.ACTION.ENTER, menu.getNextAction());
    }

    @Test
    void testGetNextActionNull() throws IOException {
        KeyStroke key = null;

        when(screen.pollInput()).thenReturn(key);

        assertEquals(Menu.ACTION.NONE, menu.getNextAction());
    }

    @Test
    void testGetNextActionArrowDown() throws IOException {
        KeyType keyType = KeyType.ArrowDown;
        KeyStroke key = new KeyStroke(keyType);

        when(screen.pollInput()).thenReturn(key);

        assertEquals(Menu.ACTION.DOWN, menu.getNextAction());
    }

    @Test
    void testGetNextActionArrowLeft() throws IOException {
        KeyType keyType = KeyType.ArrowLeft;
        KeyStroke key = new KeyStroke(keyType);

        when(screen.pollInput()).thenReturn(key);

        assertEquals(Menu.ACTION.LEFT, menu.getNextAction());
    }

    @Test
    void testGetNextActionArrowRight() throws IOException {
        KeyType keyType = KeyType.ArrowRight;
        KeyStroke key = new KeyStroke(keyType);

        when(screen.pollInput()).thenReturn(key);

        assertEquals(Menu.ACTION.RIGHT, menu.getNextAction());
    }

    @Test
    void testGetNextActionQuitChar() throws IOException {
        KeyStroke key = new KeyStroke('q',false,false);

        when(screen.pollInput()).thenReturn(key);

        assertEquals(Menu.ACTION.QUIT, menu.getNextAction());
    }

    @Test
    void testGetNextActionQuitEOF() throws IOException {
        KeyType keyType = KeyType.EOF;
        KeyStroke key = new KeyStroke(keyType);

        when(screen.pollInput()).thenReturn(key);

        assertEquals(Menu.ACTION.QUIT, menu.getNextAction());
    }

    @Test
    void testDrawText() {
        Position position = new Position(1, 1);
        String text = "TestText";
        String modifier = "BOLD";

        menu.setTextGraphics(textGraphics);

        menu.drawText(position, text, "color", modifier);

        verify(textGraphics).setBackgroundColor(TextColor.ANSI.BLACK);
        verify(textGraphics).setForegroundColor(TextColor.ANSI.GREEN_BRIGHT);
        verify(textGraphics).putString(position.x, position.y, text, SGR.valueOf(modifier));
    }

    @Test
    void testDrawSelectedText() {
        Position position = new Position(2, 2);
        String text = "SelectedTestText";
        String modifier = "BOLD";

        menu.setTextGraphics(textGraphics);

        menu.drawSelectedText(position, text, "color", modifier);

        verify(textGraphics).setBackgroundColor(TextColor.ANSI.WHITE);
        verify(textGraphics).setForegroundColor(TextColor.ANSI.GREEN_BRIGHT);
        verify(textGraphics).putString(position.x, position.y, text, SGR.valueOf(modifier));
    }

    @Test
    void testGetScreen() {
        Screen actualScreen = menu.getScreen();
        assertNotNull(actualScreen);
    }

    @Test
    void testConstructorWithDimensions() {
        try {
            Menu menu = new Menu(80, 24);

            assertNotNull(menu.getScreen());
            assertTrue(menu.getScreen() instanceof TerminalScreen);

        } catch (IOException e) {
            fail("Exception thrown during menu creation: " + e.getMessage());
        }
    }
}

