#include "AnimalInterFace.h"

AnimalInterFace::~AnimalInterFace()
{
	std::cout << "~AnimalInterFace()" << std::endl;
}

void Voice(AnimalInterFace* p)
{
	if (p != NULL)
	{
		p->voice();
	}
}

void Voice(AnimalInterFace* p, bool d)
{
	Voice(p);
	if (p != NULL && d)
	{
		delete p;
	}
}
