#include "table.h"
#include <cstdlib>
#include <cstring>

Table::Table(int n)
{ 
	table = (int*) malloc(n*sizeof(int));

	memset(table, 0, n);
}

void Table::print(Transform *t) const
{
	t->transform(table);
}
