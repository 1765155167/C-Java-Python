#include "AbstractClass.h"

AbstractClass::AbstractClass()
{
	this->sumStudent = 0;
}

AbstractClass::AbstractClass(std::string name, std::string id)
{
	this->mName = name;
	this->mId = id;
}

AbstractClass::~AbstractClass()
{
}
