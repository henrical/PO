#ifndef _SQUARE_H
#define _SQUARE_H

#include "transform.h"

class Square : public Transform
{
	public:
		explicit Square();
		void transform(int t[]);
};

#endif
