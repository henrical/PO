#include <iostream>

#include "square.h"

Square::Square(){};

void Square::transform(int t[])
{
	int i=0;
	int n = sizeof(t) - 1;

	for(i;i<n;i++)
	{
		std::cout << (t[i] * t[i]) << std::endl;	
	}
}
