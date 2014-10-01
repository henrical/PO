#include <iostream>
#include <string>

//class Animal ============================
class Animal
{
	public:
		Animal(int a);	
		Animal(int a, std::string n);

		void sleep();

		bool operator==(Animal a);
	private:
		int age;
		std::string name;
};
//Animal instance methods =================
Animal::Animal(int a)
{
	age = a;
	name = "";
}

Animal::Animal(int a, std::string n)
{
	age = a;
	name = n;
}

void Animal::sleep()
{
	std::cout << "The animal " << name << "is sleeping." << std::endl;
}

bool Animal::operator==(Animal a) //overriding of operator ==
{
	return (age==a.age) && (name==a.name);
}
//end of Animal methods ===================




//class Dog ===============================
class Dog : public Animal
{
	public:
		Dog(int a, std::string n, double w);

		void bark();

		bool operator==(Dog d);
	private:
		double weight;

};
//Dog instance methods ====================
Dog::Dog(int a, std::string n, double w)
: Animal(a,n), weight(w)
{}

void Dog::bark()
{
	std::cout << "This dog is barking" << std::endl ;
}

bool Dog::operator==(Dog d) //overriding of operator ==
{
	//return (==d);  ??? call superclass operator== ???
}
//end of Dog methods ======================




//class Cat ===============================
class Cat : public Animal
{
	public:	
		Cat(int a, std::string n, int nLives);

		void climb();
	private:
		int numLives;

};
//Cat instance methods ====================
Cat::Cat(int a, std::string n, int nLives)
: Animal(a,n), numLives(nLives)
{}

void Cat::climb()
{
	std::cout << "This cat is climbing" << std::endl ;
}
//end of Cat methods ======================




int main()
{
	return 0;
}
