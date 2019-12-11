#pragma once
#include "AbstractStudent.h"
#include <iostream>
#include <string>
#include <map>

class AbstractClass
{
public:
	AbstractClass();
	AbstractClass(std::string name, std::string id);
	virtual void show() = 0;
	virtual bool add(AbstractStudent* p) = 0;
	virtual bool del(AbstractStudent* p) = 0;
	~AbstractClass();
protected:
	unsigned int sumStudent;
	std::string mName;
	std::string mId;
	std::map<std::string, AbstractStudent*> stu;
};

