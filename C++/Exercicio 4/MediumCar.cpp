#include <iostream>

#include "MediumCar.h"


MediumCar::MediumCar(const EconomicEngine &x)
:EconomicCar(x)
{
}



void MediumCar::changeEngine(const EconomicEngine &x)
{
	eng = x;
}
