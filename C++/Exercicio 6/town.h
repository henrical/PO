#ifndef _TOWN_H_
#define _TOWN_H_

#include "regionmember.h"
#include "individual.h"

class Town : public RegionMember
{
	public:
		Individual *memberList;
	
		void distributeFunds(int n);
		explicit Town(int n, int sLevel);
		~Town();

		int getFundsReceived() const;
};

#endif
