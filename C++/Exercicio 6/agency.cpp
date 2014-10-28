#include "agency.h"
#include <iostream>

Agency::Agency()
{
}

void Agency::support(Beneficiary &b, int n) const
{
	b.addFunds(n);
	std::cout << "-> " << n << " dollars added to beneficiary" << std::endl;
}
