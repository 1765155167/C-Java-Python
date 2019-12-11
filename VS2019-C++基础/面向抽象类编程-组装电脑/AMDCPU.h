#pragma once
#include "CPU.h"

class AMDCPU:public CPU
{
public:
	AMDCPU();
	virtual void calculate();
	~AMDCPU();
};

