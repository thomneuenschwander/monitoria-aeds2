#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/** Impl using hashing
 * 
 * O(n) - n is the size of the phrase
 *
 * Beecrownd 2150
 * link -> https://judge.beecrowd.com/en/problems/view/2150
 *
 * @author Thomas Neuenschwander
 * @since 17/09/2024
*/

typedef int boolean;
#define TRUE 1
#define FALSE 0

int count_alien_vowels(char* vowels, char* phrase) {
    int count = 0;
    boolean present[256] = {FALSE};
    
    for (int i = 0; vowels[i] != '\0'; i++) 
        present[(unsigned char)vowels[i]] = TRUE;
    
    for (int i = 0; phrase[i] != '\0'; i++) {
        if (present[(unsigned char)phrase[i]]) 
            count++;
    }
    return count;
}

int main() {
    char vowels[31];
    char phrase[51];

    while (scanf("%s", vowels) != EOF) {
        scanf(" %[^\n]", phrase);
        printf("%d\n", count_alien_vowels(vowels, phrase));
    }


    return 0;
}