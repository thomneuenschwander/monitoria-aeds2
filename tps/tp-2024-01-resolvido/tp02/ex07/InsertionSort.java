package tp02.ex07;

import tp02.Character;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class InsertionSort {
    static final String PATH = "../characters.csv";
    static final String INPUT_BREAK = "FIM";

    static final Comparator<Character> BY_DOB_THEN_BY_NAME = Comparator
            .comparing(Character::getDateOfBirth)
            .thenComparing(Character::getName);

    public static void sort(Character[] characters) {
        for (int i = 1; i < characters.length; i++) {
            Character temp = characters[i];
            int j = i - 1;
            while (j >= 0 && BY_DOB_THEN_BY_NAME.compare(temp, characters[j]) < 0)
                characters[j + 1] = characters[j--];
            characters[j + 1] = temp;
        }
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
        InsertionSort.sort(selectedCharactersArray);

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