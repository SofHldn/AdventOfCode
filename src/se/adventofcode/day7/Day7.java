package se.adventofcode.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day7 {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("src/day7Task1Input.txt");
        Pattern parentPattern = Pattern.compile("^\\w+ \\w+");
        Pattern childPattern = Pattern.compile("\\d+ \\w+ \\w+");
        HashMap<String, List<String>> bagContainers = new HashMap<>();
        List<String> shinyGoldParent1 = new ArrayList<>();


        int count = 0;

        Scanner fileScanner = new Scanner(inputFile);
        while (fileScanner.hasNext()) {
            String nextLine = fileScanner.nextLine();
            Matcher parentMatch = parentPattern.matcher(nextLine);
            parentMatch.find();
            String parent = parentMatch.group();

            Matcher childMatch = childPattern.matcher(nextLine);
            List<String> child = new LinkedList<>();
            while (childMatch.find()) {
                child.add(childMatch.group());
            }
            bagContainers.put(parent, child);
            //System.out.println(bagContainers);

        }


        for (Map.Entry<String, List<String>> entry : bagContainers.entrySet()) {

            List<String> colors = entry.getValue();

            for (String color : colors) {
                if (color.contains("shiny gold")) {
                    count += 1;
                    shinyGoldParent1.add(entry.getKey());
                }
            }

        }

        for (int i = 0; i < 6; i++) {
            for (Map.Entry<String, List<String>> entry : bagContainers.entrySet()) {

                List<String> colors = entry.getValue();

                for (String color : colors) {
                    for (int j = 0; j < shinyGoldParent1.size(); j++) {
                        if (color.contains(shinyGoldParent1.get(j))) {

                            shinyGoldParent1.add(entry.getKey());
                        }
                    }
                }

            }
        }

        Set<String> s = new LinkedHashSet<>(shinyGoldParent1);
        count = s.size();


        System.out.println(count);
        //System.out.println(s);


    }


}
