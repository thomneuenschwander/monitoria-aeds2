import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Even And Odd
 * 
 * Beecrownd 1259
 * link -> https://judge.beecrowd.com/en/problems/view/1259
 * 
 * @author Thomas Neuenschwander
 * @since 03/09/2024
 */
public class EvenAndOdd {
    static final Comparator<Integer> BY_EVEN_AND_ODD = Comparator
            .comparingInt((Integer num) -> num % 2)
            .thenComparingInt(num -> (num % 2 == 0) ? num : -num);

    static void mergeSort(int[] array) {
        if (array.length < 2)
            return;

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) 
            array[k++] = (BY_EVEN_AND_ODD.compare(left[i], right[j]) <= 0) ? left[i++] : right[j++];

        while (i < left.length) array[k++] = left[i++];
        while (j < right.length) array[k++] = right[j++];
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();

            int[] array = new int[N];

            for (int i = 0; i < N; i++) {
                int number = sc.nextInt();
                if (number < 0) throw new IllegalArgumentException("Must be a non-negative number");
                array[i] = number;
            }

            mergeSort(array);

            for (int number : array) 
                System.out.println(number);
        }
    }
}
