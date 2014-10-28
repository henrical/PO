#ifndef _BENEFICIARY_H_
#define _BENEFICIARY_H_

class Beneficiary
{
	private:
		int supportLevel;
	public:
		void setSupportLevel(int n);
		int getFunds() const;
		int getSupportLevel() const;

		virtual void distributeFunds(int n) = 0;
		virtual int getFundsReceived() const = 0;
};

#endif
