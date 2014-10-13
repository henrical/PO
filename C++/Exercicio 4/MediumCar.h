#ifndef MEDIUMCAR_H
#define MEDIUMCAR_H

#include "EconomicEngine.h"
#include "EconomicCar.h"

class MediumCar : public EconomicCar 
{
	public:
		MediumCar(EconomicEngine x);

		void changeEngine(EconomicEngine x);
};

#endif
