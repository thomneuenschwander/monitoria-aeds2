#include <stdio.h>

/** 
 * Diamonds and Sand
 * 
 * Beecrownd 1069
 * link -> https://judge.beecrowd.com/en/problems/view/1069
 * 
 * @author Thomas Neuenschwander
 * @since 18/10/2024
*/
int count_diamonds(const char* input) {
    int count = 0;
    int openDiamonds = 0;
    
    for (int i = 0; input[i] != '\0'; i++) {
        if (input[i] == '<') 
            openDiamonds++;
        else if (input[i] == '>' && openDiamonds > 0) {
            count++;
            openDiamonds--;
        }
    }
    
    return count;
}

int main() {
    int N;
    scanf("%d", &N);
    getchar();  // Consume newline
    
    while (N--)
    {
        char input[1001];
        fgets(input, sizeof(input), stdin);
        
        int diamondsAmount = count_diamonds(input);
        printf("%d\n", diamondsAmount);
    }
    
    return 0;
}
