#include <iostream>
#include "Cat.h"
#include "CatRegistry.h"

#include <cstdlib>

int main()
{
	/*
	Cat c[2] = {Cat("",0,0), Cat("",0,0)};
	//c = (Cat*) malloc(5*sizeof(Cat));

	c[0] = Cat("mittens", 12, 9.6);

	std::cout << "--> " << c[0].printCat();
*/
	CatRegistry cr;

	cr.printCats();

}
