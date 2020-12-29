import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class test {
    public static void main(String[] args) {

            String str = "1:2,2:2,3:2,4:2,2,5";

            //split the string by comma
            String[] strParts = str.split(",");

            //convert array to the List using asList method
            List<String> listParts = Arrays.asList(strParts);

            //create HashSet from the List using constructor
            HashSet<String> hsetFromString = new HashSet<String>( listParts );

            System.out.println("HashSet contains: " + hsetFromString);
        }

}
