#include <iostream>
#include <string>

//Henrique Caldeira, numero 75838

//class Animal ============================
class Animal
{
	friend std::ostream &operator<<(std::ostream &o, const Animal &a);	

	public:
		Animal(int a);	
		Animal(int a, std::string n);

		void sleep();

		bool operator==(const Animal &a);
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
	std::cout << "The animal '" << name << "' is sleeping." << std::endl;
}

bool Animal::operator==(const Animal &a) //overriding of operator ==
{
	return (age==a.age) && (name==a.name);
}

std::ostream &operator<<(std::ostream &o, const Animal &a)
{
	o << "Age: ";
	o << a.age;
	o << std::endl;
	o << "Name: ";
	o << a.name;
	o << std::endl;
	return o;

}
//end of Animal methods ===================




//class Dog ===============================
class Dog : public Animal
{
	friend std::ostream &operator<<(std::ostream &o, const Dog &d);

	public:
		Dog(int a, std::string n, double w);

		void bark();

		bool operator==(const Dog &d);
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

bool Dog::operator==(const Dog &d) //overriding of operator ==
{
	return (Animal::operator==(d)) && (weight==d.weight); //usa a funçao de Animal para comparar os dois primeiros atributos e depois faz And com o resultado da comparaçao do 3º atributo
}

std::ostream &operator<<(std::ostream &o, const Dog &d)
{
	o << (Animal)d; //calls the operator<< for animals
 	o << "Weight: ";//calls the normal <<
	o << d.weight;
	o << std::endl;
	return o; 
}
//end of Dog methods ======================




//class Cat ===============================
class Cat : public Animal
{
	friend std::ostream &operator<<(std::ostream &o, const Cat &c);

	public:	
		Cat(int a, std::string n, int nLives);

		void climb();

		bool operator==(const Cat &c);
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

bool Cat::operator==(const Cat &c) //overriding of operator ==
{
	return (Animal::operator==(c)) && (numLives==c.numLives); 
}

std::ostream &operator<<(std::ostream &o, const Cat &c)
{
	o << (Animal)c; //calls the operator<< for animals
	o << "Number of lives: "; //calls the normal <<
	o << c.numLives;
	o << std::endl;
	return o; 
}
//end of Cat methods ======================




int main()
{

	Animal a1(12, "animal 1");
	std::cout << a1; //operator<< redefinido para aceitar animais, alternativamnte podia-se utilizar 'operator<<(std::cout, a1);'

	a1.sleep();


	Animal a2(12, "animal 2");
	std::cout << std::boolalpha << (a1==a2) << std::endl; //imprime false
							      //(a1==a2) -> redefinimos o operator== para aceitar animais
							      //std::boolalpha -> permite imprimir boleanos
	
	Dog d(7, "sir pawsington", 13.5);
	std::cout << d; //operator<< redefinido para aceitar cães

	d.sleep(); //metodo sleep() herdado de animal

	d.bark();


	Cat c1(3, "mittens", 7);
	std::cout << c1; //operator<< redefinido para aceitar gatos

	Cat c2(3, "mittens", 7);
	std::cout << c2; //operator<< redefinido para aceitar gatos
	
	c2.climb();
		
	std::cout << std::boolalpha << (c1==c2) << std::endl; //retorna true
							      //uso do operator== definido para gatos

	return 0;
}
