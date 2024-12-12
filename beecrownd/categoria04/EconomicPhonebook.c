#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**
 * 
 * Beecrownd 1211
 * link -> https://judge.beecrowd.com/en/problems/view/1211
 * 
 * @author Thomas Neuenschwander
 * @since 23/09/2023
*/
void read(char** m, int lin){
    for(int i = 0; i < lin; i++){
        m[i] = malloc(6*sizeof(char));
        scanf("%s", m[i]);
    }
}
void show(char** m, int lin){
    for(int i = 0; i < lin; i++){
        printf("%s\n", m[i]);
    }
}

int charactersSaved(char** m, int lin){
    int res = 0;

    int col = strlen(m[0]); // strings have the same length

    for(int i = 1; i < lin; i++)
    {
        for(int j = 0; j < col; j++)
        {
            if(m[i][j] != m[i-1][j]){
                return res;
            }else{
                res++;
            }
        }
    }
    return res;
}

int main(){

    int N;
    scanf("%d", &N);

    char** phonebook = malloc(N*sizeof(char*));

    read(phonebook, N);

    printf("%d\n", charactersSaved(phonebook, N));

    return 0;
}