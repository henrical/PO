#ifndef CAT_H
#define CAT_H

using namespace std;

class Cat
{	
	private:
		string _name;
		int _age;
		float _weight;
	public:
		Cat(string, int, float);

		void setName(string name);

		string getName();
		int getAge();
		float getWeight();

		string printCat();
};

#endif //CAT_H
