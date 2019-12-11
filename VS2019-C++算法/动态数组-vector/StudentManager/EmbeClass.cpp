#include "EmbeClass.h"

EmbeClass::EmbeClass()
{
}

EmbeClass::~EmbeClass()
{
}

void EmbeClass::show()
{
	for (auto it = this->stu.begin();
		it != this->stu.end(); it++)
	{
		AbstractStudent* p = (*it).second;
		p->show();
	}
}

bool EmbeClass::add(AbstractStudent* p)
{
	if (p != NULL) {
		this->stu.insert(make_pair(p->getId(), p));
		return true;
	}
	return false;
}

bool EmbeClass::del(AbstractStudent* p)
{
	return false;
}
