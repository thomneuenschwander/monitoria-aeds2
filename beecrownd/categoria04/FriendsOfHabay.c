#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/** 
 * 
 * Beecrownd 1236
 * link -> https://judge.beecrowd.com/en/problems/view/1236
 * 
 * @author Thomas Neuenschwander
 * @since 23/09/2023
*/
typedef struct Friends{
    char* name;
    char chose;
}Friends;

int biggestNameSize(Friends* arr, int size){
    int biggest = 0;
    for(int i = 0; i < size; i++){
        int s = strlen(arr[i].name);
        if(s > biggest && arr[i].chose){
            biggest = strlen(arr[i].name);
        }
    }
    return biggest;
}

char* habayFriend(Friends* arr, int size){
    int biggest = biggestNameSize(arr, size);

    for(int i = 0; i < size; i++){
        int s = strlen(arr[i].name);
        if(s == biggest && arr[i].chose){
            return arr[i].name;
        }
    }
    return NULL;
}
void sort(Friends* arr, int size){
    for(int i = 0; i < size; i++){
        for(int j = (i+1); j < size; j++){
            if(arr[i].chose == 0 && arr[j].chose == 1){
                Friends tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            else if(arr[i].chose == arr[j].chose && strcmp(arr[i].name, arr[j].name) > 0){
                Friends tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
    }
}
Friends* exclusivesArr(Friends* friends, int size, int* newSize){
    Friends* arr = malloc(20*sizeof(Friends));
    int index = 0;

    for(int i = 0; i < size; i++){
        int added = 0;

        for(int j = 0; j < index; j++){
            if(strcmp(friends[i].name, arr[j].name) == 0){
                added = 1;
                break;
            }
        }

        if(!added){
            arr[index++] = friends[i];
        }
    }
    *newSize = index;
    arr = realloc(arr, index*sizeof(Friends));
    return arr;
}

int main(){
    Friends* friends = malloc(20*sizeof(Friends));
    int index = 0;

    char line[101];
    scanf(" %[^\n]", line);
    while(strcmp(line, "FIM") != 0)
    {
        friends[index].name = malloc(31*sizeof(char));

        int i = 0;
        while(line[i] != ' '){
            friends[index].name[i] = line[i];
            i++;
        }
        friends[index].name[i] = '\0';
        
        if(line[i+1] == 'N'){
            friends[index].chose = 0;
        }else{
            friends[index].chose = 1;
        }
        
        index++;
        scanf(" %[^\n]", line);
    }
    int newSize = 0;
    Friends* excl = exclusivesArr(friends, index, &newSize);
    

    sort(excl, newSize);

    printf("\n");
    for(int i = 0; i < newSize; i++){
        printf("%s\n", excl[i].name);
    }
    printf("\n\n");
    printf("Amigo do Habay:\n");
    printf("%s\n", habayFriend(friends, index));
    return 0;
}