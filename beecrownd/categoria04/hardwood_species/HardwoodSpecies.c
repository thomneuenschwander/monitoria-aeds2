#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_SPECIES_NAME 31
#define MAX_SPECIES 10000

/**
 * Hardwood Species
 * 
 * Beecrownd 1260
 * link -> https://judge.beecrowd.com/en/problems/view/1260
 * 
 * @author Thomas Neuenschwander
 * @since 18/10/2024
 */
typedef struct {
    char name[MAX_SPECIES_NAME];
    int count;
} Species;

void swap(Species *a, Species *b) {
    Species temp = *a;
    *a = *b;
    *b = temp;
}

void quickSort(Species arr[], int left, int right) {
    if (left >= right)
        return;

    int pivotIndex = left + (right - left) / 2;
    Species pivot = arr[pivotIndex];
    int i = left;
    int j = right;

    while (i <= j)
    {
        while (strcmp(arr[i].name, pivot.name) < 0) i++;

        while (strcmp(arr[j].name, pivot.name) > 0) j--;

        if (i <= j) {
            swap(&arr[i], &arr[j]);
            i++;
            j--;
        }
    }

    if (left < j)
        quickSort(arr, left, j);
    if (i < right)
        quickSort(arr, i, right);
}

int main() {
    int testCases;
    char buffer[MAX_SPECIES_NAME];
    fgets(buffer, sizeof(buffer), stdin);
    sscanf(buffer, "%d", &testCases);

    fgets(buffer, sizeof(buffer), stdin);

    while (testCases--) {
        Species speciesList[MAX_SPECIES];
        int speciesCount = 0;
        int totalTrees = 0;

        for (int i = 0; i < MAX_SPECIES; i++) {
            speciesList[i].count = 0;
            speciesList[i].name[0] = '\0';
        }

        while (fgets(buffer, sizeof(buffer), stdin)) {
            buffer[strcspn(buffer, "\n")] = '\0';

            if (strlen(buffer) == 0)
                break;

            int found = 0;
            for (int i = 0; i < speciesCount; i++) {
                if (strcmp(speciesList[i].name, buffer) == 0) {
                    speciesList[i].count++;
                    found = 1;
                    break;
                }
            }

            if (!found) {
                strcpy(speciesList[speciesCount].name, buffer);
                speciesList[speciesCount].count = 1;
                speciesCount++;
            }

            totalTrees++;
        }

        quickSort(speciesList, 0, speciesCount - 1);

        for (int i = 0; i < speciesCount; i++) {
            double percentage = (speciesList[i].count * 100.0) / totalTrees;
            printf("%s %.4lf\n", speciesList[i].name, percentage);
        }

        if (testCases > 0)
            printf("\n");
    }

    return 0;
}
