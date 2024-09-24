import java.util.Scanner;

/**
 * Hidden Message
 * 
 * link -> https://judge.beecrowd.com/pt/problems/view/1272
 * 
 * @author Pedro Augusto Silva Ferreira
 * @since 12/08/2024
 */

public class HiddenMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String frase = scanner.nextLine().trim();
            StringBuilder str = new StringBuilder();

            // Dividir a frase em palavras usando espaços como delimitadores
            String[] partes = frase.split("\\s+");

            for (String parteAtual : partes) {
                if (!parteAtual.isEmpty()) {
                    str.append(parteAtual.charAt(0));
                }
            }

            System.out.println(str.toString());
        }
        scanner.close();
    }
}
