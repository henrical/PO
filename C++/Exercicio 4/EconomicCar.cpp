#include <iostream>

#include "EconomicCar.h"

EconomicCar::EconomicCar(EconomicEngine x)
:eng(x)	
{
}

EconomicCar::EconomicCar(){} // --> ??must exist because subclass's constructor calls it??

void EconomicCar::drive()
{
	eng.turnOn();
}

void EconomicCar::stop()
{
	eng.turnOff();
}
