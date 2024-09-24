import java.util.Scanner;

/** 
 * 
 * Beecrownd 2479
 * link -> https://judge.beecrowd.com/en/problems/view/2479
 * 
 * @author Thomas Neuenschwander
 * @since 17/09/2024
*/
public class SortingSantasListOfChildren {
    static<T extends Comparable<T>> void insertionSort(T[] array) {
        for(int i = 1; i < array.length; i++) {
            T temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(temp) > 0) 
                array[j + 1] = array[j--];
            array[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); sc.nextLine();

        String[] childrens = new String[N];
        int wellBehaveCount = 0;

        for(int i = 0; i < N; i++) {
            String input = sc.nextLine();
            char operation = input.charAt(0);
            String children = input.substring(2).trim();

            if(operation == '+') wellBehaveCount++;
            childrens[i] = children;
        }

        insertionSort(childrens);

        for (String children : childrens) 
            System.out.println(children);
        System.out.println("Se comportaram: "+ wellBehaveCount + " | Nao se comportaram: " + (N - wellBehaveCount));        

        sc.close();
    }
}
