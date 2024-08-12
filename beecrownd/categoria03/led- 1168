import java.util.Scanner;

public class leds{

    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha após o número inteiro

        for (int i = 0; i < n; i++) {
            String entrada = scanner.nextLine();
            int leds = 0;
            for (int j = 0; j < entrada.length(); j++) {
                char digito = entrada.charAt(j);

                if (digito == '0') {
                    leds += 6;
                } else if (digito == '1') {
                    leds += 2;
                } else if (digito == '2') {
                    leds += 5;
                } else if (digito == '3') {
                    leds += 5;
                } else if (digito == '4') {
                    leds += 4;
                } else if (digito == '5') {
                    leds += 5;
                } else if (digito == '6') {
                    leds += 6;
                } else if (digito == '7') {
                    leds += 3;
                } else if (digito == '8') {
                    leds += 7;
                } else if (digito == '9') {
                    leds += 6;
                }
            }
            System.out.println(leds);
        }
    }
}
