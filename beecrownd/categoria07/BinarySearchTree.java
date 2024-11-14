import java.util.Scanner;

public class BinarySearchTree {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static enum TraversalOrder {
        PRE_ORDER("Pre."),
        IN_ORDER("In.."),
        POST_ORDER("Post");

        private final String label;

        TraversalOrder(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
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

    void traverse(TraversalOrder order) {
        System.out.print(order.getLabel() + ":");
        switch (order) {
            case PRE_ORDER -> {preOrder(root);}
            case IN_ORDER -> {inOrder(root);}
            case POST_ORDER -> postOrder(root);
        }
        System.out.println();
    }

    void preOrder(Node node) {
        if (node == null) return;
        System.out.print(" " + node.val);
        preOrder(node.left);
        preOrder(node.right);
    }

    void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left); 
        System.out.print(" " + node.val);
        inOrder(node.right); 
    }

    void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left); 
        postOrder(node.right);
        System.out.print(" " + node.val);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int C = sc.nextInt();
            for (int testCase = 1; testCase <= C; testCase++) {
                int N = sc.nextInt();

                BinarySearchTree bst = new BinarySearchTree();
                while(N-- > 0) bst.add(sc.nextInt());

                System.out.println("Case " + testCase + ":");
                bst.traverse(TraversalOrder.PRE_ORDER);
                bst.traverse(TraversalOrder.IN_ORDER);
                bst.traverse(TraversalOrder.POST_ORDER);
            }
        }
    }
}
