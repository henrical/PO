#ifndef ECONOMICCAR_H
#define ECONOMICCAR_H

#include "EconomicEngine.h"

class EconomicCar{
	private: 
		EconomicEngine eng;
	public:
		EconomicCar(EconomicEngine x);
		void drive();
		void stop();
};
#endif
