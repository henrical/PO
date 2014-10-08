#include <iostream>

#include "EconomicCar.h"
#include "EconomicEngine.h"
#include "MediumCar.h"
#include "TopCar.h"


int main()
{
	
	EconomicEngine *eE1 = new EconomicEngine();
	EconomicEngine eE2();
	XtremeEngine xE1();
	XtremeEngine xE2();


	EconomicCar eC(*eE1);
	//MediumCar mC = new MediumCar(eE2);
	

}
