#include "Employee.h"

size_t Employee::sum = 0;

Employee::Employee()
{
	this->id = 1000 + this->sum;
	this->sum++;
	this->level = 1;
	this->salary = 0;
}

Employee::Employee(std::string name):name(name)
{
	this->id = 1000 + this->sum;
	this->sum++;
	this->level = 1;
	this->salary = 0;
}

Employee::~Employee()
{
}

void Employee::displayStatus()
{
	std::cout << "姓名:" << this->name 
		<< " 编号:" << this->id
		<< " 等级:" << this->level
		<< " 薪水:" << this->salary << std::endl;
}
