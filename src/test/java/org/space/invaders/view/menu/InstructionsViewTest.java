package org.space.invaders.view.menu;

import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.space.invaders.gui.MenuGUI;
import org.space.invaders.model.Position;
import org.space.invaders.model.game.menu.InstructionsModel;

import static org.mockito.Mockito.*;

class InstructionsViewTest {

    @Mock
    private InstructionsModel mockModel;

    @Mock
    private Screen mockScreen;

    @Mock
    private MenuGUI mockGui;

    @InjectMocks
    private InstructionsView instructionsView;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        instructionsView = new InstructionsView(mockModel, mockScreen);
    }

    @Test
    void testDrawElements() {
        when(mockModel.getOption(0)).thenReturn("Random Text X.X");

        instructionsView.drawElements(mockGui);

        verify(mockGui).drawText(new Position(14, 3), "I N S T R U C T I O N S", "#008000", "BLINK");
        verify(mockGui).drawSelectedText(new Position(20, 5), "Random Text X.X", "#008000", "BLINK");

    }
}
