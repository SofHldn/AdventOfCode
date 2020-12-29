package se.adventofcode.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("src/day2Task1Input.txt"));
        ArrayList<String> list = new ArrayList<>();

        while (sc.hasNextLine())
            list.add(sc.nextLine());
        int count = 0;


        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            int firstNumber = Integer.parseInt(s.substring(0, s.indexOf("-")));
            int secondNumber = Integer.parseInt(s.substring(s.indexOf("-") + 1, s.indexOf(" ")));
            String keyString = s.substring(s.indexOf(" ") + 1, s.indexOf(":"));
            char keyChar = keyString.charAt(0);
            String passWord = s.substring(s.lastIndexOf(" ") + 1);
            long keyCharcount = passWord.codePoints().filter(ch -> ch == keyChar).count();


            if (keyCharcount >= firstNumber && keyCharcount <= secondNumber) {
                count++;

            }

        }
        System.out.println(count);
//        System.out.println(s);
//        System.out.println(firstNumber);
//        System.out.println(secondNumber);
//        System.out.println(keyChar);
//        System.out.println(passWord);

        //System.out.println(list);




        //PART 2
        int count2 = 0;

        for (int i = 0; i < list.size(); i++) {

            String s = list.get(i);
            int firstNumber = Integer.parseInt(s.substring(0, s.indexOf("-")));
            int secondNumber = Integer.parseInt(s.substring(s.indexOf("-") + 1, s.indexOf(" ")));
            String keyString = s.substring(s.indexOf(" ") + 1, s.indexOf(":"));
            char keyChar = keyString.charAt(0);
            String passWord = s.substring(s.lastIndexOf(" ") + 1);


            if (passWord.charAt(firstNumber - 1) == keyChar && passWord.charAt(secondNumber - 1) != keyChar) {
                count2++;
            } else if (passWord.charAt(secondNumber - 1) == keyChar && passWord.charAt(firstNumber - 1) != keyChar) {
                count2++;
            }

        }
        System.out.println(count2);
    }


}
