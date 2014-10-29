#include "agency.h"
#include "beneficiary.h"
#include "region.h"
#include "regionmember.h"
#include "individual.h"
#include "town.h"
#include <iostream>
int main()
{
	int i;

	Agency a;
	Region r(3, 4);

	Town t(2, 1);
	t.memberList[0] = Individual(1);
	t.memberList[1] = Individual(2);

	Individual i1(1);
	Individual i2(2);

	r.memberList[0] = i1;
	r.memberList[1] = i2;
	r.memberList[2] = t;

	a.support(r, 6);	

	std::cout << "-> Region has " << r.getFundsReceived() << " dollars." << std::endl;
	/*
	for(i=0 ; i<sizeof(r.memberList) - 1; i++)
	{
		std::cout << "-> Member number " << i+1 << " of region has " << r.memberList[i].getFundsReceived() << " dollars." << std::endl;
	}
	*/	

	return 0;
}
