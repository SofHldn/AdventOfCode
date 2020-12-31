package se.adventofcode.day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day12 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner (new File("src/day12Task1Input.txt"));
        List<String> list = new ArrayList<>();

        while (sc.hasNextLine()){
            list.add(sc.nextLine());
        }

        int north = 0;
        int east = 0;
        int bearing = 90;

        for (String string : list) {

            char code = string.charAt(0);
            int actionValue = Integer.parseInt(string.substring(1));

//            System.out.println(code);
//            System.out.println(actionValue);


            switch (code) {
                case 'N':
                    north += actionValue;
                    break;
                case 'S':
                    north -= actionValue;
                    break;
                case 'E':
                    east += actionValue;
                    break;
                case 'W':
                    east -= actionValue;
                    break;
                case 'L':
                    bearing -= actionValue;
                    if (bearing <= 0) {
                        bearing += 360;
                    }
                    break;
                case 'R':
                    bearing += actionValue;
                    if (bearing > 360) {
                        bearing -= 360;
                    }
                    break;
                case 'F':
                    if (bearing == 360) {
                        north += actionValue;
                    } else if (bearing == 180) {
                        north -= actionValue;
                    } else if (bearing == 90) {
                        east += actionValue;
                    } else if (bearing == 270) {
                        east -= actionValue;
                    }
                    break;
                default:
                    System.out.println("Not a valid code");

            }

        }

        System.out.println(north);
        System.out.println(east);

        if(north < 0){
            north= north*(-1);
        }
        if(east < 0){
            east = east*(-1);
        }

        System.out.println(north + east);



    }


}
