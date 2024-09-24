package tp01.ex03;

import java.util.Scanner;
import java.util.function.Consumer;

public class CesarCipher {
    static final String inputBreak = "FIM";
    static final int CESAR_CIPHER_OFFSET = 3;

    static String encode(String string) {
        if (string == null)
            return null;

        var sb = new StringBuilder();
  
        for (char ch : string.toCharArray())
            sb.append((char) ((ch + CESAR_CIPHER_OFFSET) % 26));

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        processInput(sc, string -> {
            String encoded = encode(string);
            System.out.println(encoded);
        });

        sc.close();
    }

    static void processInput(Scanner sc, Consumer<String> inputOperation) {
        String input;
        while (!(input = sc.nextLine()).equals(inputBreak))
            inputOperation.accept(input);
    }
}
