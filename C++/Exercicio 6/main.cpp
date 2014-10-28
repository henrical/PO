#include "agency.h"
#include "beneficiary.h"
#include "region.h"
#include "regionmember.h"

#include <iostream>

//fazer deletes com free

int main()
{
	Agency a;
	Region r(3, 4);
	a.support(r, 5);
	
	std::cout << "-> Beneficiary r has " << r.getFunds() << " dollars." << std::endl;

	return 0;
}
