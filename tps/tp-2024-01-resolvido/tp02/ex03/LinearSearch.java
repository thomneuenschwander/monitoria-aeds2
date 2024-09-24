package tp02.ex03;

import tp02.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Consumer;

public class LinearSearch {
    static final String PATH = "../characters.csv";
    static final String INPUT_BREAK = "FIM";

    public static Optional<Character> searchByName(List<Character> characters, String name) {
        return characters.stream().filter(c -> c.getName().equals(name)).findFirst();
    }

    public static void main(String[] args) {
        var allCharacters = Character.readFromCSV(PATH);

        Scanner sc = new Scanner(System.in);
        List<Character> selectedCharacters = new ArrayList<>();

        processInput(sc, id -> {
            var character = allCharacters.stream().filter(c -> c.getId().equals(id)).findFirst();
            character.ifPresent(selectedCharacters::add);
        });
        processInput(sc, name -> {
            var character = LinearSearch.searchByName(selectedCharacters, name);
            String output = character.isPresent() ? "SIM" : "NAO";
            System.out.println(output);
        });

        sc.close();
    }

    static void processInput(Scanner sc, Consumer<String> inputOperation) {
        String input;
        while (!(input = sc.nextLine()).equals(INPUT_BREAK))
            inputOperation.accept(input);
    }
}