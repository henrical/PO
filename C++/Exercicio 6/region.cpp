#include "region.h"
#include <cstdlib>

Region::Region(int n, int sLevel)
{
	memberList = new RegionMember[n];
	/*memberList = (RegionMember*) malloc(sizeof(RegionMember)*n);*/
	setSupportLevel(sLevel);	
}

Region::~Region()
{
	free(memberList);
} 

void Region::distributeFunds(int n)
{
	int length = sizeof(memberList) - 1;
	int i = 0;

	int amount = n / length;

	while(i<length)
	{
		memberList[i].distributeFunds(amount);
		i++;
	}
}

int Region::getFundsReceived() const
{
	int length = sizeof(memberList) - 1;
	int i = 0;
	int amount = 0;

	while(i<length)
	{
		amount += memberList[i].getFundsReceived();
		i++;
	}
	
	return amount;
}


