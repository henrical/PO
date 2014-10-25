#include "agency.h"

Agency::Agency()
{
}

Agency::support(Beneficiary &b, int n) const
{
	b.funds += n;
}
