#include <iostream>
#include <vector>
#include "../vector/Cat.h"

int main()
{
	std::vector<Cat> catVector;
	catVector.push_back(Cat("mittens",10, 13.4));
	catVector.push_back(Cat("pantufas",11, 14.5));
	catVector.push_back(Cat("fuckerton",12, 15.6));
	catVector.push_back(Cat("sir fuckington",13, 16.7));

	for(std::vector<Cat>::iterator it = catVector.begin(); it != catVector.end(); ++it)
	{
		it.printCat();
	}

	return 0;
}
