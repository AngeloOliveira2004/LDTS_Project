package org.space.invaders;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class TestClass {
    private Screen screen;
    private TextGraphics textGraphics;
    public TestClass(int screenWidth , int screenHeight) throws Exception
    {
        Terminal terminal = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(screenWidth, screenHeight))
                .createTerminal();

        this.screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        // Start the screen
        screen.startScreen();

        textGraphics = screen.newTextGraphics();

        main();
    }
    private void printPixel(int x, int y, int red, int green, int blue) throws IOException {
        TextColor customColor = new TextColor.RGB(red, green, blue);
        TextCharacter character = new TextCharacter('a');
        textGraphics.setForegroundColor(customColor);
        character = character.withForegroundColor(customColor);
        textGraphics.setCharacter(new TerminalPosition(x, y), character);
        // Flush the screen to make the changes visible
        screen.refresh();
    }

    public void main() throws IOException {
        String filePath = "/home/jose-costa/Documents/Projeto LDTS/Space_Invaders/src/main/Resources/output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                // Parse the line to extract color, x_value, and y_value
                String[] parts = line.split(",");
                for(String string : parts) {
                    System.out.println(string);
                }
                int red = Integer.parseInt(parts[0]);
                int green = Integer.parseInt(parts[1]);
                int blue = Integer.parseInt(parts[2]);
                int x = Integer.parseInt(parts[3]);
                int y = Integer.parseInt(parts[4]);

                // Print a pixel of the specified color at the specified position
                printPixel(x, y, red, green, blue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
