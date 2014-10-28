#ifndef _REGION_MEMBER_H_
#define _REGION_MEMBER_H_

#include "beneficiary.h"

class RegionMember : public Beneficiary
{
	public:
		void distributeFunds(int n) = 0;
		int getFundsReceived() const = 0;
};

#endif
