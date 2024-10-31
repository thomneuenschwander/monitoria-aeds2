package tp02.ex03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Consumer;

import tp02.Character;

/**
 * @author Thomas Neuenschwander
 * @since 2024-10-10
 * @see https://github.com/thomneuenschwander
 */
public class LinearSearch {
    static final String PATH = "../characters.csv";
    static final String INPUT_BREAK = "FIM";
    static final Map<String, Character> ALL_CHARACTERS = Character.readFromCSV(PATH);

    public static Optional<Character> searchByName(List<Character> characters, String name) {
        return characters.stream().filter(c -> c.name().equals(name)).findFirst();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            List<Character> selectedCharacters = new ArrayList<>();

            processInput(sc, id -> {
                var character = ALL_CHARACTERS.get(id);
                if (character != null)
                    selectedCharacters.add(character);
            });
            processInput(sc, name -> {
                var character = LinearSearch.searchByName(selectedCharacters, name);
                String output = character.isPresent() ? "SIM" : "NAO";
                System.out.println(output);
            });
        }
    }

    static void processInput(Scanner sc, Consumer<String> inputOperation) {
        String input;
        while (!(input = sc.nextLine()).equals(INPUT_BREAK))
            inputOperation.accept(input);
    }
}