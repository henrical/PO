#include "CatRegistry.h"

CatRegistry::CatRegistry()
{
	cats.push_back(Cat("cat 1", 1, 1));
	cats.push_back(Cat("cat 2", 2, 2));
	cats.push_back(Cat("cat 3", 3, 3));
}

void CatRegistry::printCats()
{
	int i = 0;

	for(i; i < cats.size(); i++)
	{
		std::cout << "-> " << cats[i].printCat() ;
	}
}
