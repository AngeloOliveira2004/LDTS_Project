package org.space.invaders.view.menu;

import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.GameOverModel;

import static org.mockito.Mockito.*;

class GameOverViewTest {

    @Mock
    private GameOverModel mockModel;

    @Mock
    private Screen mockScreen;

    @Mock
    private MenuGUI mockGui;

    private GameOverView gameOverView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gameOverView = new GameOverView(mockModel, mockScreen);
    }

    @Test
    void testDrawElements() {
        when(mockModel.getAcronym()).thenReturn(new int[]{1, 1, 1});
        when(mockModel.getCurrentIndex()).thenReturn(1);
        when(mockModel.getAcronymValue(1)).thenReturn("A");
        when(mockModel.getAcronymValue(2)).thenReturn("B");
        when(mockModel.getAcronymValue(3)).thenReturn("C");

        gameOverView.drawElements(mockGui);

        verify(mockGui, times(6)).drawText(any(), anyString(), anyString(), anyString());
        verify(mockGui).drawSelectedText(any(), anyString(), anyString(), anyString());
    }
}
