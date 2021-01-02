package se.adventofcode.day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day13part2VersionB {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("src/day13Task1Input.txt"));
        List<String> list = new ArrayList<>();

        while (sc.hasNextLine()) {
            list.add(sc.nextLine());
        }

        String busString = list.get(1);

        boolean checking = true;

        List<Long> buses = new ArrayList<>();

        for (String bus : busString.split(",")) {
            buses.add(bus.equals("x") ? -1 : Long.parseLong(bus));
        }


        //String [] busesArray = {"1789","37","47","1889"};


        //long solution = 780601154795940L;


        long minutes = buses.get(0);
        long timeStamp = minutes;
        int index = 1;

        while (checking) {

            Long id = buses.get(index);

            //if busnr is -1 (original x) then just increase index
            if (id == -1) {
                index++;
                continue;
            }


            //Magic happens here, cred to Stevo
            if ((timeStamp + index) % id == 0) {

                index++;

                if (index >= buses.size()) {
                    System.out.println(timeStamp);
                    checking = false;
                }

                minutes *= id;
                continue;
            }

            timeStamp += minutes;
        }


    }

}
