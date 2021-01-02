package se.adventofcode.day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day13part2 {

    //This works on the examples but takes too long time for the actual input


    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("src/day13Task1Input.txt"));
        List<String> list = new ArrayList<>();

        while (sc.hasNextLine()) {
            list.add(sc.nextLine());
        }

        String busString = list.get(1);

        boolean checking = true;
        //String[] busesArray = busString.split(",");


        String [] busesArray = {"1789","37","47","1889"};

        int count = 0;
        for (int i = 1; i < busesArray.length; i++) {
            if (!busesArray[i].equalsIgnoreCase("x")) {
                count += 1;
            }

        }

        long timeStamp = 100011012436511L;
        long solution = 780601154795940L;

        while (checking) {
            timeStamp += Integer.parseInt(busesArray[0]);
            int tempCount = 0;

            for (int i = 1; i < busesArray.length; i++) {
                if (!busesArray[i].equalsIgnoreCase("x")) {
                    if ((timeStamp + i) % Integer.parseInt(busesArray[i]) == 0) {
                        tempCount += 1;
                        System.out.println(tempCount);
                        System.out.println(timeStamp);
                    }
                }
            }

            if(tempCount == count){
                checking = false;
                System.out.println(timeStamp);
            }

        }

    }
}
