#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define INPUT_BREAK "FIM"

bool isPalindrome(char *string) {
    if (string == NULL)
        return false;

    int i = 0, j = strlen(string) - 1;
    while (i < j) {
        if (string[i] != string[j])
            return false;
        i++;
        j--;
    }
    return true;
}

void processInput() {
    char input[100];

    while (true) {
        fgets(input, sizeof(input), stdin);

        input[strcspn(input, "\n")] = 0;

        if (strcmp(input, INPUT_BREAK) == 0)
            break;

        if (isPalindrome(input))
            printf("SIM\n");
        else
            printf("NAO\n");
    }
}

int main() {
    processInput();
    return 0;
}
