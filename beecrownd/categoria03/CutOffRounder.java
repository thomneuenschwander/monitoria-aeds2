import java.util.Scanner;

/**
 * Arredondamento por valor de corte
 * 
 * @author Pedro Augusto Silva Ferreira
 * @since 12/08/2024
*/
public class CutOffRounder {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String entrada = scanner.nextLine();
            String corte = scanner.nextLine();

            double entradaDouble = Double.parseDouble(entrada);
            double corteDouble = Double.parseDouble(corte);

            int entradaInt = (int) entradaDouble;

            double parteFracionaria = entradaDouble - entradaInt;

            if (parteFracionaria > corteDouble) {

                entradaDouble += 1;
            } 

            System.out.println((int) entradaDouble);

        }
        scanner.close();
    }
}
