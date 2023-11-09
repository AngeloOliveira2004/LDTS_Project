package org.image.to.ascii;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageToAscii extends IOException{
    public static void convertAndPrint(String imagePath, int outputWidth) {
        try {
            // Load and resize the image
            BufferedImage image = ImageIO.read(new File(imagePath));
            int outputHeight = (int) ((double) outputWidth / image.getWidth() * image.getHeight());
            BufferedImage resizedImage = new BufferedImage(outputWidth, outputHeight, BufferedImage.TYPE_INT_RGB);
            resizedImage.createGraphics().drawImage(image, 0, 0, outputWidth, outputHeight, null);

            // Convert the image to ASCII
            String asciiArt = convertToAscii(resizedImage);

            // Print the ASCII art
            printAsciiArt(asciiArt);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String convertToAscii(BufferedImage image) {
        // Define ASCII characters to represent different brightness levels
        char[] asciiChars = {'@', '#', '8', '&', 'o', ':', '*', '.', ' '};

        // Get image dimensions
        int width = image.getWidth();
        int height = image.getHeight();

        // Convert pixels to ASCII characters
        StringBuilder asciiArt = new StringBuilder();
        for (int y = 0; y < height; y += 2) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                int grayscale = (int) (0.21 * ((pixel >> 16) & 0xff) + 0.72 * ((pixel >> 8) & 0xff) + 0.07 * (pixel & 0xff));
                int index = (int) (grayscale / 255.0 * (asciiChars.length - 1));
                asciiArt.append(asciiChars[index]);
            }
            asciiArt.append("\n");
        }

        return asciiArt.toString();
    }

    public static void convertAndPrint(String imagePath, int outputWidth, int outputHeight) {
        try {
            // Load and resize the image
            BufferedImage image = ImageIO.read(new File(imagePath));
            BufferedImage resizedImage = new BufferedImage(outputWidth, outputHeight, BufferedImage.TYPE_INT_RGB);
            resizedImage.createGraphics().drawImage(image, 0, 0, outputWidth, outputHeight, null);

            // Convert the image to ASCII
            String asciiArt = convertToAscii(resizedImage);

            // Print the ASCII art
            printAsciiArt(asciiArt);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void printAsciiArt(String asciiArt) {
        System.out.println(asciiArt);
    }
}
