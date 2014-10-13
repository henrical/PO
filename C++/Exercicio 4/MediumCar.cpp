#include <iostream>

#include "MediumCar.h"


MediumCar::MediumCar(EconomicEngine &x)
:EconomicCar(x)
{
}



void MediumCar::changeEngine(EconomicEngine x)
{
	eng = x;
}
