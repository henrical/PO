#include <iostream>
#include <cstdlib>

#include "child.h"
#include "mother.h"

using namespace std;

int main()
{
	Child c(4, "gus");

	std::cout << c.printChild();
	
	std::cout << "========================" << std::endl;
	
	Mother m(25, "helen");
	
	/*ver implementaçao, foi passado objecto, mas a posiçao de memoria e que foi alterada, atraves do &*/ 	
	m.setChildName(c, "john");
	/* a classe Mother foi declarada como "friend", portanto tem acesso aos metodos protected de child (setName)*/
	
	std::cout << c.printChild();
}
