#include "AnimalInterFace.h"

AnimalInterFace::~AnimalInterFace()
{
	std::cout << "~AnimalInterFace()" << std::endl;
}

void Voice(AnimalInterFace* p)
{
	p->voice();
}

void Voice(AnimalInterFace* p, bool d)
{
	Voice(p);
	if (p != NULL && d)
	{
		delete p;
	}
}
