import java.util.Scanner;

/**
 * Combinador
 *
 * link -> https://judge.beecrowd.com/pt/problems/view/1238
 * @author Pedro Augusto Silva
 * @since 12/08/2024
 */
public class Combinador {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); 
        scanner.nextLine(); // Consome a nova linha após o número

        for (int i = 0; i < n; i++) {
            String frase = scanner.nextLine();
            String[] partes = frase.split(" ");

            String primeiraFrase = partes[0];
            String segundaFrase = partes[1];

            StringBuilder str = new StringBuilder();
            int maxLength = Math.max(primeiraFrase.length(), segundaFrase.length());

            for (int j = 0; j < maxLength; j++) {
                if (j < primeiraFrase.length()) {
                    str.append(primeiraFrase.charAt(j));
                }
                if (j < segundaFrase.length()) {
                    str.append(segundaFrase.charAt(j));
                }
            }

            System.out.println(str.toString());
        }

        scanner.close();
    }
}
