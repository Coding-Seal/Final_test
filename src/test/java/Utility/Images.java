package Utility;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Images {

    public static double compareImages(File fileA, File fileB)
    {
        BufferedImage imgA = null;
        BufferedImage imgB = null;

        // Try block to check for exception
        try {

            // Reading file from local directory by
            // creating object of File class

            // Reading files
            imgA = ImageIO.read(fileA);
            imgB = ImageIO.read(fileB);
        }

        catch (IOException e) {
            // Display the exceptions on console
            System.out.println(e);
        }

        // Assigning dimensions to image
        assert imgA != null && imgB != null;
        int widthA = imgA.getWidth();
        int widthB = imgB.getWidth();
        int heightA = imgA.getHeight();
        int heightB = imgB.getHeight();

        // Checking whether the images are of same size or
        // not
        if ((widthA > widthB) || (heightA > heightB)){
            imgA = resize(imgA, widthB, heightB);
            widthA = widthB;
            heightA =heightB;
        } else if ((widthA < widthB) || (heightA < heightB)) {
            imgB = resize(imgB, widthA, heightA);
        }

        // Display message straightaway

            // By now, images are of same size

        long difference = 0;

        // treating images likely 2D matrix

        // Outer loop for rows(height)
        for (int y = 0; y < heightA; y++) {

            // Inner loop for columns(width)
            for (int x = 0; x < widthA; x++) {

                int rgbA = imgA.getRGB(x, y);
                int rgbB = imgB.getRGB(x, y);
                int redA = (rgbA >> 16) & 0xff;
                int greenA = (rgbA >> 8) & 0xff;
                int blueA = (rgbA)&0xff;
                int redB = (rgbB >> 16) & 0xff;
                int greenB = (rgbB >> 8) & 0xff;
                int blueB = (rgbB)&0xff;

                difference += Math.abs(redA - redB);
                difference += Math.abs(greenA - greenB);
                difference += Math.abs(blueA - blueB);
            }
        }

        // Total number of red pixels = width * height
        // Total number of blue pixels = width * height
        // Total number of green pixels = width * height
        // So total number of pixels = width * height *
        // 3
        double total_pixels = widthA * heightA * 3;

        // Normalizing the value of different pixels
        // for accuracy

        // Note: Average pixels per color component
        double avg_different_pixels
                = difference / total_pixels;

        // There are 255 values of pixels in total

        // Lastly print the difference percentage
        return (avg_different_pixels / 255) * 100;
        }
    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}
