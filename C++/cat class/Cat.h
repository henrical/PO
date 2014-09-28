#ifndef CAT_H
#define CAT_H

class Cat
{	
	private:
		std::string _name;
		int _age;
		float _weight;
	public:
		Cat(std::string, int, float);

		void setName(std::string name);

		std::string getName();
		int getAge();
		float getWeight();

		std::string printCat();
};

#endif //CAT_H
