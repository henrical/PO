#include "square.h"
#include <cstdlib>

Square::Square(){};

int* Square::transform(int t[])
{
	int i=0;
	int n = sizeof(t);
	int *res = (int*) malloc(n*sizeof(int));

	for(i;i<n;i++)
	{
		res[i] *= res[i] ;	
	}
	
	return res;
}
