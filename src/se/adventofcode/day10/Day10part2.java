package se.adventofcode.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Arrays;
import java.util.List;

public class Day10part2 {


    public static void main(String[] args) throws FileNotFoundException {

        final int[] list = getInput();

        // create new array that is as many indexes as the highest value in list + 1
        final long[] sums = new long[list[list.length - 1] + 1];


        //Magic happens here
        for (int i = 0; i < list.length; i++) {

            System.out.println();
            System.out.println(list[i]);
            final long x = list[i] >= 3 ? sums[list[i]-3] : 0;
            final long y = list[i] >= 2 ? sums[list[i]-2] : 0;
            final long z = list[i] >= 1 ? sums[list[i]-1] : 1;
            sums[list[i]] = x + y + z;

//            System.out.println("sums: " + sums[list[i]]);
//            System.out.println("x: " +x);
//            System.out.println("y: " +y);
//            System.out.println("z: " +z);
        }

        //gets value at last position
        System.out.println(sums[sums.length - 1]);
    }


    public static int[] getInput() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/day10Task1Input.txt"));

        List<Integer> list = new ArrayList<>();

        while (sc.hasNextLine()) {
            list.add(sc.nextInt());
        }
        list.add(0);
        Collections.sort(list);
        int myDevice = list.get(list.size() - 1) + 3;
        list.add(myDevice);

        int [] numbers = new int [list.size()];
        for (int i = 0; i < list.size(); i++) {
            numbers [i] = list.get(i);
        }


        return numbers;
    }


}
