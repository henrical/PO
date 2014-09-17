#include <stdio.h>
#include <string.h>
#include <stdlib.h>


typedef struct {
	char _name_[15];
	int _age_;
	float _weight_;
} Animal;


Animal * newAnimal(char name[15],int age, float weight)
{
	Animal *newAnimal = (Animal*) malloc(sizeof(Animal)); 	

	strcpy( newAnimal->_name_ , name); 
	newAnimal->_age_ = age;
	newAnimal->_weight_ = weight;

	/*printf("%s\n%d\n%f\n", newAnimal->_name_, newAnimal->_age_, newAnimal->_weight_);*/
	
	return newAnimal;
}

void destroyAnimal(Animal *animal)
{
	free(animal);
}


int main()
{
	
}

