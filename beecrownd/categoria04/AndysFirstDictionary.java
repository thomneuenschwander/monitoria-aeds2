import java.util.Scanner;

/** BST Impl
 * 
 * Beecrownd 1215
 * link -> https://judge.beecrowd.com/en/problems/view/1215
 * 
 * @author André Luis
 * GitHub -> https://github.com/andreeluis
 * @since 15/09/2024
*/
public class AndysFirstDictionary {
  public static void main(String[] args) {
    Tree tree = new Tree();
    Scanner sc = new Scanner(System.in);

    while (sc.hasNext()) {
      String[] words = sc.next().toLowerCase().trim().replaceAll("[^a-z]", " ").replaceAll("\\s+", " ").strip()
          .split("\\s+");

      for (String word : words) {
        tree.insert(word);
      }
    }

    tree.print();

    sc.close();
  }
}

class Tree {
  Node root;
  int printN;

  class Node {
    String value;
    Node left;
    Node right;

    public Node(String value) {
      this.value = value;
      this.left = this.right = null;
    }
  }

  public Tree() {
    this.root = null;
    this.printN = 0;
  }

  public void insert(String value) {
    root = insert(value, root);
  }

  private Node insert(String value, Node node) {
    if (node == null)
      node = new Node(value);
    else if (value.compareTo(node.value) < 0)
      node.left = insert(value, node.left);
    else if (value.compareTo(node.value) > 0)
      node.right = insert(value, node.right);

    return node;
  }

  public void print() {
    print(root);
  }

  private void print(Node node) {
    if (node == null)
      return;

    print(node.left);
    if (printN <= 5000) {
      if (node.value.length() > 0)
        System.out.println(node.value);
      printN++;
      print(node.right);
    }
  }
}