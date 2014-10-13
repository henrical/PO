#include <iostream>

#include "TopCar.h"

TopCar::TopCar(EconomicEngine &e1, XtremeEngine &e2)
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
