#ifndef CHILD_H
#define CHILD_H

class Child
{	
	friend class Mother;	

	public:
		Child(int a, std::string n);
		std::string printChild();
	protected:	
		void setName(std::string n);		
	private:
		int age;
		std::string name;
};

#endif

