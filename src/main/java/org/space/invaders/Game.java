    package org.space.invaders;

    import com.googlecode.lanterna.TerminalSize;
    import com.googlecode.lanterna.input.KeyStroke;
    import com.googlecode.lanterna.input.KeyType;
    import com.googlecode.lanterna.screen.Screen;
    import com.googlecode.lanterna.screen.TerminalScreen;
    import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
    import com.googlecode.lanterna.terminal.Terminal;
    import org.space.invaders.model.game.Dimensions;
    import org.space.invaders.model.game.SpaceShip;
    import org.space.invaders.model.game.elements.Shot;
    import org.space.invaders.model.game.map.Stars;


    import java.io.IOException;


    public class Game implements Dimensions {
        private boolean running = true;
        private Screen screen;
        private SpaceShip spaceShip;
        private Shot shot;
        private Stars stars;
        private static final int FRAME_RATE = 30; // Frames per second
        private static final long FRAME_TIME = 1000000000 / FRAME_RATE; // Time per frame in nanoseconds
        private long lastFrameTime;
        public Game() {
            try {
                Terminal terminal = new DefaultTerminalFactory()
                        .setInitialTerminalSize(new TerminalSize(screenWidth, screenHeight))
                        .createTerminal();
                lastFrameTime = System.nanoTime();
                screen = new TerminalScreen(terminal);

                screen.setCursorPosition(null);
                screen.startScreen();
                screen.doResizeIfNecessary();

                spaceShip = new SpaceShip(40, 30 , 1 , 1, 5 , 0);

                stars = new Stars(50, 100);
                stars.draw(screen.newTextGraphics());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private void draw() throws IOException{
            screen.clear();
            stars.draw(screen.newTextGraphics());
            spaceShip.draw(screen.newTextGraphics());
            screen.refresh();
        }
        //divide screen into quadrants and divide the number of stars equallyy for each quadrant.
        protected void processKey(KeyStroke key)
        {
            switch (key.getKeyType()) {
                case ArrowRight -> spaceShip.moveRight('R');
                case ArrowLeft -> spaceShip.moveLeft('L');
                case ArrowDown -> spaceShip.moveDown('N');
                case ArrowUp -> spaceShip.moveUp('N');
                case Character -> {
                    char character = key.getCharacter();
                    if (character == 'D' || character == 'd') {
                        spaceShip.moveRight('R');
                    } else if (character == 'A' || character == 'a') {
                        spaceShip.moveLeft('L');
                    } else if (character == 'S' || character == 's') {
                        spaceShip.moveDown('N');
                    } else if (character == 'W' || character == 'w') {
                        spaceShip.moveUp('N');
                    }else if(character == ' ')
                    {
                        spaceShip.check();
                        shot = new Shot(spaceShip.getPositionX()+5 , spaceShip.getPositionY());
                        shot.draw(screen.newTextGraphics());
                        shot = null;
                    }
                }
            }

            System.out.println(key);
        }

        public void run()
        {
            try {
                while(running) {

                    long currentTime = System.nanoTime();
                    long elapsedTime = currentTime - lastFrameTime;

                    if (elapsedTime >= FRAME_TIME) {
                        lastFrameTime = currentTime;

                        draw();

                        // Read user input
                        com.googlecode.lanterna.input.KeyStroke key = screen.pollInput();
                        if (key != null) {
                            if (key.getKeyType() == KeyType.Escape || key.getKeyType() == KeyType.EOF) {
                                screen.close();
                                break;
                            }
                            processKey(key);
                        }

                        screen.refresh();
                    }
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }

    }
