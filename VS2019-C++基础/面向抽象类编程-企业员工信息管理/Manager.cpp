#include "Manager.h"

Manager::Manager()
{
	this->fixedSalary = 8000;
}

Manager::Manager(std::string name):Employee(name)
{
	this->fixedSalary = 8000;
}

Manager::~Manager()
{
}

void Manager::pay()
{
	this->salary = this->fixedSalary;
}

void Manager::upLevel()
{
	this->level++;
	this->fixedSalary += 1000;
}
