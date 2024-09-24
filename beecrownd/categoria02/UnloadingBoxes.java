import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/** 
 * 
 * Beecrownd 1438
 * link -> https://judge.beecrowd.com/en/problems/view/1438
 * 
 * @author Thomas Neuenschwander
 * @since 15/09/2024
*/
public class UnloadingBoxes {
    static final int BOX_NUMBER = 1;

    static int minBoxesToUnload(List<Stack<Integer>> allBoxes) {
        int count = 0;
        while (!allBoxes.isEmpty()) {
            allBoxes.removeIf(Stack::isEmpty);

            if (allBoxes.stream().anyMatch(stack -> stack.peek() == BOX_NUMBER))
                return count;

            allBoxes.getFirst().pop();

            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                int N = sc.nextInt();
                int P = sc.nextInt();
                if (N == 0 && P == 0)
                    break;

                List<Stack<Integer>> allBoxes = new LinkedList<>();

                for (int i = 0; i < P; i++) {
                    Stack<Integer> boxes = new Stack<>();
                    int numOfBoxes = sc.nextInt();
                    for (int j = 0; j < numOfBoxes; j++)
                        boxes.add(sc.nextInt());
                    allBoxes.add(boxes);
                }
                int output = minBoxesToUnload(allBoxes);
                System.out.println(output);
            }
        }
    }
}