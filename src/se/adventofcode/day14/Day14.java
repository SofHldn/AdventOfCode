package se.adventofcode.day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day14 {

    public static void main(String[] args) throws FileNotFoundException {


        Scanner sc = new Scanner(new File("src/day14Task1Input.txt"));
        List<String> list = new ArrayList<>();
        char[] mask = new char[36];
        Map<Integer, Long> memory = new HashMap();

        while (sc.hasNextLine()) {
            list.add(sc.nextLine());
        }


        for (int j = 0; j < list.size(); j++) {
            String temp = list.get(j);


            if (temp.startsWith("mask")) {
                mask = temp.substring(temp.indexOf("= ") + 2).toCharArray();

                continue;
            }
            if (temp.startsWith("mem")) {
                int memPlace = Integer.parseInt(temp.substring(temp.indexOf("[") + 1, temp.indexOf("]")));
                int decimal = Integer.parseInt(temp.substring(temp.indexOf("=") + 2));

                long result = toDecimal(maskUpdate(mask, toBinary(decimal)));

                memory.put(memPlace, result);


            }

        }


        long sum = 0;

        for (Long value : memory.values()) {
            sum = sum + value;

        }

        System.out.println(sum);


    }

    public static long toDecimal(int[] binary) {

        int binSize = 0;

        for (int i = 0; i < binary.length; i++) {
            if (binary[i] == 0) {
                binSize += 1;
            } else {
                break;
            }
        }


        char[] bin = new char[binary.length - binSize];
        int index = 0;

        for (int i = binSize; i < binary.length; i++) {

            bin[index] = Character.forDigit(binary[i], 10);
            index += 1;

        }

        String binString = String.valueOf(bin);


        long decimal = 0L;
        int n = 0;

        while (true) {
            if (binString.length() == 1 && binString.startsWith("0")) {
                break;
            } else if (binString.length() == 1) {
                int temp = Integer.parseInt(binString.substring(binString.length() - 1));
                decimal += temp * Math.pow(2, n);
                binString = "0";

            } else {
                int temp = Integer.parseInt(binString.substring(binString.length() - 1));
                decimal += temp * Math.pow(2, n);
                binString = binString.substring(0, binString.length()-1);
                n++;

            }
        }


        return decimal;


    }


    public static int[] maskUpdate(char[] mask, int[] binary) {


        for (int i = 0; i < mask.length; i++) {
            if (!(mask[i] == ('X'))) {
                binary[i] = Integer.parseInt(String.valueOf(mask[i]));
            }
        }


        return binary;
    }


    public static int[] toBinary(int decimal) {
        int[] binary = new int[36];
        int index = binary.length - 1;
        while (decimal > 0) {
            binary[index--] = decimal % 2;
            decimal = decimal / 2;
        }


        return binary;

    }


}
