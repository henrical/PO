#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#include "animal.h"

struct animal{
	char _name_[15];
	int _age_;
	float _weight_;
};


Animal newAnimal(const char* name,int age, float weight)
{
	Animal newAnimal = (Animal) malloc(sizeof(Animal)); 	

	strcpy( newAnimal->_name_ , name); 
	newAnimal->_age_ = age;
	newAnimal->_weight_ = weight;

	printf("%s\n%d\n%f\n", newAnimal->_name_, newAnimal->_age_, newAnimal->_weight_);
	
	return newAnimal;
}

void destroyAnimal(Animal a)
{
	free(a);
}







