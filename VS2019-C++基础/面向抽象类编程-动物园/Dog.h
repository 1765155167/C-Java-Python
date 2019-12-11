#pragma once
#include "AnimalInterFace.h"
class Dog :
	public AnimalInterFace
{
public:
	virtual void voice();
	~Dog();
};

