#ifndef _REGION_H_
#define _REGION_H_

//#include <vector>
#include "beneficiary.h"
#include "regionmember.h"

class Region : public Beneficiary
{
		
	public:
		RegionMember *memberList;

		explicit Region(int n, int sLevel);
		~Region();
		

		void distributeFunds(int n);

		int getFundsReceived() const;
};

#endif
