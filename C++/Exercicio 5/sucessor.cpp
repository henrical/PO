#include "sucessor.h"
#include <cstdlib>

Successor::Successor(){};

int* Successor::transform(int t[])
{
	int i=0;
	int n = sizeof(t);
	int *res = (int*) malloc(n*sizeof(int));

	for(i;i<n;i++)
	{
		res[i] += 1;	
	}
	
	return res;
}
