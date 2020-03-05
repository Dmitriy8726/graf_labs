//import net.sf.image4j.util.ConvertUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;


public class main {
    public static void main (String args []) throws IOException {

        //1//
        File file = new File("C:\\4kurs\\Graf\\resources\\nature.bmp");
        BufferedImage image = ImageIO.read(file);
        for (int i = 0; i < image.getWidth(); i++)
        {
            for (int j = 0; j < image.getHeight(); j++)
            {
                Color color = new Color(image.getRGB(i, j));
                int R, G, B;
                R = color.getRed();
                G = color.getGreen();
                B = color.getBlue();
                R = G = B = (R + G + B) / 3;
                Color newColor = new Color(R, G, B);
                image.setRGB(i,j, newColor.getRGB());
            }
        }

        File output = new File("1.bmp");
        ImageIO.write(image, "bmp", output);


        //2//
        BufferedImage second = new BufferedImage(
                image.getWidth() + 30,
                image.getHeight() + 30,
                BufferedImage.TYPE_INT_RGB);

        Graphics2D graphic = second.createGraphics();
        Random random = new Random();
        int R = random.nextInt(255);
        int G = random.nextInt(255);
        int B = random.nextInt(255);
        Color newColor = new Color(R, G, B);
        for (int i = 0; i < second.getHeight(); i++) {
            for (int j = 0; j < second.getWidth(); j++) {
                second.setRGB(j, i, newColor.getRGB());
            }
        }
        graphic.drawImage(image, 15, 15, Color.WHITE, null);

        File output2 = new File("2.bmp");
        ImageIO.write(second, "bmp", output2);

        //3//
        BufferedImage third = new BufferedImage(
                image.getHeight(),
                image.getWidth(),
                BufferedImage.TYPE_INT_RGB);

        int height = image.getHeight();
        int width = image.getWidth();

        Graphics2D graphic2 = third.createGraphics();
        graphic2.translate((height - width) / 2, (height - width) / 2);
        graphic2.rotate(Math.PI / 2, height / 2, width / 2);
        graphic2.drawRenderedImage(image, null);

        File output3 = new File("3.bmp");
        ImageIO.write(third, "bmp", output3);



    }
}
