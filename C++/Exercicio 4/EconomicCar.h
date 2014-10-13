#ifndef ECONOMICCAR_H
#define ECONOMICCAR_H

#include "EconomicEngine.h"

class EconomicCar{ 
		
	public:
		EconomicEngine eng;

		EconomicCar(EconomicEngine x);
		virtual void drive();
		virtual void stop();
};
#endif
