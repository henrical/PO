#ifndef TOPCAR_H
#define TOPCAR_H

#include "EconomicEngine.h"
#include "XtremeEngine.h"
#include "MediumCar.h"

class TopCar : public MediumCar
{
	public:
		XtremeEngine secEng;

		TopCar(EconomicEngine e1, XtremeEngine e2);

		void changeSecEngine(XtremeEngine e2);

		void drive();
		
		void stop();
};

#endif
