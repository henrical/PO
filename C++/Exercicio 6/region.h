#ifndef _REGION_H_
#define _REGION_H_

#include <vector>


class Region : public Beneficiary
{
	private:
		RegionMember *memberList;
	public:
		explicit Region();
		void distributeFunds() const;
};
