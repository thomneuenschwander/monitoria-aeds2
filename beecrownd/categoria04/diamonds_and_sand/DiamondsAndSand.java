package diamonds_and_sand;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Diamonds and Sand
 * 
 * Beecrownd 1069
 * link -> https://judge.beecrowd.com/en/problems/view/1069
 * 
 * @author Thomas Neuenschwander
 * @since 18/10/2024
 */
public class DiamondsAndSand {
    private static int countDiamonds(String input) {
        int count = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : input.toCharArray()) {
            if (ch == '<')
                stack.add(ch);
            else if (ch == '>' && !stack.isEmpty()) {
                count++;
                stack.pop();
            }
        }

        return count;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < N; i++) {
                String input = sc.nextLine();
                int diamondsAmount = countDiamonds(input);
                System.out.println(diamondsAmount);
            }
        }
    }

}
