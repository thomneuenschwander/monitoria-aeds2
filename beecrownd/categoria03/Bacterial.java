import java.util.Scanner;

public class Bacterial {

/**
 * Bacteria I
 * 
 * link -> https://judge.beecrowd.com/en/problems/view/2356
 * @author Pedro Augusto Silva Ferreira
 * @since  12/08/2024
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
          
            String dna = scanner.nextLine().trim();
     
            String resistencia = scanner.nextLine().trim();
            if (dna.contains(resistencia)) {
                System.out.println("Resistente");
            } else {
                System.out.println("Nao resistente");
            }
        }

        scanner.close();
    }
}
