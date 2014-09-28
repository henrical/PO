#include <iostream>
#include <sstream>

#include "birthday.h"

Birthday::Birthday(int d, int m, int y)
{
	day = d;
	month = m;
	year = y;
}

std::string Birthday::getFormattedDate()
{
	std::stringstream stream;
	std::string result;

	stream << "Birth date: ";
	stream << day ;
	stream << "/";
	stream << month;
	stream << "/";
	stream << year;

	result = stream.str();
	

	//std::cout << "Birth date: " << day << "/" << month << "/" << year <<std::endl;
	return result;
}

