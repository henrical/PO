#include <iostream>
#include "table.h"
#include "square.h"
#include "sucessor.h"

int main ()
{
 	Table t(3);
	t.print(new Square);
	t.print(new Successor);
}
