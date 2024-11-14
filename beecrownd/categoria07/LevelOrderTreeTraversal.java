import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderTreeTraversal {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    Node root;

    void add(int val) {
        root = add(root, val);
    }

    Node add(Node node, int val) {
        if (node == null)
            node = new Node(val);
        else if (node.val > val)
            node.left = add(node.left, val);
        else
            node.right = add(node.right, val);
        return node;
    }

    void BFS() {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        var result = new StringBuilder();
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            result.append(node.val).append(" ");

            if (node.left != null)
                queue.add(node.left);
            if (queue.add(node.right))
                queue.add(node.right);
        }

        if (result.length() > 0)
            result.setLength(result.length() - 1);
        System.out.println(result);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int C = sc.nextInt();
            for (int testCase = 1; testCase <= C; testCase++) {
                int N = sc.nextInt();

                LevelOrderTreeTraversal bst = new LevelOrderTreeTraversal();
                while (N-- > 0)
                    bst.add(sc.nextInt());

                System.out.println("Case " + testCase + ":");
                bst.BFS();
            }
        }
    }

}