package org.space.invaders.control.command;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import org.space.invaders.control.Command;

import java.io.IOException;

public class UserInput {
    public enum COMMAND {UP, RIGHT, DOWN, LEFT, CLICK, FLAG, UNDO, ESC, QUIT, BACKSPACE, NONE}
    Command.COMMAND command;
    Character key;
    public UserInput() {
        this.key = ' ';
        this.command = Command.COMMAND.NONE;
    }

    public Character getKey() {
        return key;
    }

    public Command.COMMAND getCommandEnum() {
        return command;
    }


    public UserInput getCommand(Screen screen) throws IOException {
        KeyStroke key;
        key = screen.pollInput();

        if (key == null)
            return this;

        switch (key.getKeyType()) {
            case EOF:
                this.command = Command.COMMAND.QUIT;
            case ArrowUp:
                this.command = Command.COMMAND.UP;
                break;
            case ArrowDown:
                this.command = Command.COMMAND.DOWN;
                break;
            case ArrowRight:
                this.command = Command.COMMAND.RIGHT;
                break;
            case ArrowLeft:
                this.command = Command.COMMAND.LEFT;
                break;
            case Enter:
                this.command = Command.COMMAND.CLICK;
                break;
            case Escape:
                this.command = Command.COMMAND.ESC;
                break;
            case Backspace:
                this.command = Command.COMMAND.BACKSPACE;
                break;
            case Character:
                this.key = key.getCharacter();
                switch (this.key) {
                    case ' ':
                        this.command = Command.COMMAND.FLAG;
                        break;
                    case 'q':
                        this.command = Command.COMMAND.QUIT;
                        break;
                    case 'z':
                        this.command = Command.COMMAND.UNDO;
                        break;
                    case 'w':
                        this.command = Command.COMMAND.UP;
                        break;
                    case 'a':
                        this.command = Command.COMMAND.LEFT;
                        break;
                    case 's':
                        this.command = Command.COMMAND.DOWN;
                        break;
                    case 'd':
                        this.command = Command.COMMAND.RIGHT;
                        break;
                    default:
                        break;
                }
        }
        return this;
    }
}
