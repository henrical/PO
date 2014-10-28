#ifndef _AGENCY_H_
#define _AGENCY_H_

#include "beneficiary.h"

class Agency
{
	public:
		explicit Agency();
		void support(Beneficiary &b, int n) const;
};

#endif
