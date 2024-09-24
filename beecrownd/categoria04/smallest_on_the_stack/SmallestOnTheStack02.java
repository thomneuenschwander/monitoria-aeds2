package smallest_on_the_stack;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

/** java Stack 
 * 
 * push O(1)
 * pop O(1)
 * min O(n)
 * 
 * Beecrownd 2929
 * link -> https://judge.beecrowd.com/en/problems/view/2929
 * 
 * @author Thomas Neuenschwander
 * @since 15/09/2024
*/
public class SmallestOnTheStack02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); sc.nextLine(); 
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0]; 

            switch (command) {
                case "PUSH" -> stack.push(Integer.parseInt(parts[1]));
                case "POP" -> stack.pop();
                case "MIN" -> System.out.println(stack.stream().min(Comparator.naturalOrder()).get());
                default -> throw new IllegalArgumentException("Invalid command: " + command);
            }
        }
        sc.close();
    }
}