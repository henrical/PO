#include <iostream>

using namespace std;

class TestClass 
{	
	private:
		string name;

	public :
		TestClass(string str)
		{
			name = str;
		}
		
		void setName(string str)
		{
			name = str;
		}

		string getName()
		{
			return name;
		}
		
		static void sleep()
		{
			cout <<"This class is sleeping" <<endl;
		}

};

int main()
{
	int a;
	int b;
	int sum;

	TestClass testObject("fuckerton");
	
	cout <<"This object is named " << testObject.getName() << "." <<endl;

	TestClass::sleep();
	/*
	cout <<"Enter a number boss!" <<endl;
	cin >> a;

	cout <<"Enter another number boss!" <<endl;

	cin >> b;

	sum = a + b;
	
	if(sum >= 3)
		cout <<"The result is : " << sum <<endl;
	else
		cout <<"The result " << sum << " is less than 3;" << endl;
	*/

	return 0;
}

