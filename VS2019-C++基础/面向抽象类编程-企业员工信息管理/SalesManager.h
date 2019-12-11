#pragma once
#include "Salesperson.h"
#include "Manager.h"
class SalesManager :
	public Salesperson, public Manager
{
public:
	SalesManager(double salesDegree, std::string name);
	~SalesManager();
	//计算员工薪资
	virtual void pay();
	//提升级别
	virtual void upLevel();
private:

};

