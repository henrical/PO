#ifndef CAT_REGISTRY_H
#define CAT_REGISTRY_H

#include <iostream>
#include <vector>

#include "Cat.h"

class CatRegistry
{
	public:
		std::vector<Cat> cats;
		
		explicit CatRegistry();

		void printCats();

};

#endif
