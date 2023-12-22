package org.space.invaders.view.menu;

import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.game.menu.SettingsModel;

import java.util.Map;

import static org.mockito.Mockito.*;

class SettingsViewTest {

    @Mock
    private SettingsModel mockModel;

    @Mock
    private Screen mockScreen;

    @Mock
    private MenuGUI mockGui;

    private SettingsView settingsView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        settingsView = new SettingsView(mockModel, mockScreen);
    }

    @Test
    void testDrawElements() {
        // Mock data for the test
        when(mockModel.getNumberOptions()).thenReturn(3);
        when(mockModel.getOption(0)).thenReturn("Option1");
        when(mockModel.getOption(1)).thenReturn("Option2");
        when(mockModel.getOption(2)).thenReturn("Option3");
        when(mockModel.getCurrentOption()).thenReturn("Option2");

        settingsView.drawElements(mockGui);

        verify(mockGui, times(3)).drawText(any(), anyString(), anyString(), anyString());
        verify(mockGui).drawSelectedText(any(), anyString(), anyString(), anyString());
        verify(mockGui).refresh();
    }

    @Test
    void testDrawSettings() {
        when(mockModel.getNumberOptions()).thenReturn(3);
        when(mockModel.getOption(0)).thenReturn("Option1");
        when(mockModel.getOption(1)).thenReturn("Option2");
        when(mockModel.getOption(2)).thenReturn("Option3");
        when(mockModel.getValuesMap()).thenReturn(Map.of("Option1", 3, "Option2", 5, "Option3", 2));

        settingsView.drawSettings(mockGui);

        verify(mockGui, times(3)).drawText(any(), anyString(), anyString(), anyString());
    }
}
