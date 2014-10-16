#ifndef _TABLE_H
#define _TABLE_H

#include "transform.h"

class Table 
{
	private:
		int *table;
	public:
		Table(int n);
		void print(Transform t);
};

#endif
