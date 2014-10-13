#include <iostream>

#include "EconomicCar.h"
#include "EconomicEngine.h"
#include "MediumCar.h"
#include "TopCar.h"


int main()
{
	EconomicEngine eE1;
	EconomicEngine eE2;
	EconomicEngine eE3;
	XtremeEngine xE1;

	EconomicCar eC(eE1);
	MediumCar mC(eE2);
	TopCar tC(eE3, xE1);

	eC.drive();
	eC.stop();

	mC.changeEngine(eE3);
        
	tC.drive();
	tC.stop();
}
