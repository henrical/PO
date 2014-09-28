#include <iostream>

#include "birthday.h"
#include "person.h"

using namespace std;

int main()
{
	string result;
	Birthday b(2, 3 ,1994);
	result = b.getFormattedDate();
	cout << result <<endl;
}
