#include <iostream>

#include "TopCar.h"

TopCar::TopCar(EconomicEngine e1, XtremeEngine e2)
:MediumCar(e1), secEng(e2)
{
}

void TopCar::changeSecEngine(XtremeEngine e)
{
	secEng = e;
}

void TopCar::drive()
{
	EconomicCar::drive();
	secEng.turnOn();
}

void TopCar::stop()
{
	EconomicCar::stop();
	secEng.turnOff();
}
