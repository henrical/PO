#include "agency.h"
#include <iostream>

Agency::Agency()
{
}

void Agency::support(Beneficiary &b, int n) const
{
	b.distributeFunds(n);
}
