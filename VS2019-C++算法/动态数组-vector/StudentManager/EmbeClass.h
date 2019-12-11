#pragma once
#include "AbstractClass.h"
class EmbeClass :
	public AbstractClass
{
public:
	EmbeClass();
	~EmbeClass();
	virtual void show();
	virtual bool add(AbstractStudent* p);
	virtual bool del(AbstractStudent* p);
private:

};

