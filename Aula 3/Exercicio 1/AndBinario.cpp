#include <iostream>

#include "AndBinario.h"


AndGate2::AndGate2()
{

	valueA = false;
	valueB = false;
}

AndGate2::AndGate2(bool a)
{
	valueA = a;
	valueB = a;
}

AndGate2::AndGate2(bool a, bool b)
{
	valueA = a;
	valueB = b;
}

std::string AndGate2::toString()
{
	std::string a,b;

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

	stream << "A: ";
	stream << a; 
	stream << " B: ";
	stream << b;
	//stream << std::endl;
	
	result = stream.str();

	return result;

}

void AndGate2::setValue(bool a)
{
	valueA = a;
	valueB = a;

}

bool AndGate2::getOutput()
{
	
	if(valueA==true)
	{
		if(valueB==true)
			return true;
		else
			return false;
	}

	if(valueA==false)
		return false;
}


void AndGate2::setValue(bool a, bool b)
{
	valueA = a;
	valueB = b;

}

bool AndGate2::operator==(AndGate2 a) //overriding of operator ==
{
	if(valueA==a.valueA)
	{
		if(valueB==a.valueB)
			return true;
	}

	else 
		return false;
}





