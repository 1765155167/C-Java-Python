#pragma once
#include "AnimalInterFace.h"
class Cat :
	public AnimalInterFace
{
public:
	virtual void voice();
	~Cat();
};

