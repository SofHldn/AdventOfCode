package se.adventofcode.day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day8part2 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("src/day8Task1Input.txt"));
        List<String> list = new ArrayList<>();



        //adds every line to an ArrayList
        while(sc.hasNextLine()){
            list.add(sc.nextLine());
        }


        //Next two forLoops checks how many "nop" or "jmp" exists and saves their index number in two new arrays
        List<Integer> nopIndex = new ArrayList<>();
        List<Integer> jmpIndex = new ArrayList<>();

        for (String nop : list) {
            String code = nop.substring(0, 3);
            if(code.equals("nop")){
                nopIndex.add(list.indexOf(nop));
            }

        }

        for (String jmp : list) {
            String code = jmp.substring(0, 3);
            if(code.equals("jmp")){
                jmpIndex.add(list.indexOf(jmp));
            }

        }

//        System.out.println(jmpIndex);
//        System.out.println(jmpIndex.size());
//        System.out.println(nopIndex);
//        System.out.println(nopIndex.size());




        //Outer loop: loops through jmpIndex array to switch only one jmp at a time. Change to nopIndex.size() if you want to try switch nop.
        for (int j = 0; j < jmpIndex.size() ; j++) {

            int countI = 0;
            int accumulator = 0;
            List<Integer> numbers = new ArrayList<>();
            boolean quit = false;

            for (int i = 0; i < list.size(); i++) {

                countI = i;
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


                // different action depending on code
                if (quit) {

                    break;

                } else if (code.equals("acc") ) {

                    accumulator += action;

                //if jmp index matches i (listIndex) it will change the jmp-action to a nop-action
                } else if (code.equals("nop") || jmpIndex.get(j) == i) {

                //if nop index matches i (listIndex) it will change the nop-action to a jmp-action - switch this line with above if trying to change nop.
                } else if (code.equals("jmp" ) /*|| nopIndex.get(j) == i*/) {

                    i = i + action - 1;

                }
            }


            //Only if program loops through to last line it will work. This checks if last line was run and in that case prints accumulator value
            if(countI == list.size()-1){
                //System.out.println(countI);
                //System.out.println(j);
                System.out.println("Accumulator: " + accumulator);
                break;
            }

        }


    }

}
