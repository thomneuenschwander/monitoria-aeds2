#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**
 * Parenthesis Balance I
 *
 *  link -> https://judge.beecrowd.com/en/problems/view/1068
 * 
 */

int isCorrect(char *str, int size)
{
    int open = 0, close = 0;

    for (int i = 0; i < size; i++)
    {
        if (str[i] == '(')
            open++;
        else if (str[i] == ')') {
            close++;
            if (close > open)
                return 0;
        }
    }
    if (open != close)
        return 0;
    
    return 1;
}

int main()
{
    char expression[1001];
    while (fgets(expression, sizeof(expression), stdin) != NULL)
    {
        int size = strlen(expression);

        char *output = isCorrect(expression, size) ? "correct" : "incorrect";
        printf("%s\n", output);
    }
    return 0;
}