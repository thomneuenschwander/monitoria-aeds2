#include <stdio.h>
#include <stdlib.h>

/** 
 * 
 * Beecrownd 1251
 * link -> https://judge.beecrowd.com/en/problems/view/1251
 * 
 * @author Thomas Neuenschwander
 * @since 16/09/2024
*/

#define ASCII_SIZE 256

typedef struct {
    int key;
    int value;
} Frequency;

void bubbleSort(Frequency arr[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j].value > arr[j + 1].value || 
               (arr[j].value == arr[j + 1].value && arr[j].key > arr[j + 1].key)) {
                Frequency temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

int main() {
    char input[1001]; // Buffer para entrada
    int frequencies[ASCII_SIZE] = {0}; // Array para contar as frequências (ASCII_SIZE = 256)
    Frequency frequencyArray[ASCII_SIZE]; // Array de estruturas para armazenar os resultados
    int uniqueChars = 0; // Contador de caracteres únicos

    while (scanf("%s", input) != EOF) {
        // Reset das frequências e contagem de caracteres únicos
        for (int i = 0; i < ASCII_SIZE; i++) 
            frequencies[i] = 0;
        
        uniqueChars = 0;

        // Conta a frequência de cada caractere
        for (int i = 0; input[i] != '\0'; i++) {
            int asciiValue = (int)input[i];
            if (frequencies[asciiValue] == 0) 
                uniqueChars++;
            
            frequencies[asciiValue]++;
        }

        // Preenche o array de frequências para ordenação
        int index = 0;
        for (int i = 0; i < ASCII_SIZE; i++) {
            if (frequencies[i] > 0) {
                frequencyArray[index].key = i;
                frequencyArray[index].value = frequencies[i];
                index++;
            }
        }

        bubbleSort(frequencyArray, uniqueChars);

        for (int i = 0; i < uniqueChars; i++) 
            printf("%d %d\n", frequencyArray[i].key, frequencyArray[i].value);
        
        printf("\n"); 
    }

    return 0;
}
