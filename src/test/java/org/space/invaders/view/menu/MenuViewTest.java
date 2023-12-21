package org.space.invaders.view.menu;

import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.menu.MenuModel;

import java.io.IOException;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

class MenuViewTest {

    @Mock
    private MenuModel mockModel;

    @Mock
    private Screen mockScreen;

    @Mock
    private MenuGUI mockGui;

    @InjectMocks
    private MenuView menuView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        menuView = new MenuView(mockModel, mockScreen);
    }

    @Test
    void testDrawElements() {
        when(mockModel.getOption(0)).thenReturn("Option1");
        when(mockModel.getOption(1)).thenReturn("Option2");
        when(mockModel.getNumberOptions()).thenReturn(2);
        when(mockModel.getCurrentOption()).thenReturn("Option1");

        menuView.drawElements(mockGui);

        verify(mockGui).drawText(new Position(14, 3), "W o r l d  T h r u s t e r", "#008000", "BLINK");
        verify(mockGui).drawSelectedText(new Position(20, 8), "Option1", "#008000", "BLINK");
        verify(mockGui).drawText(new Position(20, 10), "Option2", "#008000", "BOLD");
        verify(mockGui).refresh();
    }

    @Test
    void testClose() throws IOException {
        menuView.close();

        verify(mockScreen).close();
    }

    @Test
    void testSetModel() {
        MenuModel newModel = mock(MenuModel.class);
        menuView.setModel(newModel);
        assertSame(newModel, menuView.getModel());
    }

    @Test
    void testGetScreen() {
        assertSame(mockScreen, menuView.getScreen());
    }

    @Test
    void testGetTextGraphics() {
        assertSame(menuView.getTextGraphics(), menuView.getScreen().newTextGraphics());
    }

    @Test
    void testDraw() throws IOException {
        menuView.draw(mockGui);

        verify(mockGui).clear();
    }


}
