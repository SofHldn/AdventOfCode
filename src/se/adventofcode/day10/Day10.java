package se.adventofcode.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day10 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner (new File("src/day10Task1Input.txt"));

        List<Integer> list = new ArrayList<>();

        while(sc.hasNextLine()){
            list.add(sc.nextInt());
        }

        list.add(0);

        Collections.sort(list);

        int myDevice = list.get(list.size()-1) + 3;

        list.add(myDevice);

        System.out.println(list.size());
        System.out.println(list);


        int count1Jolts = 0;
        int count2Jolts = 0;
        int count3Jolts = 0;

        for (int i = 0; i < list.size()-1; i++) {

            int diff = list.get(i+1) - list.get(i);

            if (diff == 1){
                count1Jolts +=1;
            }else if (diff == 2){
                count2Jolts += 1;
            }else if (diff == 3){
                count3Jolts += 1;
            }

        }

        System.out.println(count1Jolts);
        System.out.println(count2Jolts);
        System.out.println(count3Jolts);

        int answer = count1Jolts * count3Jolts;
        System.out.println("Answer: " + answer);


    }
}
