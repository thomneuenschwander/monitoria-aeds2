package hash_tables;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/** HashTable Map<K, V> implementation
 * 
 * Beecrownd 1256
 * link -> https://judge.beecrowd.com/en/problems/view/1256
 * 
 * @author Thomas Neuenschwander
 * @since 25/06/2024
*/
public class HashTables02 {
    static Map<Integer, List<Integer>> generateHashTable(int size) {
        Map<Integer, List<Integer>> hashTable = new TreeMap<>();
        for (int i = 0; i < size; i++)
            hashTable.put(i, new LinkedList<>());
        return hashTable;
    }

    static void printHashTable(Map<Integer, List<Integer>> hashTable) {
        for (Map.Entry<Integer, List<Integer>> entry : hashTable.entrySet()) {
            int index = entry.getKey();
            List<Integer> bucket = entry.getValue();
            System.out.print(index + " -> ");
            bucket.forEach(element -> System.out.print(element + " -> "));
            System.out.println("\\");
        }
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int M = sc.nextInt();
            int C = sc.nextInt();
            Map<Integer, List<Integer>> hashTable = generateHashTable(M);
            for (int j = 0; j < C; j++) {
                int num = sc.nextInt();
                int hashVal = num % M;
                List<Integer> bucket = hashTable.get(hashVal);
                bucket.add(num);
            }
            printHashTable(hashTable);
        }
        sc.close();
    }
}
