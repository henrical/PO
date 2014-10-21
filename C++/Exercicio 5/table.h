#ifndef _TABLE_H
#define _TABLE_H

#include "transform.h"
#include "square.h"

class Table 
{
	private:
		int *table;
	public:
		Table(int n);
		void print(Transform *t) const;
		
};

#endif
