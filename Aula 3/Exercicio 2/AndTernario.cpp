#include <iostream>

#include "AndTernario.h"


AndGate3::AndGate3(bool a, bool b, bool c)
:AndGate2(a,b)
{
	/*
	valueA = a;
	valueB = b;*/
	valueC = c;
}

std::string AndGate3::toString()
{
	std::string a,b,c;

	std::string result;
	std::stringstream stream;
	
	if(valueA==true)
		a="true";
	else
		a="false";

	if(valueB==true)
		b="true";
	else
		b="false";

	if(valueC==true)
		c="true";
	else
		c="false";	

	stream << "A: ";
	stream << a; 
	stream << " B: ";
	stream << b;
	stream << " C: ";
	stream << c;
	//stream << std::endl;
	
	result = stream.str();

	return result;

}
