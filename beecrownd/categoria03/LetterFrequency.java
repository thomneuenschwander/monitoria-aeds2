import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * LetterFrequency
 * 
 * link -> https://judge.beecrowd.com/en/problems/view/1255
 * 
 * 
 * Análise assintótica:
 * 
 * O(1) -> Operaçoes usando mapeamento hash (LinkedHashMap)
 * O(N) -> Converter String para char array (toCharArray)
 * O(N) -> Para percorres os caracteres do char array
 * 
 * Total -> O(N)
 *
 * @author Thomas Neuenschwander
 * @since 25/06/2024
 */
public class LetterFrequency {

    static Map<Character, Integer> mapLettersFrequency(String line) {
        char[] charLine = line.toCharArray();

        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();

        for (char letter : charLine)
            frequencyMap.put(letter, frequencyMap.getOrDefault(letter, 0) + 1);

        return frequencyMap;
    }

    static String getMostFrequentlyLetters(String line) {
        Map<Character, Integer> lettersMapped = mapLettersFrequency(line);
        StringBuilder sb = new StringBuilder();

        int biggestOccurrence = 0;

        for (char letter : lettersMapped.keySet()) {
            int occurrence = lettersMapped.get(letter);
            if (occurrence > biggestOccurrence)
                biggestOccurrence = occurrence;
        }
        for (char letter : lettersMapped.keySet()) {
            int occurrence = lettersMapped.get(letter);
            if (occurrence == biggestOccurrence)
                sb.append(letter);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            String frequentlyLetters = getMostFrequentlyLetters(line);
            System.out.println(frequentlyLetters);
        }
        sc.close();
    }
}
