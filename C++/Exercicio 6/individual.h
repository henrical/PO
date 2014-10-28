#ifndef _INDIVIDUAL_H_
#define _INDIVIDUAL_H_

#include "regionmember.h"

class Individual : public RegionMember
{
	private:
		int funds;
	public:
		void distributeFunds(int n);
		explicit Individual(int sLevel);
		
		int getFundsReceived() const;
};

#endif
