#include <iostream>

#include "TopCar.h"

TopCar::TopCar(const EconomicEngine &e1, const XtremeEngine &e2)
:MediumCar(e1), secEng(e2)
{
}


void TopCar::drive()
{
	EconomicCar::drive(); //liga o 1º motor
	secEng.turnOn(); 
}

void TopCar::stop()
{
	EconomicCar::stop();
	secEng.turnOff();
}
