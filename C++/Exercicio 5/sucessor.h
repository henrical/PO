#ifndef _SUCCESSOR_H
#define _SUCCESSOR_H

#include "transform.h"

class Successor : public Transform
{
	public:
		explicit Successor();
	 	void transform(int t[]);
};

#endif
