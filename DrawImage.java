//CS622, Ramazan Samat
//importing needed modules

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//This class is responsible for loading bug and chicken images and drawing new image with chicken and bug
public class DrawImage {

    //Using buffer to load the pictures
    BufferedImage bug = null;
    BufferedImage chickens = null;

    public ArrayList<BufferedImage> Overlay() {
        ArrayList<BufferedImage> list = null;
        try {
            bug = ImageIO.read(new File("Bug Final.png"));
            chickens = ImageIO.read(new File("Chickens clean.png"));
            //Bellow is the check that code does indeed finds the bug. Uncomment the following section to see it in action
            //and use Chickens.png (clean chicken) above
            int width = chickens.getWidth(null);
            int height = chickens.getHeight(null);
            BufferedImage bi2 = new BufferedImage(width, height, chickens.getType());
            Graphics big = bi2.getGraphics();

            //Creating user input
            Scanner scan_for_x = new Scanner(System.in);
            System.out.println("Please enter X position for the bug: ");
            String x_position_input = scan_for_x.nextLine();
            System.out.println("Please enter Y position for the bug: ");
            String y_position_input = scan_for_x.nextLine();
            int x_position = Integer.parseInt(x_position_input);
            int y_position = Integer.parseInt(y_position_input);


            big.drawImage(chickens, 0, 0, null);
            big.drawImage(bug, x_position, y_position, null);
            chickens = bi2;
            big.dispose();

            ImageIO.write(bi2, "PNG", new File(".", "Chicken with bug Overlay.png"));

            chickens = ImageIO.read(new File("Chicken with bug Overlay.png"));
            list = new ArrayList<BufferedImage>();
            list.add(bug);
            list.add(chickens);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return list;
    }

    public ArrayList<BufferedImage> ReadImage() {
        ArrayList<BufferedImage> list = null;
        try {
            bug = ImageIO.read(new File("Bug Final.png"));
            chickens = ImageIO.read(new File("Chickens with bug.png"));
            list = new ArrayList<BufferedImage>();
            list.add(bug);
            list.add(chickens);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        return list;
    }
}
