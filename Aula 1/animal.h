#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct animal *Animal;

Animal  newAnimal(const char* ,int, float );
void destroyAnimal(Animal);
