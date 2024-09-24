import java.util.Scanner;

/**
 * ArrayHash
 * 
 * link -> https://judge.beecrowd.com/pt/problems/view/1257
 * 
 * @author Pedro Augusto Silva Ferreira
 * @since 12/08/2024
 */

public class ArrayHash {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();  // Número de casos de teste
        scanner.nextLine();  // Consumir a linha em branco após o número de casos

        for (int i = 0; i < N; i++) {
            int L = scanner.nextInt();  // Número de linhas no caso de teste atual
            scanner.nextLine();  // Consumir a linha em branco após o número de linhas
            String[] strings = new String[L];
            for (int j = 0; j < L; j++) {
                strings[j] = scanner.nextLine();
            }
            System.out.println(calcularHash(strings));
        }

        scanner.close();
    }

    public static int calcularHash(String[] strings) {
        int hashTotal = 0;
        for (int linha = 0; linha < strings.length; linha++) {
            for (int pos = 0; pos < strings[linha].length(); pos++) {
                char charAtual = strings[linha].charAt(pos);
                int valor = (charAtual - 'A') + linha + pos;
                hashTotal += valor;
            }
        }
        return hashTotal;
    }
}
