#pragma once
#include "Employee.h"
//销售人员
class Salesperson :
	virtual public Employee
{
public:
	Salesperson();
	Salesperson(double salesDegree, std::string name);
	~Salesperson();
	//计算员工薪资
	virtual void pay();
	//提升级别
	virtual void upLevel();
protected:
	double salesDegree;//销售额度
};

