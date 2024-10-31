package tp02.ex11;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

import tp02.Character;

/**
 * @author Thomas Neuenschwander
 * @since 2024-11-10
 * @see https://github.com/thomneuenschwander
 */
public class CountingSort {
    static final String PATH = "../characters.csv";
    static final String INPUT_BREAK = "FIM";
    static final Map<String, Character> ALL_CHARACTERS = Character.readFromCSV(PATH);

    static final int MAX_CHARACTER_AGE = 140;
    static final int MIN_YEAR_OF_BIRTH = 1880;
    static final int MAX_YEAR_OF_BIRTH = MIN_YEAR_OF_BIRTH + MAX_CHARACTER_AGE;

    public static void sort(Character[] array) {
        int[] count = countFrequencies(array);

        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];

        Character[] sorted = new Character[array.length];
        for (int i = array.length - 1; i >= 0; i--)
            sorted[--count[array[i].yearOfBirth() - MIN_YEAR_OF_BIRTH]] = array[i];

        System.arraycopy(sorted, 0, array, 0, array.length);
    }

    static int[] countFrequencies(Character[] array) {
        int range = MAX_YEAR_OF_BIRTH - MIN_YEAR_OF_BIRTH + 1;
        int[] freq = new int[range];

        for (Character character : array) {
            int yearKey = character.yearOfBirth() - MIN_YEAR_OF_BIRTH;
            if (yearKey < 0 || yearKey >= range)
                throw new IllegalStateException(character.yearOfBirth() + " is out of yearOfBirth range");
            freq[yearKey]++;
        }
        return freq;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            List<Character> selectedCharacters = new ArrayList<>();

            processInput(sc, id -> {
                var character = ALL_CHARACTERS.get(id);
                if (character != null)
                    selectedCharacters.add(character);
            });

            Character[] selectedCharactersArray = selectedCharacters.stream().toArray(Character[]::new);
            CountingSort.sort(selectedCharactersArray);

            for (var character : selectedCharactersArray)
                System.out.println(character);
        }
    }

    static void processInput(Scanner sc, Consumer<String> inputOperation) {
        String input;
        while (!(input = sc.nextLine()).equals(INPUT_BREAK))
            inputOperation.accept(input);
    }
}
