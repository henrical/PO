#ifndef PERSON_H
#define PERSON_H

#include <string>

#include "birthday.h"

class Person {
	public:
		Person(std::string n, Birthday b);
		void printInfo();
	protected:
	private:
		std::string name;
		Birthday dateOfBirth;
};

#endif
