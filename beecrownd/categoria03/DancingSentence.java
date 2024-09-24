import java.util.Scanner;

/**
 * Dancing Sentence
 * 
 * link -> https://judge.beecrowd.com/pt/problems/view/1234
 * 
 * 
 * @author Pedro Augusto Silva Ferreira
 * @since 12/08/2024
 */
public class DancingSentence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String frase = scanner.nextLine();

            boolean maiuscula = true;
            StringBuilder str = new StringBuilder();

            for (int i = 0; i < frase.length(); i++) {
                char caractereAtual = frase.charAt(i);

                if (Character.isLetter(caractereAtual)) {
                    if (maiuscula) {
                        char caractereMaiusculo = Character.toUpperCase(caractereAtual);
                        str.append(caractereMaiusculo);
                    } else {
                        char caractereMinusculo = Character.toLowerCase(caractereAtual);
                        str.append(caractereMinusculo);
                    }

                    maiuscula = !maiuscula;
                } else {
                    str.append(caractereAtual);
                }
            }

            System.out.println(str.toString());
        }
        
        scanner.close();
    }
}
