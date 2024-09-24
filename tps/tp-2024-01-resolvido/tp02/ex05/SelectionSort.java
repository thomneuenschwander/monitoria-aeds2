package tp02.ex05;

import tp02.Character;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class SelectionSort {
    static final String PATH = "../characters.csv";
    static final String INPUT_BREAK = "FIM";

    static final Comparator<Character> BY_NAME = Comparator.comparing(Character::getName);

    public static void sort(Character[] characters) {
        for (int i = 0; i < characters.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < characters.length; j++) {
                if (BY_NAME.compare(characters[j], characters[minIndex]) < 0) 
                    minIndex = j;
            }
            swap(characters, i, minIndex);
        }
    }

    static void swap(Character[] characters, int i, int j) {
        Character temp = characters[i];
        characters[i] = characters[j];
        characters[j] = temp;
    }

    public static void main(String[] args) {
        var allCharacters = Character.readFromCSV(PATH);

        Scanner sc = new Scanner(System.in);
        List<Character> selectedCharacters = new ArrayList<>();

        processInput(sc, id -> {
            var character = allCharacters.stream().filter(c -> c.getId().equals(id)).findFirst();
            character.ifPresent(selectedCharacters::add);
        });

        Character[] selectedCharactersArray = selectedCharacters.stream().toArray(Character[]::new);
        SelectionSort.sort(selectedCharactersArray);

        for (var character : selectedCharactersArray) 
            System.out.println(character);
            
        sc.close();
    }

    static void processInput(Scanner sc, Consumer<String> inputOperation) {
        String input;
        while (!(input = sc.nextLine()).equals(INPUT_BREAK))
            inputOperation.accept(input);
    }
}
