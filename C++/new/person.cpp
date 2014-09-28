#include <iostream>

#include "person.h"


Person::Person(std::string n, Birthday b)
:dateOfBirth(b)
{
	name = n;	
}

void Person::printInfo()
{
	std::cout << "Person Info\n Name: " << name << "\nDate of birth: " << dateOfBirth.getFormattedDate() << "." <<std::endl;

}
