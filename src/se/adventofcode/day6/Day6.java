package se.adventofcode.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Day6 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("C:\\Source\\AdventOfCode\\src\\day6Task1Input.txt"));

        List<String> list = new ArrayList<>();
        String isEmptyLine = sc.nextLine();
        String tempLine = isEmptyLine;
        int size = 0;

        while (sc.hasNextLine()) {

            isEmptyLine = sc.nextLine();

            if (!isEmptyLine.trim().isEmpty()) {
                tempLine = tempLine + isEmptyLine;

            } else {
                list.add(tempLine);
                tempLine = isEmptyLine;
            }
        }
        list.add(tempLine);


        for( String string : list) {
            char[] chars = string.toCharArray();
            Set<Character> charSet = new LinkedHashSet<>();

            for (char c : chars) {
                charSet.add(c);
            }

            size = size + charSet.size();
            //System.out.println(charSet);
            //System.out.println(size);
        }
        System.out.println(size);
    }
}
