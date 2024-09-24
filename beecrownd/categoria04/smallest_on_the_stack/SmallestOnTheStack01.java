package smallest_on_the_stack;

import java.util.Scanner;

/** my Stack implementation
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
class Stack {
    Node top;

    class Node {
        int value;
        Node next;
        Node(int v) {
            this.value = v;
        }
    }

    int pop() {
        if (isEmpty()) 
            throw new IllegalStateException("Stack is empty");
        
        int v = top.value;
        Node temp = top;
        top = top.next;
        temp.next = null;
        return v;
    }

    void push(int v) {
        Node node = new Node(v);
        node.next = top;
        top = node;
    }

    int min() {
        if (isEmpty()) 
            throw new IllegalStateException("Stack is empty");
        
        int min = top.value;
        for(Node i = top.next; i != null; i = i.next) 
            if (i.value < min) min = i.value;
        
        return min;
    }

    boolean isEmpty() {
        return top == null;
    }
}

public class SmallestOnTheStack01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); sc.nextLine(); 
        Stack stack = new Stack();

        for (int i = 0; i < N; i++) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0]; 

            switch (command) {
                case "PUSH" -> stack.push(Integer.parseInt(parts[1]));
                case "POP" -> stack.pop();
                case "MIN" -> System.out.println(stack.min());
                default -> throw new IllegalArgumentException("Invalid command: " + command);
            }
        }
        sc.close();
    }
}
