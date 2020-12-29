package se.adventofcode.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day3 {

    static Scanner sc;

    static {
        try {
            sc = new Scanner(new File("C:\\Source\\AdventOfCode\\src\\day3Task1Input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static List<String> list = new ArrayList<>();


    public static void main(String[] args) throws FileNotFoundException {


        while (sc.hasNextLine())
            list.add(sc.nextLine());


        long slopeOne = (long) countTrees(1,1);
        long slopeTwo = (long) countTrees(3,1);
        long slopeThree = (long) countTrees(5,1);
        long slopeFour = (long) countTrees(7,1);
        long slopeFive = (long) countTrees(1,2);

        long sum =(slopeOne * slopeTwo * slopeThree * slopeFour * slopeFive);

        System.out.println(sum);

    }

    public static int countTrees(int horizontalMove, int verticalMove) {

        int positionInString = 0;
        int count = 0;

        for (int i = 0; i < list.size() - verticalMove; i++) {
            int j = i + verticalMove;
            String horizontal = list.get(i);
            String vertical = list.get(j);
            char tree = '#';
            positionInString += horizontalMove;

            //System.out.println(horizontal.charAt(positionInString));
            //System.out.println(vertical.charAt(positionInString));

            if (vertical.charAt(positionInString) == tree) {
                count++;
            }

            if (positionInString > (30-horizontalMove)) {
                positionInString = positionInString - 31;
            }
            i = j - 1;

        }

        return(count);


    }
}
