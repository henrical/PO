#ifndef _BENEFICIARY_H_
#define _BENEFICIARY_H_

class Beneficiary
{
	private:
		int supportLevel;
		int funds;
	public:
		void initFunds();
		void addFunds(int &n);
		void setSupportLevel(int n);
		int getFunds() const;
		int getSupportLevel() const;
};

#endif
