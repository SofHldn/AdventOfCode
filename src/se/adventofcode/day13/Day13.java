package se.adventofcode.day13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day13 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner (new File("src/day13Task1Input.txt"));
        List<String> list = new ArrayList<>();

        while (sc.hasNextLine()){
            list.add(sc.nextLine());
        }

        int earliestTimeStamp = Integer.parseInt(list.get(0));
        String busString = list.get(1);

        String[] busesArray = busString.split(",");
        List<Integer> busesFinal = new ArrayList<>();



        for (int i = 0; i < busesArray.length; i++) {
            if(!busesArray[i].trim().equalsIgnoreCase("x")){
                busesFinal.add(Integer.parseInt(busesArray[i]));
            }

        }

        List<Integer> timeStamps = new ArrayList<>();


        for (Integer bus: busesFinal) {
            for (int i = 0; i < earliestTimeStamp*2 ; i =i+bus) {
                if (i > earliestTimeStamp){
                    timeStamps.add(i);
                }
            }

        }

        int earliestBus = busesFinal.get(timeStamps.indexOf(Collections.min(timeStamps)));

        System.out.println((timeStamps.get(0)-earliestTimeStamp)*earliestBus);


        System.out.println(busesFinal);



    }
}
