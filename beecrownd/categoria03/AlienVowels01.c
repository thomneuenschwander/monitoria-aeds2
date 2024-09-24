#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/** O(n * m) - n is the size of the phrase and m is the number of vowels
 *
 * Beecrownd 2150
 * link -> https://judge.beecrowd.com/en/problems/view/2150
 *
 * @author Thomas Neuenschwander
 * @since 17/09/2024
*/

int count_alien_vowels(char* vowels, char* phrase) {
    int count = 0;
    for(int i = 0; phrase[i] != '\0'; i++)
    {
        for(int j = 0; vowels[j] != '\0'; j++)
        {
            if(phrase[i] == vowels[j])
                count++;
        }
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