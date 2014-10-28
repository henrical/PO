#include "individual.h"

Individual::Individual(int sLevel)
{
	setSupportLevel(sLevel);
}

void Individual::distributeFunds(int n)
{
	funds += n;
}

int Individual::getFundsReceived() const
{
	return funds;
}
