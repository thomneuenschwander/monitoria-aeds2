import java.util.Scanner;

/**
 * Atalhos Bloggo
 * 
 * link -> https://judge.beecrowd.com/pt/problems/view/1239
 * 
 * @author Pedro Augusto Silva Ferreira
 * @since 12/08/2024
 */

public class BloggoShortcuts {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String texto = scanner.nextLine();
            StringBuilder str = new StringBuilder();

            boolean abreFechaBold = true;
            boolean abreFechaItalic = true;

            for (int i = 0; i < texto.length(); i++) {
                char caractereAtual = texto.charAt(i);

                if (caractereAtual == '_') {
                    if (abreFechaItalic) {
                        str.append("<i>");
                    } else {
                        str.append("</i>");
                    }
                    abreFechaItalic = !abreFechaItalic;
                } else if (caractereAtual == '*') {
                    if (abreFechaBold) {
                        str.append("<b>");
                    } else {
                        str.append("</b>");
                    }
                    abreFechaBold = !abreFechaBold;
                } else {
                    str.append(caractereAtual);
                }
            }

            System.out.println(str.toString());
        }
        scanner.close();
    }
}
