package tp02.ex01;

import tp02.Character;
import java.util.Scanner;
import java.util.function.Consumer;

public class ReadCharacters {
    static final String path = "TP04/characters.csv";
    static final String inputBreak = "FIM";

    public static void main(String[] args) {
        var allCharacters = Character.readFromCSV(path);

        Scanner sc = new Scanner(System.in);
        
        processInput(sc, id -> {
            var character = allCharacters.stream().filter(c -> c.getId().equals(id)).findFirst();
            character.ifPresent(System.out::println);
        });

        sc.close();
    }

    static void processInput(Scanner sc, Consumer<String> inputOperation) {
        String input;
        while (!(input = sc.nextLine()).equals(inputBreak))
            inputOperation.accept(input);
    }
}
