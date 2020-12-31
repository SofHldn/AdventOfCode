package se.adventofcode.day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day12part2 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner (new File("src/day12Task1Input.txt"));
        List<String> list = new ArrayList<>();

        while (sc.hasNextLine()){
            list.add(sc.nextLine());
        }

        for (String string:list) {
            char code = string.charAt(0);
            if(code == 'L' || code == 'R'){
                System.out.println(string);
            }

        }

        int waypointNorth = 1;
        int waypointEast = 10;
        int shipPointNorth = 0;
        int shipPointEast = 0;

        for (String string : list) {

            char code = string.charAt(0);
            int actionValue = Integer.parseInt(string.substring(1));

//            System.out.println(code);
//            System.out.println(actionValue);


            switch (code) {
                case 'N':
                    waypointNorth += actionValue;
                    break;
                case 'S':
                    waypointNorth -= actionValue;
                    break;
                case 'E':
                    waypointEast += actionValue;
                    break;
                case 'W':
                    waypointEast -= actionValue;
                    break;
                case 'L':
                    if(actionValue == 90){
                        int temp = waypointEast;
                        waypointEast = waypointNorth*(-1);
                        waypointNorth = temp;
                    }
                    if(actionValue == 180){
                        waypointEast = waypointEast*(-1);
                        waypointNorth = waypointNorth*(-1);
                    }
                    if(actionValue == 270){
                        int temp = waypointEast;
                        waypointEast= waypointNorth;
                        waypointNorth = temp*-1;
                    }
                    break;
                case 'R':
                    if(actionValue == 90){
                        int temp = waypointEast;
                        waypointEast= waypointNorth;
                        waypointNorth = temp*-1;
                    }
                    if(actionValue == 180){
                        waypointEast = waypointEast*(-1);
                        waypointNorth = waypointNorth*(-1);
                    }
                    if(actionValue == 270){
                        int temp = waypointEast;
                        waypointEast = waypointNorth*(-1);
                        waypointNorth = temp;
                    }
                    break;
                case 'F':
                    shipPointNorth = shipPointNorth +(waypointNorth * actionValue);
                    shipPointEast = shipPointEast + (waypointEast * actionValue);
                    break;
                default:
                    System.out.println("Not a valid code");

            }

        }

        System.out.println(shipPointNorth);
        System.out.println(shipPointEast);

        if(shipPointNorth < 0){
            shipPointNorth= shipPointNorth*(-1);
        }
        if(shipPointEast < 0){
            shipPointEast = shipPointEast*(-1);
        }

        System.out.println(shipPointNorth + shipPointEast);



    }

}
