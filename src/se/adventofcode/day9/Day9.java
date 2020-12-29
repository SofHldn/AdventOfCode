package se.adventofcode.day9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day9 {

    public static void main(String[] args) throws FileNotFoundException {

        //Reads file and adds every line (number) to arrayList
        Scanner sc = new Scanner(new File("src/day9Task1Input.txt"));
        List<Long> list = new ArrayList<>();

        while(sc.hasNextLine()){
            list.add(sc.nextLong());
        }



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
                System.out.println(list.get(i));
                break;
            }


        }

    }

}
