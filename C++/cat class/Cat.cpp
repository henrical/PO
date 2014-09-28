#include <iostream>
#include "Cat.h"
#include <sstream>

//============CLASS METHODS================
Cat::Cat(std::string name, int age, float weight)
{
	_name = name;
	_age = age;
	_weight = weight;
}

void Cat::setName(std::string name)
{
	_name = name;
}

std::string Cat::getName()
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

std::string Cat::printCat()
{
	std::string result;
	std::stringstream stm;
	
	stm << getName();
	stm << ", ";
	stm << getAge();
	stm << ", ";
	stm << getWeight();
	stm << std::endl;

	result = stm.str();

	return result;
}


//================MAIN=================

int main()
{
	Cat c("Fuckerton", 3, (float)13.5);
	std::cout << c.printCat();
	
	std::cout << "Success!" << std::endl;
}

