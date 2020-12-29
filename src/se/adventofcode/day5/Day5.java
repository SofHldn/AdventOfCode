package se.adventofcode.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) throws FileNotFoundException {

        int numberOfRows;
        int numberOfColumns;
        int upperLimit;
        int lowerLimit;
        int rightLimit;
        int leftLimit;
        char rowIndication;
        char columnIndication;
        int seatRow = 0;
        int seatColumn = 0;
        int seatId;
        int highestSeatId = 0;

        Scanner sc = new Scanner(new File("C:\\Source\\AdventOfCode\\src\\day5Task1Input.txt"));

        List<String> list = new ArrayList<>();
        List<Integer> seatIDList = new ArrayList<>();

        while (sc.hasNextLine()) {
            list.add(sc.nextLine());
        }

        for (String seatCode : list) {
            numberOfRows = 128;
            numberOfColumns = 8;
            upperLimit = 127;
            lowerLimit = 0;
            rightLimit = 7;
            leftLimit = 0;

            for (int i = 0; i < 7; i++) {
                rowIndication = seatCode.charAt(i);
                numberOfRows = numberOfRows / 2;

                if (i == 6 && rowIndication == 'F') {
                    seatRow = lowerLimit;
                } else if (i == 6 && rowIndication == 'B') {
                    seatRow = upperLimit;
                } else if (i < 6 && rowIndication == 'F') {
                    upperLimit = upperLimit - numberOfRows;

                } else if (i < 6 && rowIndication == 'B') {
                    lowerLimit = (upperLimit - numberOfRows) + 1;
                }
            }

            for (int i = 7; i < 10; i++) {
                columnIndication = seatCode.charAt(i);
                numberOfColumns = numberOfColumns / 2;

                if (i == 9 && columnIndication == 'L') {
                    seatColumn = leftLimit;
                } else if (i == 9 && columnIndication == 'R') {
                    seatColumn = rightLimit;
                } else if (i < 9 && columnIndication == 'L') {
                    rightLimit = rightLimit - numberOfColumns;

                } else if (i < 9 && columnIndication == 'R') {
                    leftLimit = (rightLimit - numberOfColumns) + 1;
                }
            }

            seatId = (seatRow * 8) + seatColumn;
            seatIDList.add(seatId);

            if (seatId > highestSeatId) {
                highestSeatId = seatId;
            }

            //System.out.println(seatId);
            //System.out.println(highestSeatId);


        }

        System.out.println(highestSeatId);

        //Part 2
        Collections.sort(seatIDList);

        int mySeatID = 0;
        for (int i = 0; i< seatIDList.size()-1; i++) {
            if (seatIDList.get(i + 1) - seatIDList.get(i) != 1) {
                mySeatID = seatIDList.get(i) + 1;
            }
        }

        System.out.println("mySeatID = " + mySeatID);
    }
}

