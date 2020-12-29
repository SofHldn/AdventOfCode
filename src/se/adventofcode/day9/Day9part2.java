package se.adventofcode.day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day9part2 {
    public static void main(String[] args) throws FileNotFoundException {

        //Reads file and adds every line (number) to arrayList
        Scanner sc = new Scanner(new File("src/day9Task1Input.txt"));
        List<Long> list = new ArrayList<>();

        while(sc.hasNextLine()){
            list.add(sc.nextLong());
        }


        long invalidNumber = 0;
        int maxIndex = 0;

        //Starts at number 25 because the first numbers are preamble(starting numbers)
        for (int i = 25; i <list.size() ; i++) {
            boolean quit = false;

            //This span will loop through the 25 numbers before the one we are checking (i) to see if any pair adds up to that.
            for (int j = i-25 ; j < i; j++) {
                for(int k = (j+1); k < i; k++){

                    if (list.get(j) + list.get(k) == list.get(i)) {
                        quit = true;

                    }
                }
            }

            if(quit){

            }else {
                invalidNumber = list.get(i);
                maxIndex = i;

                break;
            }

        }


        //Part 2


        int lowIndex = 0;
        int highIndex = 0;


        //for each loop the previous start number gets removed
        for (int i = 0; i < maxIndex; i++) {

            long sum = 0;

            //Adds each number to sum and checks if sum equals the Invalid number
            for (int j = i; j < maxIndex; j++) {

                sum += list.get(j);
                if (sum == invalidNumber) {
                    System.out.println();
                    lowIndex = i;
                    highIndex = j;
                }
            }
        }


        //New arrayList with all the values that together adds up tp the invalid number
        List<Long> contiguousSet = new ArrayList<>();

        for (int i = lowIndex; i < highIndex +1; i++) {
            contiguousSet.add(list.get(i));
        }

        Collections.sort(contiguousSet);

        //Adds lowest and highest number in the Array
        long finalAnswer = contiguousSet.get(0)+contiguousSet.get(contiguousSet.size()-1);

        System.out.println(finalAnswer);

    }
}
