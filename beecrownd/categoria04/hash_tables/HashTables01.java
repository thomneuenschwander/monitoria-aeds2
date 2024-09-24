package hash_tables;
import java.util.Scanner;

/** HashTable raw implementation
 * 
 * Beecrownd 1256
 * link -> https://judge.beecrowd.com/en/problems/view/1256
 * 
 * @author Thomas Neuenschwander
 * @since 25/06/2024
*/
class HashTable {
    final int size;
    final Node[] table;
    
    class Node {
        int val;
        Node next;
    
        Node() {
            this(-1);
        }
    
        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public HashTable(int size) {
        this.size = size;
        table = new Node[size];
        for (int i = 0; i < size; i++)
            table[i] = new Node();
    }

    private int hash(int num) {
        return num % size;
    }

    public void add(int num) {
        int index = hash(num);
        Node node = table[index];
        Node i = node;
        while (i.next != null)
            i = i.next;
        i.next = new Node(num);
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        int i = 0;
        for (Node bucket : table) {
            sb.append(Integer.toString(i++));
            bucketToString(bucket, sb);
            sb.append(" -> \\");
            sb.append("\n");
        }
        return sb.toString();
    }

    private void bucketToString(Node bucket, StringBuilder sb) {
        while (bucket != null) {
            sb.append(" -> " + bucket.val);
            bucket = bucket.next;
        }
    }
}

public class HashTables01 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int M = sc.nextInt();
            int C = sc.nextInt();
            HashTable hashTable = new HashTable(M);
            for (int j = 0; j < C; j++)
                hashTable.add(sc.nextInt());
            System.out.println(hashTable);
        }
        sc.close();
    }
}
