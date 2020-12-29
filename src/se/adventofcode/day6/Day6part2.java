package se.adventofcode.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day6part2 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("C:\\Source\\AdventOfCode\\src\\day6Task1Input.txt"));
        List<String> list = new ArrayList<>();
        String isEmptyLine = sc.nextLine();
        StringBuilder tempLine = new StringBuilder(isEmptyLine);

        while (sc.hasNextLine()){

            isEmptyLine = sc.nextLine();

            if(!isEmptyLine.trim().isEmpty()){
                tempLine.append(" ").append(isEmptyLine);

            }else {
                list.add(tempLine.toString());
                tempLine = new StringBuilder(isEmptyLine);
            }

        }
        list.add(tempLine.toString());

        int totalCount = 0;

        for (String string : list ) {
            System.out.println(string);

            String[] stringParts = string.trim().split(" ");
            List<String> listParts = Arrays.asList(stringParts);

            int count = 0;

            for (int i = 0; i < listParts.get(0).length(); i++) {
                String comparePart = listParts.get(0).substring(i, i + 1);

                int partCount = 0;
                for (int j = 1; j < listParts.size(); j++) {

                    if (listParts.get(j).contains(comparePart)) {
                        partCount = partCount + 1;
                    }

                }
                if (partCount == listParts.size() - 1) {
                    count = count + 1;
                }
            }


            System.out.println(count);
            totalCount = totalCount+count;
        }

        System.out.println("totalCount: "+ totalCount);
    }
}
