package se.adventofcode.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day4 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("src/day4Task1Input.txt"));
        List<String> list = new ArrayList<>();
        String empty = sc.nextLine();
        String string = empty;

        while (sc.hasNextLine()) {

            empty = sc.nextLine();

            if (!empty.trim().isEmpty()) {
                string = string + " " + empty;

            } else {
                list.add(string);
                string = empty;
            }
        }
        list.add(string);


        //System.out.println(list.size());
        //System.out.println(list.get(110));

        int count = 0;

        for (String s : list) {

            if (check(s)) {
                count++;
            }
        }

        int count2 = 0;

        for( String s : list){
            if(check(s) &&
                    checkByr(s) &&
                    checkIyr(s) &&
                    checkEcl(s) &&
                    checkEyr(s) &&
                    checkHcl(s) &&
                    checkHgt(s) &&
                    checkPid(s)
            ){
                count2++;
            }
        }


        System.out.println("count = "+ count);
        System.out.println("count2 ="+ count2);




        //System.out.println(checkByr(list.get(110)));
        //System.out.println(checkIyr(list.get(110)));
        //System.out.println(checkHgt(list.get(110)));
        //System.out.println(checkEyr(list.get(110)));
        //System.out.println(checkHcl(list.get(110)));
        //System.out.println(checkEcl(list.get(110)));
        //System.out.println(checkPid(list.get(110)));

    }

    public static boolean checkByr(String string) {

        //Splits string by " " into an array, then make array into arraylist
        String[] strParts = string.split(" ");
        List<String> listParts = Arrays.asList(strParts);

        String birthYear = "byr:";
        int birthY = 0;

        for (String temp : listParts) {

            if (temp.startsWith(birthYear)) {
                birthY = Integer.parseInt(temp.substring(temp.indexOf(":") + 1));
                //System.out.println(birthY);
            }
        }

        return birthY >= 1920 && birthY <= 2002;
    }

    public static boolean checkIyr(String string) {

        String[] strParts = string.split(" ");
        List<String> listParts = Arrays.asList(strParts);

        String issueYear = "iyr:";
        int sub = 0;

        for (String temp : listParts) {
            if (temp.startsWith(issueYear)) {
                sub = Integer.parseInt(temp.substring(temp.indexOf(":") + 1));
                //System.out.println(sub);
            }
        }

        return sub >= 2010 && sub <= 2020;
    }

    public static boolean checkEyr(String string) {

        String[] strParts = string.split(" ");
        List<String> listParts = Arrays.asList(strParts);

        String expirationYear = "eyr:";
        int sub = 0;

        for (String temp : listParts) {
            if (temp.startsWith(expirationYear)) {
                sub = Integer.parseInt(temp.substring(temp.indexOf(":") + 1));
                //System.out.println(sub);
            }
        }

        return sub >= 2020 && sub <= 2030;
    }

    public static boolean checkHgt(String string) {

        String[] strParts = string.split(" ");
        List<String> listParts = Arrays.asList(strParts);

        String height = "hgt:";
        String sub;

        for (String temp : listParts) {
            if (temp.startsWith(height)) {
                sub = temp.substring(temp.indexOf(":") + 1);
                if (sub.length() < 4) {
                    return false;
                }
                String heightUnit = sub.substring(Math.max(sub.length() - 2, 0));
                int heightT = Integer.parseInt(temp.substring(temp.indexOf(":") + 1, temp.length() - 2));


                if (heightUnit.equalsIgnoreCase("cm") && heightT >= 150 && heightT <= 193) {
                    return true;
                } else return heightUnit.equalsIgnoreCase("in") && heightT >= 59 && heightT <= 76;

            }
        }
        return false;
    }

    public static boolean checkHcl(String string) {

        String[] strParts = string.split(" ");
        List<String> listParts = Arrays.asList(strParts);

        String hairColor = "hcl:";
        String sub = null;

        for (String temp : listParts) {
            if (temp.startsWith(hairColor)) {
                sub = temp.substring(temp.indexOf(":") + 1);
                //System.out.println(sub);
            }
        }

        assert sub != null;
        if (sub.length() == 7 && sub.startsWith("#")) {

            return sub.substring(1, 7).matches("[a-f0-9]+");
        }

        return false;
    }

    public static boolean checkEcl(String string) {

        String[] strParts = string.split(" ");
        List<String> listParts = Arrays.asList(strParts);

        String eyeColor = "ecl:";
        String sub = null;

        for (String temp : listParts) {
            if (temp.startsWith(eyeColor)) {
                sub = temp.substring(temp.indexOf(":") + 1);
                //System.out.println(sub);
            }
        }

        assert sub != null;
        return sub.equals("amb") ||
                sub.equals("blu") ||
                sub.equals("brn") ||
                sub.equals("gry") ||
                sub.equals("grn") ||
                sub.equals("hzl") ||
                sub.equals("oth");
    }

    public static boolean checkPid(String string) {

        String[] strParts = string.split(" ");
        List<String> listParts = Arrays.asList(strParts);

        String passPortId = "pid:";
        String sub = null;

        for (String temp : listParts) {
            if (temp.startsWith(passPortId)) {
                sub = temp.substring(temp.indexOf(":") + 1);
                //System.out.println(sub);
            }
        }

        assert sub != null;
        return sub.length() == 9 && sub.matches("[0-9]+");
    }


    // if(sub >= "a" && sub <= "b"){
    //   return true;
    //}else{
    //  return false;
    //}


    public static boolean check(String string) {

        String birthYear = "byr:";
        String issueYear = "iyr:";
        String expirationYear = "eyr:";
        String height = "hgt:";
        String hairColor = "hcl:";
        String eyeColor = "ecl:";
        String passportID = "pid:";
        String countryID = "cid:";


        return string.contains(birthYear) &&
                string.contains(issueYear) &&
                string.contains(expirationYear) &&
                string.contains(height) &&
                string.contains(hairColor) &&
                string.contains(eyeColor) && string.contains(passportID);

    }

}
