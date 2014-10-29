#ifndef _REGION_MEMBER_H_
#define _REGION_MEMBER_H_

#include "beneficiary.h"

class RegionMember : public Beneficiary
{
	public:
		virtual void distributeFunds(int n);
		virtual int getFundsReceived() const ;
};

#endif
