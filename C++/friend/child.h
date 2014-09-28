#ifndef CHILD_H
#define CHILD_H

#include "../composition/birthday.h"

class Child
{	
	friend class Mother;	

	public:
		Child(int a, std::string n, Birthday b);
		std::string printChild();
	protected:	
		void setName(std::string n);		
	private:
		int age;
		std::string name;
		Birthday dateOfBirth;
};

#endif

