package se.adventofcode.day15;

import java.util.*;

public class Day15 {

    public static void main(String[] args) {

        List<Long> input = new ArrayList<>(Arrays.asList(18L, 11L, 9L, 0L, 5L, 1L));
        //List<Long> input = new ArrayList<>(Arrays.asList(0L, 3L, 6L));
        Map<Long, Long> numberPlace = new HashMap();
        long turn = input.size();


            for (long i = 0; i < input.size()-1; i++) {

                numberPlace.put(input.get((int) i), i);

            }

            long lastNumber = input.get(input.size()-1);



            while(true){
                final Long spokenBefore = numberPlace.get(lastNumber);
                numberPlace.put(lastNumber, turn-1);
                lastNumber = spokenBefore == null ? 0 : (turn-1) - spokenBefore;

                turn ++;

                if (turn == 30000000) {
                    System.out.println(lastNumber);
                    break;
                }

            }


    }

}
