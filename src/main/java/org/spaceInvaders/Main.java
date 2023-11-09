package org.spaceInvaders;

import org.image.to.ascii.ImageToAscii;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
        //String imagePath = "/home/jose-costa/Downloads/space.png";

        // Set the desired output width for the ASCII art
        // int outputWidth = 25;
        // int outputHeight = 15;

        // Call the function to convert and print the image as ASCII art
        // ImageToAscii.convertAndPrint(imagePath, outputWidth, outputHeight);
    }
}