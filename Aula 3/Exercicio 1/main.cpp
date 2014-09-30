#include <iostream>

#include "AndBinario.h"


int main()
{
	AndGate2 ag(true, false);
	AndGate2 ag2(false);
	AndGate2 ag3(); //not working for some misterious reason
	AndGate2 ag4(true,false);
	AndGate2 ag5(false,true);
	AndGate2 ag6(true);

	std::cout << ag.toString() << std::endl;
	std::cout <<"Output: " << std::boolalpha << ag.getOutput() << std::endl;
	std::cout <<"Comparing with 'ag4'(" << ag4.toString() << "). " << "Result: " << std::boolalpha << (ag==ag4) << std::endl; //(ag==ag4) needs the parentesis in order to compile

	std::cout << "==============================================================" << std::endl;

	std::cout << ag5.toString() << std::endl;
	std::cout <<"Output: " << std::boolalpha << ag5.getOutput() << std::endl;
	std::cout <<"Comparing with 'ag2'(" << ag2.toString() << "). " << "Result: " << std::boolalpha << (ag5==ag2) << std::endl;

	std::cout << "==============================================================" << std::endl;

	std::cout << ag6.toString() << std::endl;
	std::cout <<"Output: " << std::boolalpha << ag6.getOutput() << std::endl;
	std::cout <<"Comparing with 'ag5'(" << ag5.toString() << "). " << "Result: " << std::boolalpha << (ag6==ag5) << std::endl;
}
