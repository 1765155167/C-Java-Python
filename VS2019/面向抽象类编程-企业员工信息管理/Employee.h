#pragma once
#include <iostream>
#include <string>

class Employee
{
public:
	Employee();
	Employee(std::string name);
	virtual ~Employee();
	//计算员工薪资
	virtual void pay() = 0;
	//打印员工信息
	void displayStatus();
	//提升级别
	virtual void upLevel() = 0;
protected:
	std::string name;//姓名
	size_t id;//编号
	size_t level;//级别
	double salary;//薪水
	static size_t sum;//员工人数，假设无离职情况
};

