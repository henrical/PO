#include <iostream>
#include <sstream>

#include "child.h"

Child::Child(int a, std::string n, Birthday b)
:dateOfBirth(b)
{
	age = a;
	name = n;	
}

void Child::setName(std::string n)
{
	name = n;
}

std::string Child::printChild()
{
	std::stringstream stream;
	std::string result;
	

	stream << "Age = ";
	stream << age;
	stream << "\nName = ";
	stream << name;
	stream << "\nDate = ";
	stream << dateOfBirth.getFormattedDate();
	stream << std::endl;

	result = stream.str();

	return result;
}
