#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/** 
 * 
 * Beecrownd 1167
 * link -> https://judge.beecrowd.com/en/problems/view/1167
 * 
 * @author Thomas Neuenschwander
 * @since 11/12/2024
*/

typedef struct Children{
    char* name;
    int card;
    int prev, next;
} Children;

Children* createCircle(int numChildrens)
{
    int N = numChildrens;
    Children* circle = malloc(N * sizeof(Children));
    for(int i = 0; i < N; i++)
    {
        int card;
        char name[31];
        scanf("%s %d", name, &card);
        circle[i].name = malloc(31*sizeof(char));
        strcpy(circle[i].name, name);
        circle[i].card = card;
        circle[i].prev = ((i - 1) % N + N) % N;
        circle[i].next = (i + 1) % N;
    }
    return circle;
}

int main(){

    int N;
    scanf("%d", &N);

    Children* circle = createCircle(N);

    int i = 0;
    for(int c = 0; c < N-1; c++)
    {
        int card = circle[i].card;

        if(card % 2 == 0)
            for(int j = 0 ; j < card; j++) i = circle[i].next;
        else
            for(int j = 0 ; j < card; j++) i = circle[i].prev;
            
        circle[circle[i].next].prev = circle[i].prev;
        circle[circle[i].prev].next = circle[i].next;
    }
    i = circle[i].next;
    printf("Vencerdor (a) %s\n", circle[i].name);
    return 0;
}