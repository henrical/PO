#include "table.h"
#include <cstdlib>

Table::Table(int n)
{ 
	table = (int*) malloc(n*sizeof(int));
}

void Table::print(Transform t)
{
	t.transform(table);
}
