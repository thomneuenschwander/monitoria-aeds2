package smallest_on_the_stack;

import java.util.Scanner;
import java.util.Stack;

/** java Stack and MIN O(1)
 * 
 * push O(1)
 * pop O(1)
 * min O(1)
 * 
 * Beecrownd 2929
 * link -> https://judge.beecrowd.com/en/problems/view/2929
 * 
 * @author Thomas Neuenschwander
 * @since 18/09/2024
*/
public class SmallestOnTheStack03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); sc.nextLine(); 
        sc.nextLine();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0]; 

            switch (command) {
                case "PUSH" -> {
                    int v = Integer.parseInt(parts[1]);
                    stack.push(v);
                    if (minStack.isEmpty() || v <= minStack.peek())
                        minStack.push(v);
                }
                case "POP" -> {
                    int v = stack.pop();
                    if (v == minStack.peek())
                        minStack.pop();
                }
                case "MIN" -> System.out.println(minStack.peek());
                default -> throw new IllegalArgumentException("Invalid command: " + command);
            }
        }
        sc.close();
    }
}
