#ifndef ANDGATE3_H
#define ANDGATE3_H
#include <sstream>

#include "../Exercicio 1/AndBinario.h"


class AndGate3 : public AndGate2
{
	public:
		AndGate3();
		AndGate3(bool a, bool b, bool c);

		std::string toString();
		

	private:
		bool valueC;
		
};



#endif
