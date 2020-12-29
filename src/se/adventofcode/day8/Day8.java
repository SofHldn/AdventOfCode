package se.adventofcode.day8;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day8 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("src/day8Task1Input.txt"));
        List<String> list = new ArrayList<>();



        //adds every line to ArrayList
        while(sc.hasNextLine()){
            list.add(sc.nextLine());
        }


        int accumulator = 0;
        List<Integer> numbers = new ArrayList<>();
        boolean quit = false;

            for (int i = 0; i < list.size(); i++) {


                //splits every line (string) into two parts (code & action)
                String string = list.get(i);
                String code = string.substring(0, 3);
                int action = Integer.parseInt(string.substring(string.indexOf(" ")).trim());


                //loop will check if any i is trying to run for a second time
                for (int number : numbers) {
                    if (number == i) {
                        quit = true;
                    }
                }

                numbers.add(i);


                //different action depending on code
                if (quit) {

                    break;

                } else if (code.equals("acc") ) {

                    accumulator += action;

                } else if (code.equals("jmp" )) {

                    i = i + action - 1;

                } else if (code.equals("nop"))  {

                }

            }


            System.out.println(accumulator);



    }
}
