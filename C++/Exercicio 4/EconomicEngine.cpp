#include <iostream>

#include "EconomicEngine.h"

EconomicEngine::EconomicEngine()
{
	isOn = false;
}

void EconomicEngine::turnOn()
{
	isOn = true;
}

void EconomicEngine::turnOff()
{
	isOn = false;
}
