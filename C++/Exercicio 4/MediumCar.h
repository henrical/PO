#ifndef MEDIUMCAR_H
#define MEDIUMCAR_H

#include "EconomicEngine.h"
#include "EconomicCar.h"

class MediumCar : public EconomicCar 
{
	public:
		MediumCar(const EconomicEngine &x);

		void changeEngine(const EconomicEngine &x);
};

#endif
