package se.adventofcode.day2;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadArrayObjectsFromAFile {
    public static void main(String[] args) {

        Point[] points = new Point[10];


        try{
            File pointFile = new File("points.txt");
            Scanner pointReader = new Scanner( pointFile);

            int x, y;
            int index = 0;

            while(pointReader.hasNext()){
                x = pointReader.nextInt();
                y = pointReader.nextInt();

                points[index] = new Point(x,y);
                index+=1;

            }

            pointReader.close();
        } catch (FileNotFoundException fnf) {
            System.out.println("The file wasnt found");
        }

        for(int i=0; i< points.length; i++){
            System.out.println(points[i]);
        }



    }
}
