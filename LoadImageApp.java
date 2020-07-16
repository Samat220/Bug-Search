//CS622, Ramazan Samat
//importing needed modules

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.*;
import javax.swing.*;

/**
 * Demonstration of loading and searching a picture within picture
 */
public class LoadImageApp{


    public static void main(String[] args) {

        //Boolean value that determines which method is invoked
        Boolean method1 = false;
        ArrayList<BufferedImage> image_list;

        DrawImage overlay = new DrawImage();
        if(method1 == true) {
            image_list = overlay.Overlay();
        } else {
            image_list = overlay.ReadImage();
        }

        Raster chicken_data;
        Raster bug_data;

        BufferedImage bug = image_list.get(0);
        BufferedImage chickens = image_list.get(1);


        //Raster of chicken
        chicken_data = chickens.getData();
        bug_data = bug.getData();

        //Expect number of bands to be the same for bug and chicken
        Integer numBands = bug_data.getNumBands();

        int[] chicken_band_array = new int[numBands];
        int[] bug_band_array = new int[numBands];

        //Print statements to chack data of the images
//        System.out.println(chicken_data.getHeight() + " " + chicken_data.getWidth() + " " + chicken_data.getPixel(0, 0, chicken_band_array));
//        System.out.println(bug_data.getHeight() + " " + bug_data.getWidth() + " " + bug_data.getPixel(0, 0, bug_band_array));
//        System.out.println(Arrays.toString(chicken_band_array));
//        System.out.println(Arrays.toString(bug_band_array));

        int chicken_width = chicken_data.getWidth();
        int bug_width = bug_data.getWidth();
        int chicken_height = chicken_data.getHeight();
        int bug_height = bug_data.getHeight();

        //Print statements to see the size of pictures
        System.out.println("Chicken image width: " + chicken_width);
        System.out.println("Chicken image height: " + chicken_height);
        System.out.println("Bug image width: " + bug_width);
        System.out.println("Bug image height: " + bug_height);

        System.out.println("Looking for the bug. Please wait.");



        //Multiple level for loop. Application scans each pixel position for each pixel in chicken for each pixel in the bug
        //If bug is not at 0, 0 application takes long time to complete
        for (int i = 0; i < chicken_height - bug_height; i++) {
            for (int j = 0; j < chicken_width - bug_width; j++) {
//                System.out.println("Checking position Y: " + i + ", X: " + j);
                //Boolean value that indicates weather bug is found or not
                boolean isBug = true;
                for (int k = 0; k < bug_height; k++) {
                    for (int l = 0; l < bug_width; l++) {
                        bug_data.getPixel(l, k, bug_band_array);
                        chicken_data.getPixel(l+j, k+i, chicken_band_array);
//                        System.out.println((i+k) + " " + (j+l) +" " + k + " " + l);
                        for (int m = 0; m < numBands; ++m) {

                            if (bug_band_array[m] != chicken_band_array[m]) {
                                isBug = false;
                            }
                        }

                    }
                }
                if (isBug) {
                    System.out.println("Bug is on position: Y: " + i + ", X: " + j);
                    //exist statement to stop loop
                    System.exit(0);
//                } else {
//                    System.out.println("Bug not found.");
               }

            }
        }
    }
}
