package tp01.ex01;

import java.util.Scanner;
import java.util.function.Consumer;

public class PalindromeCheker {
    static final String inputBreak = "FIM";
    
    static boolean isPalindrome(String string) {
        if(string == null)
            return false;

        for(int i = 0, j = string.length() - 1; i < j; i++, j--) {
            if(string.charAt(i) != string.charAt(j))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        processInput(sc, string -> {
            String output = isPalindrome(string) ? "SIM" : "NAO";
            System.out.println(output);
        });
            
        sc.close();
    }

    static void processInput(Scanner sc, Consumer<String> inputOperation) {
        String input;
        while (!(input = sc.nextLine()).equals(inputBreak))
            inputOperation.accept(input);
    }
}