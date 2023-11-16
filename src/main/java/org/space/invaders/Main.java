package org.space.invaders;

import org.space.invaders.image.to.ascii.ImageToAscii;
import org.space.invaders.spaceInvaders.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
        String imagePath = "/home/jose-costa/Downloads/p.jpg";

         //Set the desired output width for the ASCII art
        int outputWidth = 75;
        int outputHeight = 30;

        // Call the function to convert and print the image as ASCII art
        ImageToAscii.convertAndPrint(imagePath, outputWidth, outputHeight);
    }
}