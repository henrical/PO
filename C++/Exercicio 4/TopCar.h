#ifndef TOPCAR_H
#define TOPCAR_H

#include "EconomicEngine.h"
#include "XtremeEngine.h"
#include "MediumCar.h"

class TopCar : public MediumCar
{
	public:
		XtremeEngine secEng;

		TopCar(const EconomicEngine &e1, const XtremeEngine &e2);

		void drive();
		
		void stop();
};

#endif
