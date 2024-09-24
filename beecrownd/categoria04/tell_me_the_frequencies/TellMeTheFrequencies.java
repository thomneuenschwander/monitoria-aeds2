package tell_me_the_frequencies;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/** 
 * 
 * Beecrownd 1251
 * link -> https://judge.beecrowd.com/en/problems/view/1251
 * 
 * @author Thomas Neuenschwander
 * @since 16/09/2024
*/
public class TellMeTheFrequencies {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.next();

            Map<Integer, Integer> frequencies = new HashMap<>();
            for (char ch : input.toCharArray())
                frequencies.put((int) ch, frequencies.getOrDefault((int) ch, 0) + 1);

            Set<Map.Entry<Integer, Integer>> sortedValues = new TreeSet<>(Map.Entry.comparingByValue());
            sortedValues.addAll(frequencies.entrySet());

            sortedValues.forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
        }

        sc.close();
    }
}
