#pragma once
#include "Employee.h"
class Manager :
	virtual public Employee
{
public:
	Manager();
	Manager(std::string name);
	~Manager();
	//计算员工薪资
	virtual void pay();
	//提升级别
	virtual void upLevel();
public:
	double fixedSalary;//固定薪资
};

