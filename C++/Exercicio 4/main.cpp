#include <iostream>

#include "EconomicCar.h"
#include "EconomicEngine.h"
#include "MediumCar.h"
#include "TopCar.h"


int main()
{
	
	EconomicEngine *eE1 = new EconomicEngine();
	EconomicEngine *eE2 = new EconomicEngine();
	EconomicEngine *eE3 = new EconomicEngine();
 	XtremeEngine *xE1 = new XtremeEngine();


	EconomicCar eC(*eE1);
	MediumCar mC(*eE2);
	TopCar tC(*eE1, *xE1);

	eC.drive();
	eC.stop();

	
	

}
