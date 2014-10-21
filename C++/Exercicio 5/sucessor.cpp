#include <iostream>
#include "sucessor.h"

Successor::Successor(){};

void Successor::transform(int t[])
{
	int i=0;
	int n = sizeof(t) - 1;

	for(i;i<n;i++)
	{
		std::cout << t[i] + 1 << std::endl;	
	}
	
}
