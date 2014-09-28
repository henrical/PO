#include <iostream>
#include <cstdlib>

#include "child.h"
#include "mother.h"
#include "../composition/birthday.h"

using namespace std;

//includes a useful "trick" to modify objects through referencing, see comments below
//referencing is:from pointer to pointee, dereferencing is from pointee to pointer

int main()
{
	Birthday b(2,3,1994);
	Child c(4, "gus", b);

	//c.setName("blargh");  -----> nao se pode fazer, so uma mae pode alterar o nome a um filho

	std::cout << c.printChild();
	
	std::cout << "========================" << std::endl;
	
	Mother m(25, "helen");
	
	/*ver implementaçao, foi passado objecto, mas a posiçao de memoria e que foi alterada, atraves do &*/ 	
	m.setChildName(c, "john");
	/* a classe Mother foi declarada como "friend", portanto tem acesso aos metodos protected de child (Child::setName())*/
	
	std::cout << c.printChild();
}
