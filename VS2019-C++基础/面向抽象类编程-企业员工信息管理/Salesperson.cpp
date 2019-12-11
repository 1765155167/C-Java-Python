#include "Salesperson.h"

Salesperson::Salesperson():salesDegree(0)
{
}

Salesperson::Salesperson(double salesDegree, std::string name)
	:Employee(name), salesDegree(salesDegree)
{
}

Salesperson::~Salesperson()
{
}

void Salesperson::pay()
{
	this->salary = this->salesDegree * 0.04;
}

void Salesperson::upLevel()
{
	this->level = 1;
}
