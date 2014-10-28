#include "region.h"
#include <cstdlib>

Region::Region(int n, int sLevel)
{
	memberList = (RegionMember*) malloc(sizeof(RegionMember)*n);
	setSupportLevel(sLevel);
	initFunds();	
} 

void Region::distributeFunds(int n)
{
	int length = sizeof(memberList);
	int i = 0;

	int amount = n / length;

	while(i<length)
	{
		memberList[i].addFunds(amount);;
	}
}
