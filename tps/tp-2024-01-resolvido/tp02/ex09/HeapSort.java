package tp02.ex09;

import tp02.Character;
import java.util.Comparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class HeapSort {
    static final String PATH = "../characters.csv";
    static final String INPUT_BREAK = "FIM";

    static final Comparator<Character> BY_HAIR_COLOR_THEN_BY_NAME = Comparator.comparing(Character::getHairColour)
            .thenComparing(Character::getName);

    public static void sort(Character[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        for (int i = n - 1; i > 0; i--) {
            Character temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    static void heapify(Character[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && BY_HAIR_COLOR_THEN_BY_NAME.compare(array[left], array[largest]) > 0)
            largest = left;

        if (right < n && BY_HAIR_COLOR_THEN_BY_NAME.compare(array[right], array[largest]) > 0)
            largest = right;

        if (largest != i) {
            Character swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
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
        HeapSort.sort(selectedCharactersArray);

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