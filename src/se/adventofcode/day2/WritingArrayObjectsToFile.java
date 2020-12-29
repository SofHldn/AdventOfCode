package se.adventofcode.day2;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class WritingArrayObjectsToFile {
    public static void main(String[] args) throws FileNotFoundException {

        //create an array of points
        Point[] points = { new Point(3,4), new Point(5,10), new Point(1,-1), new Point(2,4), null, null};

        //to save the array of object, loop through all the elements and save each property of each element to a new line of the file


        //create a file
        File pointFile = new File("points.txt");

        //create a writer
        PrintStream writer = new PrintStream(pointFile);

        //Loop throuh the array and save its elements
        int index = 0;
        while(index < points.length){
            if(points[index] !=null ){
                writer.println(points[index].x);
                writer.println(points[index].y);
            }
            index = index + 1;
        }

        writer.close();

    }
}
