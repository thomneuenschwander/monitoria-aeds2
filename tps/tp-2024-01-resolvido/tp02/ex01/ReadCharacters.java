package tp02.ex01;

import tp02.Character;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * @author Thomas Neuenschwander
 * @since 2024-10-10
 * @see https://github.com/thomneuenschwander
 */
public class ReadCharacters {
    static final String PATH = "../characters.csv";
    static final String INPUT_BREAK = "FIM";
    static final Map<String, Character> ALL_CHARACTERS = Character.readFromCSV(PATH);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        processInput(sc, id -> {
            var character = ALL_CHARACTERS.get(id);
            if(character != null)
                System.out.println(character);
        });

        sc.close();
    }

    static void processInput(Scanner sc, Consumer<String> inputOperation) {
        String input;
        while (!(input = sc.nextLine()).equals(INPUT_BREAK))
            inputOperation.accept(input);
    }
}
