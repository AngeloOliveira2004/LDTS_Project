package org.space.invaders.view.menu;

import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.PauseMenuModel;

import java.io.IOException;

import static org.mockito.Mockito.*;

class PauseMenuViewTest {

    @Mock
    private PauseMenuModel mockModel;

    @Mock
    private Screen mockScreen;

    @Mock
    private MenuGUI mockGui;

    private PauseMenuView pauseMenuView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pauseMenuView = new PauseMenuView(mockModel, mockScreen);
    }

    @Test
    void testDrawElements() {
        when(mockModel.getNumberOptions()).thenReturn(3);
        when(mockModel.getOption(0)).thenReturn("Resume");
        when(mockModel.getOption(1)).thenReturn("Settings");
        when(mockModel.getOption(2)).thenReturn("Exit");
        when(mockModel.getCurrentOption()).thenReturn("Settings");

        pauseMenuView.drawElements(mockGui);

        verify(mockGui, times(3)).drawText(any(), anyString(), anyString(), anyString());
        verify(mockGui).drawSelectedText(any(), anyString(), anyString(), anyString());
        verify(mockGui).refresh();
    }

    @Test
    void testClose() throws IOException {
        pauseMenuView.close();
        
        verify(mockScreen).close();
    }
}
