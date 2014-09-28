#include <iostream>
#include "Cat.h"
#include <sstream>

//============CLASS METHODS================
Cat::Cat(string name, int age, float weight)
{
	_name = name;
	_age = age;
	_weight = weight;
}

void Cat::setName(string name)
{
	_name = name;
}

string Cat::getName()
{
	return _name;
}

int Cat::getAge()
{
	return _age;
}

float Cat::getWeight()
{
	return _weight;
}

string Cat::printCat()
{
	string result;
	stringstream stm;
	stringstream stm2;

	cout << getName() <<endl;



	stm << getAge();
	result = stm.str(); 
		
	cout << result <<endl;



	stm2 << getWeight();
	result = stm2.str();

	cout << result <<endl;
}


//================MAIN=================

int main()
{
	Cat c("Fuckerton", 3, (float)13.5);
	c.printCat();
	
	cout << "Success!"<<endl;
}

