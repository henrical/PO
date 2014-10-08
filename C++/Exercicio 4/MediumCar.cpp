#include <iostream>

#include "MediumCar.h"


MediumCar::MediumCar(EconomicEngine x)
:EconomicCar(x)
{
}

MediumCar::MediumCar()
{
}

void MediumCar::changeEngine(EconomicEngine x)
{
	eng = x;
}
