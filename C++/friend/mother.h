#ifndef MOTHER_H
#define MOTHER_H

#include "child.h"

class Mother
{
	public:	
		Mother(int a, std::string n);
		void setChildName(Child &c, std::string n); //aqui
	private:
		std::string name;
		int age;
};

#endif
