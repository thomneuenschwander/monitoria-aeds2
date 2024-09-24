import java.util.Scanner;

/** Sort! Sort!! And Sort!!!
 * 
 * Beecrownd 1252
 * link -> https://judge.beecrowd.com/en/problems/view/1252
 * 
 * @author Thomas Neuenschwander
 * @since 03/09/2024
*/
public class SortSortAndSort {
    static <T extends Comparable<T>> void selectionSort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[index]) < 0)
                    index = j;
            }

            swap(i, index, array);
        }

    }

    static <T extends Comparable<T>> void swap(int i, int j, T[] array) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        int M;

        do {
            N = sc.nextInt();
            M = sc.nextInt();

            Entry[] entries = new Entry[N];

            for (int i = 0; i < N; i++)
                entries[i] = new Entry(sc.nextInt(), M);

            selectionSort(entries);

            printOutput(entries, N, M);

        } while (N != 0 && M != 0);

        sc.close();
    }

    static void printOutput(Entry[] entries, int N, int M) {
        System.out.print(N + " ");
        System.out.println(M);
        for (Entry entry : entries)
            System.out.println(entry.number);
    }

}

class Entry implements Comparable<Entry> {
    int number;
    int mod;

    public Entry(int number, int modOp) {
        this.number = number;
        this.mod = number % modOp;
    }

    @Override
    public int compareTo(Entry other) {
        if (this.mod != other.mod) 
            return Integer.compare(this.mod, other.mod);
        
        if ((this.number % 2) != (other.number % 2)) 
            return Integer.compare(other.number % 2, this.number % 2);
        
        return (this.number % 2 == 0) ? Integer.compare(this.number, other.number)
                : Integer.compare(other.number, this.number);
    }

}