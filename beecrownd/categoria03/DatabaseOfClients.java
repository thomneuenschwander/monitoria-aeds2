import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Database of Clients
 * 
 * link -> https://judge.beecrowd.com/en/problems/view/2906
 * @author Pedro Augusto Silva Ferreira
 * @since 12/08/2024
 */
public class DatabaseOfClients {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        List<String> uniqueEmails = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String email = scanner.nextLine();
            String processedEmail = processEmail(email);

            if (!uniqueEmails.contains(processedEmail)) {
                uniqueEmails.add(processedEmail);
            }
        }

        System.out.println(uniqueEmails.size());
        scanner.close();
    }

    private static String processEmail(String email) {
        String[] parts = email.split("@");
        String localpart = parts[0];
        String provider = parts[1];

        localpart = localpart.replace(".", "");
        if (localpart.contains("+")) {
            localpart = localpart.substring(0, localpart.indexOf("+"));
        }

        return localpart + "@" + provider;
    }
}
