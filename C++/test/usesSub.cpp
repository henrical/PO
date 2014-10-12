#include "usesSub.h"


usesSub::usesSub(sub x, super y)
:_x(x), _y(y)
{
}

void usesSub::printInstance()
{
	_x.printObj();
	_y.printObj();
}
