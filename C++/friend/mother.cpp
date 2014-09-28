#include <iostream>

#include "mother.h"

Mother::Mother( int a, std::string n)
{
	name = n;
	age = a;
}

void Mother::setChildName(Child &c, std::string n)
{
	c.setName(n);
}
