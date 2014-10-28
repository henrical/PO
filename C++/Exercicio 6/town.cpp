#include "town.h"

#include <cstdlib>

Town::Town(int n, int sLevel)
{	
	
	memberList = (Individual*) malloc(sizeof(Individual)*n);
	setSupportLevel(sLevel);
	
}

Town::~Town()
{
	free(memberList);
} 


void Town::distributeFunds(int n)
{
	int length = sizeof(memberList);
	int i = 0;

	int amount = n / length;

	while(i<length)
	{
		memberList[i].distributeFunds(amount);;
	}
}

int Town::getFundsReceived() const
{
	int length = sizeof(memberList);
	int i = 0;
	int amount = 0;

	while(i<length)
	{
		amount += memberList[i].getFundsReceived();
		i++;
	}
	
	return amount;
}
