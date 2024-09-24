import java.util.Scanner;

/**
* Aliteration
* 
* link -> https://judge.beecrowd.com/pt/problems/view/1263
* 
* @author Pedro Augusto Silva
* @since 12/08/2024
*/
public class Aliteracao {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String entrada = scanner.nextLine();
            String[] partes = entrada.split(" ");

            int quantidadeDeAliteracoes = 0;
            int i = 1;

            while (i < partes.length) {
                char parteAtual = Character.toLowerCase(partes[i].charAt(0));
                char parteAnterior = Character.toLowerCase(partes[i - 1].charAt(0));

                if (parteAtual == parteAnterior) {
                    quantidadeDeAliteracoes++;
                    // Pular todas as palavras que têm a mesma letra inicial
                    while (i < partes.length && Character.toLowerCase(partes[i].charAt(0)) == parteAtual) {
                        i++;
                    }
                } else {
                    i++;
                }
            }

            System.out.println(quantidadeDeAliteracoes);
        }

        scanner.close();
    }
}
