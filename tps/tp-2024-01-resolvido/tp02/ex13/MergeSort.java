package tp02.ex13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import tp02.Character;

public class MergeSort {
    static final String PATH = "../characters.csv";
    static final String INPUT_BREAK = "FIM";

    static final Comparator<Character> BY_ACTOR_NAME = Comparator.comparing(Character::getActorName);

    static void sort(Character[] array) {
        if (array.length < 2)
            return;

        int mid = array.length / 2;
        Character[] left = Arrays.copyOfRange(array, 0, mid);
        Character[] right = Arrays.copyOfRange(array, mid, array.length);

        sort(left);
        sort(right);

        merge(array, left, right);
    }

    static void merge(Character[] array, Character[] left, Character[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length)
            array[k++] = (BY_ACTOR_NAME.compare(left[i], right[j]) <= 0) ? left[i++] : right[j++];

        while (i < left.length)
            array[k++] = left[i++];
        while (j < right.length)
            array[k++] = right[j++];
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
        MergeSort.sort(selectedCharactersArray);

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
