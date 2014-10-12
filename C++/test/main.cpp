#include <iostream>
#include "usesSub.h"


int main()
{
	super s(13);
	sub s2(15);
	s.printObj();
	s2.printObj();
	usesSub u(s2,s);
	u.printInstance();
}
