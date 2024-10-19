package hardwood_species;

import java.util.*;

/**
 * Hardwood Species
 * 
 * Beecrownd 1260
 * link -> https://judge.beecrowd.com/en/problems/view/1260
 * 
 * @author Thomas Neuenschwander
 * @since 18/10/2024
 */
public class HardwoodSpecies {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int testCases = sc.nextInt();
            sc.nextLine();

            while (testCases-- > 0) {
                Map<String, Integer> speciesCount = new TreeMap<>();
                int totalTrees = 0;

                while (sc.hasNextLine()) {
                    String species = sc.nextLine();
                    if (species.isEmpty())
                        break;

                    speciesCount.put(species, speciesCount.getOrDefault(species, 0) + 1);
                    totalTrees++;
                }
                for (var entry : speciesCount.entrySet())
                    System.out.printf("%s %.4f%n", entry.getKey(), (entry.getValue() * 100.0) / totalTrees);

                if (testCases > 0)
                    System.out.println();

            }
        }
    }
}
