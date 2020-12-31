package se.adventofcode.day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day11 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner (new File("src/day11Task1Input.txt"));
        List<String> list = new ArrayList<>();
        List<String> listUpdated = new ArrayList<>();

        while(sc.hasNext()){
            list.add(sc.nextLine());
        }


        for (int i = 1; i < list.size()-1; i++) {
            String string = list.get(i);
            String before = list.get(i-1);
            String after = list.get(i+1);
            middle(string, before, after);


        }



    }

    public static int middle (String string, String before, String after){

        int count = 0;
        for (int j = 1; j < string.length()-1 ; j++) {

            char key = string.charAt(j);

            if(key == '.'){

            }


            if (string.charAt(j-1) == key || string.charAt(j-1) == '.'){
                count +=1;
            }
            if (string.charAt(j+1) == key || string.charAt(j+1) == '.') {
                count +=1;
            }
            if (before.charAt(j-1) == key || before.charAt(j-1) == '.') {
                count +=1;
            }
            if (before.charAt(j) == key || before.charAt(j) == '.'){
                count +=1;
            }
            if (before.charAt(j+1) == key || before.charAt(j+1) == '.'){
                count +=1;
            }
            if (after.charAt(j-1) == key || after.charAt(j-1) == '.'){
                count +=1;
            }
            if (after.charAt(j) == key || after.charAt(j) == '.'){
                count +=1;
            }
            if (after.charAt(j+1) == key || after.charAt(j-1) == '.'){
                count +=1;
            }

        }
        return count;

    }

}
