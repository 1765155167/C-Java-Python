#include "Worker.h"
#include <iomanip>

Worker::Worker()
{
	this->age = 0;
	this->name = "";
	this->phone = "";
	this->salary = 0;
}

Worker::Worker(std::string name, std::string phone,
	unsigned int age, float salary)
{
	this->age = age;
	this->name = name;
	this->phone = phone;
	this->salary = salary;
}

void Worker::show()
{
	std::cout.setf(std::ios::left);
	std::cout << "姓名: " << std::setw(6) << this->name
		<< std::setw(2) << " 年龄: " << this->age
		<< std::setw(6) << " 薪资: " << this->salary
		<< std::setw(11) << " 电话: " << this->phone << std::endl;
}

Worker::~Worker()
{
}
