#include <iostream>

#include "birthday.h"
#include "person.h"

using namespace std;

int main()
{

	Birthday b(2, 3 ,1994);

	Person p("Henrique", b);

	p.printInfo();

}
