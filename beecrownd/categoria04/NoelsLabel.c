#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**
 * Noel's Labels
 *
 *  link -> https://judge.beecrowd.com/en/problems/view/2482
 *
 *
 *  Análise assintótica:
 *
 *     O(N) -> Para percorres as traduções / mapear
 *
 *     Total -> O(N)
 */

typedef struct TranslationMapper
{
    char *language;
    char *greeting;
} Mapper;

char *mapCountryToGreeting(Mapper *translations, int N, char *country)
{
    for (int i = 0; i < N; i++)
    {
        if (strcmp(country, translations[i].language) == 0)
            return translations[i].greeting;
    }
    return NULL;
}

void read_translations(Mapper *translations, int N);

void free_translations(Mapper *translations, int N);

int main()
{
    int N;
    scanf("%d", &N);

    Mapper translations[N];
    read_translations(translations, N);

    int M;
    scanf("%d", &M);

    while (M--)
    {
        char name[31];
        char country[31];

        scanf(" %[^\n]", name);
        scanf("%s", country);

        char *greeting = mapCountryToGreeting(translations, N, country);

        printf("%s\n", name);
        printf("%s\n", greeting);
    }
    free_translations(translations, N);
    return 0;
}

void read_translations(Mapper *translations, int N)
{
    for (int i = 0; i < N; i++)
    {
        char language[31], greeting[31];
        scanf("%s", language);
        scanf(" %[^\n]", greeting);

        translations[i].language = malloc(31 * sizeof(char));
        strcpy(translations[i].language, language);

        translations[i].greeting = malloc(31 * sizeof(char));
        strcpy(translations[i].greeting, greeting);
    }
}

void free_translations(Mapper *translations, int N)
{
    for (int i = 0; i < N; i++)
    {
        free(translations[i].language);
        free(translations[i].greeting);
    }
}