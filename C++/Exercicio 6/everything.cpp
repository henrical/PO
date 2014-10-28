#include <iostream>
#include <cstdlib>
//=============================================================
class Agency
{
	public:
		explicit Agency();
		void support(Beneficiary &b, int n) const;
};

Agency::Agency()
{
}

void Agency::support(Beneficiary &b, int n) const
{
	b.distributeFunds(n);
}
//=============================================================
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

int Beneficiary::getSupportLevel() const
{
	return supportLevel;
}

void Beneficiary::setSupportLevel(int n)
{
	supportLevel = n;
}
//=============================================================
class Region : public Beneficiary
{
		
	public:
		RegionMember *memberList;

		explicit Region(int n, int sLevel);
		~Region();
		

		void distributeFunds(int n);

		int getFundsReceived() const;
};

Region::Region(int n, int sLevel)
{
	memberList = (RegionMember*) malloc(sizeof(RegionMember)*n);
	setSupportLevel(sLevel);	
}

Region::~Region()
{
	free(memberList);
} 

void Region::distributeFunds(int n)
{
	int length = sizeof(memberList);
	int i = 0;

	int amount = n / length;

	while(i<length)
	{
		memberList[i].distributeFunds(amount);
		i++;
	}
}

int Region::getFundsReceived() const
{
	int length = sizeof(memberList);
	int i = 0;
	int amount = 0;

	while(i<length)
	{
		amount += memberList[i].getFundsReceived();
		i++;
	}
	
	return amount;
}
//=============================================================
class RegionMember : public Beneficiary
{
	public:
		void distributeFunds(int n) = 0;
		int getFundsReceived() const = 0;
};
//=============================================================
class Individual : public RegionMember
{
	private:
		int funds;
	public:
		void distributeFunds(int n);
		explicit Individual(int sLevel);
		
		int getFundsReceived() const;
};

Individual::Individual(int sLevel)
{
	setSupportLevel(sLevel);
}

void Individual::distributeFunds(int n)
{
	funds += n;
}

int Individual::getFundsReceived() const
{
	return funds;
}
//=============================================================
class Town : public RegionMember
{
	public:
		Individual *memberList;
	
		void distributeFunds(int n);
		explicit Town(int n, int sLevel);
		~Town();

		int getFundsReceived() const;
};

Town::Town(int n, int sLevel)
{	
	
	memberList = (Individual*) malloc(sizeof(Individual)*n);
	setSupportLevel(sLevel);
	
}

Town::~Town()
{
	free(memberList);
} 


void Town::distributeFunds(int n)
{
	int length = sizeof(memberList);
	int i = 0;

	int amount = n / length;

	while(i<length)
	{
		memberList[i].distributeFunds(amount);;
	}
}

int Town::getFundsReceived() const
{
	int length = sizeof(memberList);
	int i = 0;
	int amount = 0;

	while(i<length)
	{
		amount += memberList[i].getFundsReceived();
		i++;
	}
	
	return amount;
}
//=============================================================
int main()
{
	int i;

	Agency a;
	Region r(3, 4);

	Town t(2, 1);
	t.memberList[0] = Individual(1);
	t.memberList[1] = Individual(2);

	Individual i1(1);
	Individual i2(2);

	r.memberList[0] = i1;
	r.memberList[1] = i2;
	r.memberList[2] = t;

	a.support(r, 6);	

	std::cout << "-> Region has " << r.getFundsReceived() << " dollars." << std::endl;
	
	for(i=0 ; i<sizeof(r.memberList); i++)
	{
		std::cout << "-> Member number " << i+1 << " of region has " << r.memberList[i].getFundsReceived() << " dollars." << std::endl;
	}	

	return 0;
}
