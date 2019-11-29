#pragma once
#include "Employee.h"
class Technical :
	public Employee
{
public:
	Technical(size_t time_month, std::string name);
	//计算员工薪资
	virtual void pay();
	//提升级别
	virtual void upLevel();
	void setTimeMonth(size_t timeMonth);
	~Technical();
private:
	size_t timeMonth;//一个月工作了多少小时
	int hourMoney;
};

