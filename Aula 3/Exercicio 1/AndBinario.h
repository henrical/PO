#ifndef ANDGATE2_H
#define ANDGATE2_H

#include <sstream>

class AndGate2
{
	public:
		AndGate2();
		AndGate2(bool a);
		AndGate2(bool a, bool b);

		void setValue(bool a);
		void setValue(bool a, bool b);

		bool getOutput();
		bool operator==(AndGate2 a);

		std::string toString();

	private:
		bool valueA;
		bool valueB;
};

#endif
