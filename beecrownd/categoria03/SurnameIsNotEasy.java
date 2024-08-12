import java.util.Scanner;

/**
 * Surname is not Easy
 * 
 * link -> https://judge.beecrowd.com/en/problems/view/3358
 * 
 * Análise assintótica:
 * 
 * N -> tamanho do sobrenome
 * k -> numero de consoantes consecutivas
 * 
 * melhor caso -> O(1)
 * 
 * pior caso -> O((N-K) K) -> O(N-K^2)
 * 
 * @author Thomas Neuenschwander
 * @since 25/06/2024
 */
public class SurnameIsNotEasy {
    static final int consecutiveConsonants = 3;

    static boolean isVowel(char ch) {
        final char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
        for (char vowel : vowels) {
            if (ch == vowel)
                return true;
        }
        return false;
    }

    static boolean isSurnameEasy(String surname) {
        for (int i = 0; i < surname.length() - consecutiveConsonants; i++) {
            int count = 0;

            for (int j = i; j < i + consecutiveConsonants; j++) {
                if (!isVowel(surname.charAt(j)))
                    count++;
            }

            if (count == consecutiveConsonants)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String currentSurname = sc.nextLine();
            System.out.print(currentSurname + (isSurnameEasy(currentSurname) ? " eh facil" : " nao eh facil"));
        }
        sc.close();
    }

}
