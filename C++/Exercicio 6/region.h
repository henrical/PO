#ifndef _REGION_H_
#define _REGION_H_

//#include <vector>
#include "beneficiary.h"
#include "regionmember.h"

class Region : public Beneficiary
{
	private:
		
	public:
		RegionMember *memberList;

		explicit Region(int n, int sLevel);
		void distributeFunds(int n);
};

#endif
