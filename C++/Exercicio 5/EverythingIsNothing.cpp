#include <iostream>
#include <cstdlib>
#include <cstring>
//=====================================================
class Transform
{
	public:
		virtual void transform(int t[]) = 0;
};
//=====================================================
class Table 
{
	private:
		int *table;
	public:
		Table(int n);
		void print(Transform *t) const;
		
};

Table::Table(int n)
{ 
	table = (int*) malloc(n*sizeof(int));

	memset(table, 0, n);
}

void Table::print(Transform *t) const
{
	t->transform(table);
}
//=====================================================
class Successor : public Transform
{
	public:
		explicit Successor();
	 	void transform(int t[]);
};

Successor::Successor(){};

void Successor::transform(int t[])
{
	int i=0;
	int n = sizeof(t) - 1;

	for(i;i<n;i++)
	{
		std::cout << t[i] + 1 << std::endl;	
	}
	
}
//=====================================================
class Square : public Transform
{
	public:
		explicit Square();
		void transform(int t[]);
};

Square::Square(){};

void Square::transform(int t[])
{
	int i=0;
	int n = sizeof(t) - 1;

	for(i;i<n;i++)
	{
		std::cout << (t[i] * t[i]) << std::endl;	
	}
}
//=====================================================
int main ()
{
 	Table t(3);
	t.print(new Square);
	t.print(new Successor);
}

