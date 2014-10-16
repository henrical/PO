#include <iostream>

#include "EconomicCar.h"

EconomicCar::EconomicCar(const EconomicEngine &x)
:eng(x)	
{
	
}



void EconomicCar::drive()
{
	eng.turnOn();
}

void EconomicCar::stop()
{
	eng.turnOff();
}
