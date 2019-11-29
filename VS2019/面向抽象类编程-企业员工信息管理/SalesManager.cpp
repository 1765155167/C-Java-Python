#include "SalesManager.h"

SalesManager::SalesManager(double salesDegree, std::string name)
{
	this->name = name;
	this->salesDegree = salesDegree;//销售总额
	this->fixedSalary = 4000;//固定薪资
}

SalesManager::~SalesManager()
{
}

void SalesManager::pay()
{
	this->salary = this->fixedSalary + this->salesDegree * 0.05;
}

void SalesManager::upLevel()
{
	this->level++;
	this->fixedSalary += 1000;
}
